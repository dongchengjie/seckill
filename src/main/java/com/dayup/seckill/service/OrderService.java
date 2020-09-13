package com.dayup.seckill.service;

import com.dayup.seckill.entities.Order;

import java.util.List;

/**
 * Author: 董成杰
 * Date: 2020-09-11 9:46
 * Description:订单服务
 */
public interface OrderService {
    public void sendCourseOrderMessage(String username, int courseNo);

    public Integer createCourseOrder(String username, int courseNo);

    public boolean isBought(String username, int courseNo);

    public boolean refreshBoughtCache(String username, int courseNo, boolean isBought);

    public List<Order> getOrderListByUsername(String username);

}
