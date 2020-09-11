package com.dayup.seckill.service;

import com.dayup.seckill.entities.Order;

/**
 * Author: 董成杰
 * Date: 2020-09-11 9:46
 * Description:订单服务
 */
public interface OrderService {
    public void sendCourseOrderMessage(String username,int courseNo);

    public Integer createCourseOrder(String username,int courseNo);
}
