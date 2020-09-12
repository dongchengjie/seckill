package com.dayup.seckill.mapper;

import com.dayup.seckill.entities.Course;
import com.dayup.seckill.entities.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    @Select("select * from orders where username = #{username} and course_no = #{courseNo}")
    public Order selectCourseByUsernameAndCourseNo(@Param("username") String username, @Param("courseNo") Integer courseNo);
}
