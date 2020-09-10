package com.dayup.seckill.util;

import cn.hutool.crypto.SecureUtil;

/**
 * Author: 董成杰
 * Date: 2020-09-10 14:35
 * Description:安全工具类
 */
public class SecurityUtil {
    private static final String SALT = "seckill";

    public static String md5(String s) {
        return s == null || s.length() == 0 ? "" : SecureUtil.md5(s + SALT);
    }
}
