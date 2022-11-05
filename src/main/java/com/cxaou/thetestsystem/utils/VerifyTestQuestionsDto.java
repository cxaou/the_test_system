package com.cxaou.thetestsystem.utils;

import com.cxaou.thetestsystem.dto.TestQuestionsDto;

import java.util.List;

public class VerifyTestQuestionsDto {


    public static boolean verifyTestQuestions(List<TestQuestionsDto> testQuestionsDtoList){
        if (testQuestionsDtoList == null){
            return false;
        }
        for (TestQuestionsDto testQuestionsDto : testQuestionsDtoList) {
            if (testQuestionsDto.getId() == null || testQuestionsDto.getTestQuestionsType() == null){
                return false;
            }
        }
        return true;
    }


}
