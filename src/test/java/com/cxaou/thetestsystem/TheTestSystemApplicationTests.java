package com.cxaou.thetestsystem;

import com.alibaba.fastjson.JSONObject;
import com.cxaou.thetestsystem.pojo.TestQuestions;
import com.cxaou.thetestsystem.utils.TokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@SpringBootTest
class TheTestSystemApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private TokenUtil tokenUtil;

    @Test
    void testToken() {
        String sign = tokenUtil.sign(10002L);
        System.out.println("sign = " + sign);
        boolean verify = tokenUtil.verify(sign);
        System.out.println("verify = " + verify);
    }

    @Test
    void mapToJson() {
        TestQuestions testQuestions = new TestQuestions();
        testQuestions.setId(1L);
        testQuestions.setExaminationPaperId(1L);
        testQuestions.setTestQuestionsType(0);
        testQuestions.setData("下面哪个是软件代码版本控制软件？");
        testQuestions.setOptions("{'A':'project','B': 'SVN','C' :'notepad+','D':'Xshell'}");
        testQuestions.setScore(10.0);

        Map<String, Object> parse = (Map<String, Object>) JSONObject.parse(testQuestions.getOptions());
        System.out.println("parse = " + parse);
    }


    @Test
    void ListTest(){
        List<Long> students = new ArrayList<>(Arrays.asList(6L,7L,8L,1L,2L,3L));
        List<Long> b = new ArrayList<>(Arrays.asList(1L,2L,3L,4L));
        students.retainAll(b);
        System.out.println("a.size() = " + students.size());
        System.out.println("b = " + b.size());
    }


}
