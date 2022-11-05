package com.cxaou.thetestsystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxaou.thetestsystem.dto.ScoreDto;
import com.cxaou.thetestsystem.pojo.StudentScore;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface StudentScoreService extends IService<StudentScore> {


    /**
     *  查询分数的分页对象
     * @param page page对象
     * @param userId 用户id
     * @return
     */
    Page<ScoreDto> getScoreDto(Page<StudentScore> page,Long userId);


    Page<ScoreDto> getStudentScore(Page<StudentScore> page,Long userId);
}
