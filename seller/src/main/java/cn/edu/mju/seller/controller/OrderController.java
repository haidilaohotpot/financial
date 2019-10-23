package cn.edu.mju.seller.controller;

import cn.edu.mju.seller.entity.Order;
import cn.edu.mju.seller.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/10/23
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

   @Autowired
   private OrderService orderService;

    /**
     * 申购
     * @param order
     * @return
     */
   @PostMapping("/apply")
   public Order apply(@RequestHeader String authId,@RequestHeader String sign,@RequestBody Order order) {

       // TODO: 2019/10/23 解密 校验
       log.debug("申购{}",order);
       order = orderService.apply(order);
       log.debug("结构{}",order);
       return order;

   }




}
