package com.ecloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_order")
public class OrderMaster implements Serializable {

    @TableId(type = IdType.ASSIGN_UUID)
    private String orderId;

    private Date createTime;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String orderAmount;

    private int orderStatus;

    private int payStatus;

}
