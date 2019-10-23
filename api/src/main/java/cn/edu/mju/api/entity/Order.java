package cn.edu.mju.api.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/9/25
 */
@Data
public class Order {

    private String orderId;

    //渠道id
    private String chanId;

    private String chanUserId;

    private String orderType;

    private String productId;

    private BigDecimal amount;

    private String outerOrderId;

    private String orderStatus;

    private String memo;

    private Date createAt;

    private Date updateAt;


}
