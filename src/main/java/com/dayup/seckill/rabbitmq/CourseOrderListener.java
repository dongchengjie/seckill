package com.dayup.seckill.rabbitmq;

import com.dayup.seckill.service.OrderService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Map;

/**
 * Author: 董成杰
 * Date: 2020-09-11 10:36
 * Description:订单消息监听器
 */
@Component
public class CourseOrderListener {
    @Autowired
    OrderService orderService;

    /**
     * 监听消息队列中的订单消息
     *
     * @param message 收到的消息
     */
    @RabbitListener(queues = "course_order")
    private void handleCourseOrder(Message message) {
        try {
            String body = new String(message.getBody(), StandardCharsets.UTF_8);
            Map<String, String> map = new Gson().fromJson(body, Map.class);
            String username = map.get("username");
            String courseNo = map.get("courseNo");
            Integer index = orderService.createCourseOrder(username, Integer.parseInt(courseNo));
            if (index == 0) {
                throw new SQLIntegrityConstraintViolationException("创建订单失败，该用户已购买该课程" + map.toString());
            }
            //刷新缓存中的购买状态
            orderService.refreshBoughtCache(username, Integer.parseInt(courseNo),true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
