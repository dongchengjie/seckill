package com.dayup.seckill.data;

import lombok.Data;

/**
 * Author: 董成杰
 * Date: 2020-09-10 15:22
 * Description:
 */
@Data
public abstract class IResult {
    String code = "0";
    String message = "";

    public void setErrorInfo(Error error) {
        if (error == null) return;
        setCode(error.getCode());
        setMessage(error.getMessage());
    }
}
