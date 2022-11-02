package com.cxaou.thetestsystem.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxaou.thetestsystem.dto.TestQuestionsDto;
import com.cxaou.thetestsystem.pojo.ExaminationPaper;
import com.cxaou.thetestsystem.pojo.TestQuestions;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.service.ExaminationPaperService;
import com.cxaou.thetestsystem.mapper.ExaminationPaperMapper;
import com.cxaou.thetestsystem.service.TestQuestionsService;
import com.cxaou.thetestsystem.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Service
@Transactional
public class ExaminationPaperServiceImpl extends ServiceImpl<ExaminationPaperMapper, ExaminationPaper>
        implements ExaminationPaperService {

    @Autowired
    private UserService userService;


    @Autowired
    private TestQuestionsService testQuestionsService;

    /**
     * @param currentUserId        当前用户的id
     * @param examinationPaper     试卷对象
     * @param testQuestionsDtoList 试题对象
     * @return 是否添加成功
     */
    @Override
    public boolean addExaminationPaper(Long currentUserId, ExaminationPaper examinationPaper, List<TestQuestionsDto> testQuestionsDtoList) {
        // 保存试卷对象
        User currentUser = userService.getById(currentUserId);
        // 验证权限，只有教师跟管理员有添加试卷的权限
        if (currentUser.getIdentity() == 2) {
            return false;
        }
        // 设置字段
        examinationPaper.setCreateName(currentUserId);
        examinationPaper.setUpdateName(currentUserId);
        examinationPaper.setUpdateTime(LocalDate.now());
        examinationPaper.setCreateTime(LocalDate.now());
        // 保存
        this.save(examinationPaper);
        // 保存试题表对象
        List<TestQuestions> testQuestionsList = testQuestionsDtoList.stream().map(testQuestionsDto -> {
            TestQuestions testQuestions = new TestQuestions();
            BeanUtils.copyProperties(testQuestionsDto, testQuestions);
            // 把选项答案map对象转换成字符串
            testQuestions.setOptions(JSON.toJSONString(testQuestionsDto.getOptionsMap()));
            // 设置试卷表的id
            testQuestions.setExaminationPaperId(examinationPaper.getId());
            return testQuestions;
        }).collect(Collectors.toList());
        // 保存试题表的对象
        testQuestionsService.saveBatch(testQuestionsList);
        return true;
    }

    /**
     * @param currentUserId    当前用户的id
     * @param examinationPaper 试卷对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateExaminationPaper(Long currentUserId, ExaminationPaper examinationPaper) {
        ExaminationPaper examinationPaperSQL = this.getById(examinationPaper.getId());
        if (!verifyCurrentUser(currentUserId, examinationPaperSQL)) {
            return false;
        }
        examinationPaper.setUpdateTime(LocalDate.now());
        examinationPaper.setUpdateName(currentUserId);
        return this.saveOrUpdate(examinationPaper);
    }

    /**
     * @param currentUserId    当前用户的id
     * @param examinationPaper 试卷对象
     * @return
     */
    @Override
    public boolean deleteExaminationPaper(Long currentUserId, ExaminationPaper examinationPaper) {
        ExaminationPaper examinationPaperById = this.getById(examinationPaper.getId());
        if (!verifyCurrentUser(currentUserId, examinationPaperById)) {
            return false;
        }
        // 删除试卷的同时，删除试题
        this.removeById(examinationPaperById.getId());
        LambdaQueryWrapper<TestQuestions> questionsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        questionsLambdaQueryWrapper.eq(TestQuestions::getExaminationPaperId, examinationPaperById.getId());
        testQuestionsService.remove(questionsLambdaQueryWrapper);
        return true;
    }

    /**
     * @param pageInfo      分页对象
     * @param title         标题
     * @param currentUserId 当前用户的id
     * @return
     */
    @Override
    public boolean getOwnAllExaminationPaper(Page<ExaminationPaper> pageInfo, String title, Long currentUserId) {
        User currentUser = userService.getById(currentUserId);
        if (currentUser.getIdentity() == 2) {
            return false;
        }
        LambdaQueryWrapper<ExaminationPaper> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(title != null, ExaminationPaper::getTitle, title)
                .eq(ExaminationPaper::getCreateName, currentUserId);
        this.page(pageInfo, queryWrapper);
        return true;
    }

    /**
     * @param currentUserId       当前用户id
     * @param examinationPaperSQL 数据库查出来的试卷对象
     * @return 有权限返回true ，否则返回 false
     */
    public boolean verifyCurrentUser(Long currentUserId, ExaminationPaper examinationPaperSQL) {
        User currentUser = userService.getById(currentUserId);
        if (examinationPaperSQL == null) { // 数据库不存在中存在
            return false;
        }

        if (currentUser.getIdentity() == 2) {
            return false;
        }
        if (currentUser.getIdentity() != 0) {
            return examinationPaperSQL.getCreateName().equals(currentUserId);
        }
        return true;
    }
}




