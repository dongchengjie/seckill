package com.dayup.seckill.entities;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Author: 董成杰
 * Date: 2020-09-11 10:40
 * Description:订单信息
 */
@Data
public class Order implements Serializable {
    private int orderId;                //订单号
    private int courseNo;               //课程号
    private String username;            //用户名
    private String courseName;          //课程名称
    private BigDecimal coursePrice;     //课程价格
    private String payment;             //支付方式
    private int payStatus;              //支付状态
    private Date payDate;               //支付时间
    private Date createDate;            //订单创建时间
    private String coursePic;           //课程图片url
}
