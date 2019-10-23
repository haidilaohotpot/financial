package cn.edu.mju.seller.service.serviceImpl;

import cn.edu.mju.seller.entity.Order;
import cn.edu.mju.seller.entity.Product;
import cn.edu.mju.seller.mapper.OrderMapper;
import cn.edu.mju.seller.service.OrderService;
import cn.edu.mju.seller.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.UUID;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/10/23
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper,Order> implements OrderService {

    @Autowired
    private ProductService productService;

    @Override
    public Order apply(Order order) {

        //数据校验
        checkOrder(order);

        //完善订单数据
        completeOrder(order);

        this.saveOrUpdate(order);

        return  order;
    }

    //完善订单数据
    private void completeOrder(Order order) {

        order.setOrderId(UUID.randomUUID().toString().replaceAll("-",""));

        // TODO: 2019/10/23
    }

    /**
     * 校验数据
     * @param order
     */
    private void checkOrder(Order order) {

        //必填字段

        Assert.notNull(order.getOuterOrderId(),"需要外部订单编号");

        Assert.notNull(order.getChanId(), "需要渠道编号");

        Assert.notNull(order.getChanUserId(), "需要用户编号");

        Assert.notNull(order.getProductId(), "需要产品id");

        Assert.notNull(order.getAmount(), "需要购买金额");

        Assert.notNull(order.getCreateAt(),"需要购买时间");

        //参评是否存在及金额首付哦符合要求

        Product product = productService.findOne(order.getProductId());

        Assert.notNull(product, "产品不存在");

    }
}
