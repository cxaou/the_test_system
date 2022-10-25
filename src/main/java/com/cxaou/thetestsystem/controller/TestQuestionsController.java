package com.cxaou.thetestsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.dto.TestQuestionsDto;
import com.cxaou.thetestsystem.pojo.ExaminationPaper;
import com.cxaou.thetestsystem.pojo.TestQuestions;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@Api(tags = "试题接口")
@RequestMapping("/testQuestions")
@RestController()
public class TestQuestionsController {

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
