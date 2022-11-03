package com.cxaou.thetestsystem.utils;

import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.vo.UserExaminationPaperVo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VerifyUserExaminationPaperVoUtils {

    /**
     * 判断核心参数是否为null
     *
     * @param userExaminationPaperVo 要判断的对象
     * @return null ? true:false
     */
    public static boolean isNullCoreParameter(UserExaminationPaperVo userExaminationPaperVo) {
        return userExaminationPaperVo.getAcceptStartTime() == null
                || userExaminationPaperVo.getExaminationPaperId() == null;

    }

    /**
     * 验证时间参数是否合法
     *
     * @param startTime 要验证的时间参数
     * @return 合法 ? true:false
     */
    public static boolean verifyDateParameter(LocalDateTime startTime) {
        Duration duration = Duration.between(LocalDateTime.now(), startTime);
        return duration.toMinutes() >= 15;
        // 提交的时间必须大于 当前时间
    }

    /**
     * 检验参数，并进行时间转换
     * @param userExaminationPaperVo 要检验的对象
     * @return  结果集，等于null 每异常，不等于null，就是不合法
     */
    public static R<String> verifyCoreAndShift(UserExaminationPaperVo userExaminationPaperVo){
        if (VerifyUserExaminationPaperVoUtils.isNullCoreParameter(userExaminationPaperVo)){
            return R.error("参数不合法");
        }
        // 进行时间转换
        LocalDateTime localDateTime = DateUtils.dateToLocalDateTime(userExaminationPaperVo.getAcceptStartTime());
        userExaminationPaperVo.setStartTime(localDateTime);
        if (!VerifyUserExaminationPaperVoUtils.verifyDateParameter(userExaminationPaperVo.getStartTime())){
            return R.error("试卷应该提前15分钟发布");
        }
        return null;
    }


}
