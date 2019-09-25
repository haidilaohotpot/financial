package cn.edu.mju.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/9/25
 */
@Data
@TableName(value = "order_t")
public class Order {

    @TableId
    private String orderId;

    //渠道id
    private String chanId;

    private String chanUserId;

    /**
     * @see cn.edu.mju.enums.OrderTypeEnum
     */
    private String orderType;

    private String productId;

    private BigDecimal amount;

    private String outerOrderId;

    /**
     * @see cn.edu.mju.enums.OrderStatusEnum
     */
    private String orderStatus;

    private String memo;

    private Date createAt;

    private Date updateAt;


}
