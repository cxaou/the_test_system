package com.cxaou.thetestsystem.utils;

import com.cxaou.thetestsystem.common.R;
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
     * 校验密码 6-16 位数 并且是数字跟字母的组合
     * @param password 密码
     * @return 符合要求返回true
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

    /**
     * 验证邮箱是否和法
     * @param email 邮箱
     * @return 合法返回false
     */
    public static boolean isEmail(String email) {
        if (email == null || email.length() < 1 || email.length() > 256) {
            return false;
        }
        Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        return pattern.matcher(email).matches();
    }

    /**
     * 校验用户名的合法性 6,20 位 由数字或者字母或者下划线组成
     * @param username 用户名
     * @return 是否合法
     */
    public static boolean isUsername(String username){
        if (!StringUtils.hasText(username)){
            return false;
        }
        Pattern pattern =  Pattern.compile("^\\w{5,20}$");
        return pattern.matcher(username).matches();

    }

}
