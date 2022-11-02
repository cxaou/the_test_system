package com.cxaou.thetestsystem.controller;

import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.pojo.UserExaminationPaper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user_examinationPaper")
@Api(tags = "用户的考试")
public class UserExaminationPaperController {

    // TODO 查询用户要参加考试的试卷
    @GetMapping
    @ApiOperation("查看我的考试")
    public List<R<UserExaminationPaper>> getUserExaminationPaper(){

        return null;
    }

    @PostMapping
    @ApiOperation(value = "添加考试",tags = "只有管理员跟教师有操作该权限的资格")
    public R<String> addUserExaminationPaper(){
        return R.success("添加成功");
    }


}
