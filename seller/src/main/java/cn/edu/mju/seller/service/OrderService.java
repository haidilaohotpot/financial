package cn.edu.mju.seller.service;

import cn.edu.mju.seller.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author <a href="https://github.com/haidilaohotpot">wonder4work</a>
 * @since 1.0.0 2019/10/23
 */
public interface OrderService extends IService<Order> {


    Order apply(Order order);

}
