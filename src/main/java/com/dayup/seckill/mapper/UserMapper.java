package com.dayup.seckill.mapper;

import com.dayup.seckill.entities.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Author: 许淼
 * Date: 2020-09-07 15:04
 * Description:
 */
@Mapper
@Component
public interface UserMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert(value = "insert into user values (default,#{username},#{password})")
    Integer addUser(User user);

    @Select("select * from user where username = #{username}")
    User selectUserByUserName(String username);
}
