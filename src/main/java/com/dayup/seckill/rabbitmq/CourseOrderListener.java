package com.dayup.seckill.rabbitmq;

import com.dayup.seckill.service.OrderService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
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
            Map<String, Object> map = new Gson().fromJson(body, Map.class);
            String username = (String) map.get("username");
            double courseNo = (double) map.get("courseNo");
            Integer index = orderService.createCourseOrder(username, (int)courseNo);
            if (index == 0) {
                throw new Exception("创建订单失败，" + map.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
