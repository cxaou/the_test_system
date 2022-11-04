package com.cxaou.thetestsystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxaou.thetestsystem.dto.ExaminationInfoDto;
import com.cxaou.thetestsystem.pojo.UserExaminationPaper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cxaou.thetestsystem.vo.UserExaminationPaperVo;

import java.util.List;

/**
 *
 */
public interface UserExaminationPaperService extends IService<UserExaminationPaper> {

    /**
     * 添加考试
     * @param userExaminationPaperVo 要操作的考试vo对象
     * @param userIds 当前登录用户的id
     * @return 成功 ? true:false
     */
    boolean addUserExaminationPaper(UserExaminationPaperVo userExaminationPaperVo, List<Long> userIds);

    /**
     *
     * @param pageInfo 分页对象
     * @param userId 用户id
     * @param examinationStart 状态
     * @return dto 的分页对象
     */
    Page<ExaminationInfoDto> getUserExaminationPaper(Page<UserExaminationPaper> pageInfo, Long userId,Integer examinationStart);
}
