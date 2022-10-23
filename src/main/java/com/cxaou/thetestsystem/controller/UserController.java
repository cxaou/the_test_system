package com.cxaou.thetestsystem.controller;

import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.pojo.Affiche;
import com.cxaou.thetestsystem.pojo.ExaminationPaper;
import com.cxaou.thetestsystem.pojo.StudentScore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户操作接口")
@RequestMapping("/user")
@RestController()
public class UserController {

    @ApiOperation(value="测试Affiche")
    @GetMapping("/affiche")
    public Affiche afficheTest(@RequestBody Affiche affiche){
        return new Affiche();
    }

    @GetMapping("/examinationPaper")
    public ExaminationPaper examinationPaper(@RequestBody ExaminationPaper examinationPaper){
        return new ExaminationPaper();
    }

    @GetMapping
    public R<StudentScore> studentScore(@RequestBody StudentScore studentScore){
        return R.success(studentScore);
    }
}
