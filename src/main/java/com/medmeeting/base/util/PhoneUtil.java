package com.medmeeting.base.util;

import java.util.regex.Pattern;

/**
 * Created by luosonglin on 26/11/2016.
 */
public class PhoneUtil {
    public static final String REGEX_MOBILE = "^((13[0-9])|(14[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$"; //验证手机号
    public static final String REGEX_PASSWORD = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9]{6,15}"; //验证密码,密码至少8位，包含数字，大写字母及小写字母

    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 校验密码
     * 密码至少8位，包含数字，大写字母及小写字母
     *
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return password.length() >= 8 && Pattern.matches(REGEX_PASSWORD, password);
    }
}
