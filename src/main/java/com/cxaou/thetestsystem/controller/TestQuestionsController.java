package com.cxaou.thetestsystem.controller;

import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.dto.TestQuestionsDto;
import com.cxaou.thetestsystem.pojo.ExaminationPaper;
import com.cxaou.thetestsystem.pojo.TestQuestions;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.service.ExaminationPaperService;
import com.cxaou.thetestsystem.service.TestQuestionsService;
import com.cxaou.thetestsystem.service.UserService;
import com.cxaou.thetestsystem.utils.VerifyExaminationPaperUtils;
import com.cxaou.thetestsystem.vo.ExaminationPaperVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Api(tags = "试题接口")
@RequestMapping("/test_questions")
@RestController()
public class TestQuestionsController {

    @Autowired
    private TestQuestionsService testQuestionsService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private ExaminationPaperService examinationPaperService;

    // 根据试卷id获取到试题对象
    @GetMapping("own_publish")
    @ApiOperation(value = "根据试卷id查询到全部试题信息")
    @ApiImplicitParam(value = "试卷的id", name = "id", dataType = "Long")
    public R<ExaminationPaperVo> getOwnPublish(HttpServletRequest request, Long id) {
        if (id == null) {
            return R.error("参数不合法");
        }
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        User currentUser = userService.getById(currentUserId);
        ExaminationPaper examinationPaper = examinationPaperService.getById(id);
        if (examinationPaper == null) {
            return R.error("试卷对象不存在");
        }
        if (currentUser.getIdentity() != 0) {
            if (!examinationPaper.getCreateName().equals(currentUserId)) {
                return R.error("权限不够");
            }
        }
        ExaminationPaperVo topic = testQuestionsService.getTopic(id);
        return R.success(topic);
    }


    @ApiOperation(value = "修改/添加，带试题id就是修改，不然那就是添加 试题的信息")
    @PutMapping
    public R<String> updateTestQuestion(HttpServletRequest request, @RequestBody TestQuestionsDto testQuestionsDto) {
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        if (VerifyExaminationPaperUtils.isNullCoreTestQuestionsDtoParameter(testQuestionsDto)) {
            return R.error("参数不合法");
        }

        if (testQuestionsDto.getScore() < 0) {
            return R.error("分数参数不合法");
        }

        ExaminationPaper examinationPaperServiceById = examinationPaperService.getById(testQuestionsDto.getExaminationPaperId());
        if (examinationPaperServiceById == null) {
            return R.error("试卷对象不存在");
        }
        testQuestionsDto.setExaminationPaperId(testQuestionsDto.getExaminationPaperId());
        User currentUser = userService.getById(currentUserId);
        if (currentUser.getIdentity() != 0) {
            if (!examinationPaperServiceById.getCreateName().equals(currentUserId)) {
                return R.error("权限不够");
            }
        }
        TestQuestions testQuestions = testQuestionsService.getById(testQuestionsDto.getId());

        Double oldScore = 0.0;
        if (testQuestions != null){
            oldScore = testQuestions.getScore();
        }

        testQuestionsService.updateTestQuestionService(testQuestionsDto, oldScore);
        return R.success("更新成功");

    }




    @DeleteMapping()
    @ApiOperation("删除试题")
    @ApiImplicitParam(name = "id",value = "试题的id",dataType = "Long")
    public R<String> delete(HttpServletRequest request,Long id){
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        User currentUser = userService.getById(currentUserId);

        TestQuestions testQuestions = testQuestionsService.getById(id);
        if (testQuestions == null){
            return R.error("试题对象不存在");
        }
        ExaminationPaper examinationPaperServiceById = examinationPaperService.getById(testQuestions.getExaminationPaperId());
        if (currentUser.getIdentity() != 0) {
            if (!examinationPaperServiceById.getCreateName().equals(currentUserId)) {
                return R.error("权限不够");
            }
        }
        boolean is_remove = testQuestionsService.removeById(id);
        examinationPaperService.updateScore(examinationPaperServiceById.getId(),testQuestions.getScore(),0.0);
        return is_remove ? R.success("成功"):R.error("失败");
    }
}
