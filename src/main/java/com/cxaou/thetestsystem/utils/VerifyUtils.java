package com.cxaou.thetestsystem.utils;

import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.pojo.User;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public class VerifyUtils {

    /**
     * 校验手机号是否合法
     * @param phone 手机号
     * @return 合法返回true ， 不合法返回false
     */
    public static boolean verifyPhone(String phone){
        if (!StringUtils.hasText(phone)) {
            return false;
        }
        //用户手机号码校验
        if (!Pattern.matches("^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$", phone)) {
            return false;
        }
        return true;
    }



    /**
     * 校验密码
     * @param password 密码
     * @return
     */
    public static boolean verifyPassword(String password){

        if (!StringUtils.hasText(password)) {
            return false;
        }
        if (!Pattern.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$", password)) {
            return false;
        }
        return true;
    }

    public static<T> R<T> verifyPhoneAndCode(String phone, String codeRedis, String code){
        if (!VerifyUtils.verifyPhone(phone)){
            return R.error("手机号不合法");
        }
        if (codeRedis == null){
            return R.error("请先获取验证码");
        }
        if (!codeRedis.equals(code)){
            return R.error("验证码错误");
        }
        return null;
    }
}
