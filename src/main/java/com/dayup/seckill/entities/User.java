package com.dayup.seckill.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Author: 许淼
 * Date: 2020-09-07 15:37
 * Description:
 */
@Component
@Data
public class User {
    private Long id;
    private String username;
    private String password;
}
