package com.dayup.seckill.util;

import javax.servlet.http.HttpSession;

/**
 * Author: 董成杰
 * Date: 2020-09-08 10:29
 * Description:
 */
public class VerificationUtil {
    public static final String VERIFICATION = "verification";//验证码在session中的key

    /**
     * 验证码是否正确
     *
     * @param session session
     * @param code    传入的验证码
     * @return 验证码是否正确
     */
    public static boolean isVaild(HttpSession session, String code) {
        if (session != null && code != null) {
            String rightCode = (String) session.getAttribute(VERIFICATION);
            return code.equals(rightCode);
        }
        return false;
    }
}
