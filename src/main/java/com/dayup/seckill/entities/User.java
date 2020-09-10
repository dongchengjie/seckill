package com.dayup.seckill.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Author: 许淼
 * Date: 2020-09-07 15:37
 * Description:
 */
@Component
@Data
@NoArgsConstructor
public class User implements Serializable {
    private int id;             //用户id
    private String username;    //用户名
    private String password;    //用户加密后密码

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
