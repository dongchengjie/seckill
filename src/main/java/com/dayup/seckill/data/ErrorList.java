package com.dayup.seckill.data;

/**
 * Author: 董成杰
 * Date: 2020-09-08 10:09
 * Description:定义的错误列表
 */
public class ErrorList {
    public static Error SUCCESS = new Error("200", "成功");
    public static Error FAIL = new Error("500", "失败");
    public static Error VERIFICATION_FAIL = new Error("1001", "生成验证码失败");
    public static Error EXISTED_USERNAME = new Error("2001", "该用户名已被注册");
    public static Error USER_LOGIN_FAIL = new Error("2002", "用户名或密码错误");
}
