package com.cxaou.thetestsystem.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public class PhoneUtils {

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
}
