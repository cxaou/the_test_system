package com.cxaou.thetestsystem;

import com.alibaba.fastjson.JSONObject;
import com.cxaou.thetestsystem.pojo.TestQuestions;
import com.cxaou.thetestsystem.utils.TokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


@SpringBootTest
class TheTestSystemApplicationTests {

    @Test
    void contextLoads() {
    }

	@Autowired
    private TokenUtil tokenUtil;
    
   @Test
    void testToken(){
        String sign = tokenUtil.sign(10002L);
        System.out.println("sign = " + sign);
        boolean verify = tokenUtil.verify(sign);
        System.out.println("verify = " + verify);
    }

    @Test
    void mapToJson(){
        TestQuestions testQuestions = new TestQuestions();
        testQuestions.setId(1L);
        testQuestions.setExaminationPaperId(1L);
        testQuestions.setTestQuestionsType(0);
        testQuestions.setData("下面哪个是软件代码版本控制软件？");
        testQuestions.setOptions("{'A':'project','B': 'SVN','C' :'notepad+','D':'Xshell'}");
        testQuestions.setScore(10.0);

        Map<String,Object> parse = (Map<String,Object>) JSONObject.parse(testQuestions.getOptions());
        System.out.println("parse = " + parse);
    }
}
