package com.cxaou.thetestsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.dto.TestQuestionsDto;
import com.cxaou.thetestsystem.pojo.ExaminationPaper;
import com.cxaou.thetestsystem.pojo.TestQuestions;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.service.UserService;
import com.cxaou.thetestsystem.utils.MD5Util;
import com.cxaou.thetestsystem.utils.TokenUtil;
import com.cxaou.thetestsystem.vo.LogVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@Api(tags = "用户操作接口")
@RequestMapping("/user")
@RestController()
public class UserController {

    @Autowired
    private UserService userService;

    @ApiParam("/hello")
    @GetMapping()
    public R<String> hello() {
        return R.success("成功");
    }

    @PostMapping("/login")
    @ApiParam("登录用的接口")
    public R<User> login(@RequestBody LogVo user) {


        if (user.getType() == null) {
            return R.error("登录方式为空");
        }
        if (!StringUtils.hasText(user.getPassword())) {
            return R.error("密码为空");
        }

        User userOne = userService.login(user);
        if (userOne == null) {
            return R.error("账号不存在");
        }
        String password = MD5Util.getMD5Str(user.getPassword());
        if (!password.equals(userOne.getPassword())) {
            return R.error("账号或密码错误");
        }
        userOne.setPassword("");
        String token = TokenUtil.sign(userOne.getId());
        log.info("token: " + token);
        userOne.setToken(token);
        return R.success(userOne);
    }

    @GetMapping("index")
    public R<String> index(HttpServletRequest request, HttpServletResponse response) {
        return R.error(request.getAttribute("msg").toString());
    }

    @GetMapping("/aa")
    public R<List<TestQuestionsDto>> aa(){

        TestQuestions testQuestions = new TestQuestions();
        testQuestions.setId(1L);
        testQuestions.setExaminationPaperId(1L);
        testQuestions.setTestQuestionsType(0);
        testQuestions.setData("下面哪个是软件代码版本控制软件？");
        testQuestions.setOptions("{'A':'project','B': 'SVN','C' :'notepad+','D':'Xshell'}");
        testQuestions.setScore(10.0);

        Map<String,Object> parse = (Map<String,Object>) JSONObject.parse(testQuestions.getOptions());
        TestQuestionsDto testQuestionsDto = new TestQuestionsDto();
        BeanUtils.copyProperties(testQuestions,testQuestionsDto,"options");
        testQuestionsDto.setOptionsMap(parse);

        List<TestQuestionsDto> list = new ArrayList<>(Arrays.asList(testQuestionsDto,testQuestionsDto,testQuestionsDto));
        return R.success(list);
    }

    @GetMapping("/bb")
    public R<ExaminationPaper> bb(){
        return R.success(new ExaminationPaper());
    }
}
