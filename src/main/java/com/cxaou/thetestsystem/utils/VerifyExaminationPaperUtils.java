package com.cxaou.thetestsystem.utils;

import com.cxaou.thetestsystem.dto.TestQuestionsDto;
import com.cxaou.thetestsystem.pojo.ExaminationPaper;
import com.cxaou.thetestsystem.vo.ExaminationPaperVo;

import java.util.List;

public class VerifyExaminationPaperUtils {

    /**
     * 验证 examinationPaperVo 参数是否合法
     *
     * @param examinationPaperVo 要验证的对象
     * @return 合法 ? true:false
     */
    public static boolean verifyExaminationVoPaper(ExaminationPaperVo examinationPaperVo) {
        // 必填参数为空，必填参数没有填证明不合法
        if (isNullCoreExaminationPaperVoParameter(examinationPaperVo)) {
            return false;
        }
        List<TestQuestionsDto> testQuestionsDtoList = examinationPaperVo.getTestQuestionsDtoList();
        return verifyTestQuestionsDtoList(testQuestionsDtoList, examinationPaperVo);
    }

    /**
     * 验证试卷表(ExaminationPaperVo)核心参数是否为null
     *
     * @param examinationPaperVo 要验证的试卷对象
     * @return null ? true:false
     */
    public static boolean isNullCoreExaminationPaperVoParameter(ExaminationPaperVo examinationPaperVo) {
        return examinationPaperVo.getDuration() == null || examinationPaperVo.getIntroduction() == null
                || examinationPaperVo.getTestQuestionsDtoList() == null
                || examinationPaperVo.getTitle() == null || examinationPaperVo.getType() == null;
    }

    /**
     * 验证试题信息是否合法,并设置试卷总分
     *
     * @param testQuestionsDtoList 试题表的列表
     * @param examinationPaperVo   试卷对象
     * @return 合法 ? true:false
     */
    public static boolean verifyTestQuestionsDtoList(List<TestQuestionsDto> testQuestionsDtoList, ExaminationPaperVo examinationPaperVo) {
        Double num = 0.0;
        for (TestQuestionsDto testQuestionsDto : testQuestionsDtoList) {
            // 参数是否为空的校验
            if (isNullCoreTestQuestionsDtoParameter(testQuestionsDto)) {
                return false;
            }
            Double score = testQuestionsDto.getScore();
            num += score;
        }
        examinationPaperVo.setTestScores(num);
        return true;

    }

    /**
     * 验证试题(TestQuestionsDto)的核心参数是否为null
     *
     * @param testQuestionsDto 试题的dto对象
     * @return null ?  true:false
     */
    public static boolean isNullCoreTestQuestionsDtoParameter(TestQuestionsDto testQuestionsDto) {
        if (testQuestionsDto.getTestQuestionsType() == null || testQuestionsDto.getData() == null
                || testQuestionsDto.getAnswer() == null || testQuestionsDto.getScore() == null) {
            return true;
        }
        if (testQuestionsDto.getTestQuestionsType() == 0 || testQuestionsDto.getTestQuestionsType() == 1) {
            if (testQuestionsDto.getOptionsMap() == null) {
                return true;
            }
        }
        if (testQuestionsDto.getTestQuestionsType() == 2) { //主观题
            if (testQuestionsDto.getMaxSimilarity() == null || testQuestionsDto.getMinSimilarity() == null) {
                return true;
            }
            // 验证分数的合法性 , 试卷总分应该等于试题总分的相加 最大值跟最小值的范围在0-100
            return testQuestionsDto.getMinSimilarity() < 0 || testQuestionsDto.getMinSimilarity() > 100
                    || testQuestionsDto.getMaxSimilarity() < 0 || testQuestionsDto.getMaxSimilarity() > 100;
        }
        return false;
    }

    /**
     * 判断examinationPaper 核心参数是否等于null
     *
     * @param examinationPaper 传入要验证的对象
     * @return null ? true : false
     */
    public static boolean isNullCoreExaminationPaper(ExaminationPaper examinationPaper) {
        return examinationPaper.getIntroduction() == null || examinationPaper.getTitle() == null
                || examinationPaper.getDuration() == null || examinationPaper.getType() == null
                || examinationPaper.getId() == null;
    }
}
