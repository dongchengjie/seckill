package com.dayup.seckill.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author: 董成杰
 * Date: 2020-09-08 9:56
 * Description:错误响应信息
 */
@Data
@AllArgsConstructor
public class Error {
    private String errCode;
    private String errMsg;
}
