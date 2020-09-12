package com.dayup.seckill.service;

import com.dayup.seckill.data.ResponseResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: 董成杰
 * Date: 2020-09-12 12:48
 * Description:秒杀服务
 */
public interface SeckillService {
    ResponseResult seckill(String username, Integer courseNo, HttpServletRequest request);
}
