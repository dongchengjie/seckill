package com.dayup.seckill.data;

/**
 * Author: 董成杰
 * Date: 2020-09-08 10:09
 * Description:定义的错误列表
 */
public class ErrorList {
    public static Error SUCCESS = new Error("200", "成功");
    public static Error FAIL = new Error("500", "失败");
    //系统错误码
    public static Error VERIFICATION_FAIL = new Error("1001", "生成验证码失败");
    public static Error FREQUENT_REQUEST = new Error("1002", "您的请求过于频繁，请稍后再试");
    //身份/用户错误码
    public static Error EXISTED_USERNAME = new Error("2001", "该用户名已被注册");
    public static Error USER_LOGIN_FAIL = new Error("2002", "用户名或密码错误");
    public static Error USER_REGISTER_SUCCESS = new Error("2003", "注册成功");
    public static Error IDENTIFICATION_OUT_OF_DATE = new Error("2004", "身份信息过期，请重新登录");
    //数据错误码
    public static Error RECEIVED_PARAM_ERROR = new Error("3001", "参数传递错误");
    public static Error SECKILL_LINE_UP = new Error("3002", "订单生成中，请稍后");
    public static Error SECKILL_NO_QUOTE = new Error("3003", "非常抱歉，该课程名额已满");
    public static Error SECKILL_BOUGHT = new Error("3004", "您已购买过该课程，请不要重复购买");
    public static Error SECKILL_PATH_ERROR = new Error("3005", "您的请求地址不正确");
    public static Error UNKOWN_COURSE = new Error("3006", "对不起，该课程编号不存在");
}
