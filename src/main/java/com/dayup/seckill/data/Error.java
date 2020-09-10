package com.dayup.seckill.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: 董成杰
 * Date: 2020-09-08 9:56
 * Description:错误响应信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {
    private String code;
    private String message;
}
