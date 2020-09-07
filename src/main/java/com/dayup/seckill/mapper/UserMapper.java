package com.dayup.seckill.mapper;

import com.dayup.seckill.entities.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author: 许淼
 * Date: 2020-09-07 15:04
 * Description:
 */
@Mapper
public interface UserMapper {
    void addUser(User user);
}
