package com.cxaou.thetestsystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cxaou.thetestsystem.dto.TestQuestionsDto;
import com.cxaou.thetestsystem.pojo.ExaminationPaper;

import java.util.List;

/**
 *
 */
public interface ExaminationPaperService extends IService<ExaminationPaper> {

    /**
     *  添加一套试题
     * @param currentUserId 当前用户的id
     * @param examinationPaper 试卷对象
     * @param testQuestionsDtoList 试题对象
     * @return 是否添加成功
     */
    boolean addExaminationPaper(Long currentUserId, ExaminationPaper examinationPaper, List<TestQuestionsDto> testQuestionsDtoList);

    /**
     *  修改试卷
     * @param currentUserId 当前用户的id
     * @param examinationPaper 试卷对象
     * @return 是否修改成功
     */
    boolean updateExaminationPaper(Long currentUserId, ExaminationPaper examinationPaper);

    /**
     *  删除试卷
     * @param currentUserId 当前用户的id
     * @param examinationPaper 试卷对象
     * @return 是否删除成功
     */
    boolean deleteExaminationPaper(Long currentUserId,ExaminationPaper examinationPaper);

    /**
     *  查询自己发布的所有试卷
     * @param pageInfo 分页对象
     * @param title 标题
     * @param currentUserId 当前用户的id
     * @return 权限够 ? true:false
     */
    boolean getOwnAllExaminationPaper(Page<ExaminationPaper> pageInfo, String title,Long currentUserId);

}