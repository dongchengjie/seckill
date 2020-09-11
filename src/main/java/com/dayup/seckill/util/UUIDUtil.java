package com.dayup.seckill.util;

import cn.hutool.core.lang.UUID;

/**
 * Author: 董成杰
 * Date: 2020-09-11 8:34
 * Description:UUID工具类
 */
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
