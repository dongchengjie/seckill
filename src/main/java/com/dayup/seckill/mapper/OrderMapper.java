package com.dayup.seckill.mapper;

import com.dayup.seckill.entities.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Author: 董成杰
 * Date: 2020-09-11 10:47
 * Description:订单dao
 */
@Mapper
@Component
public interface OrderMapper {
    public Integer addOrder(Order order);
}
