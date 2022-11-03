package com.cxaou.thetestsystem.service;

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
}
