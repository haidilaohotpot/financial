package cn.edu.mju.manager.service;

import cn.edu.mju.dto.PageDTO;
import cn.edu.mju.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author <a href="https://github.com/haidilaohotpot">wonder4work</a>
 * @since 1.0.0 2019/10/8
 */
public interface ProductService extends IService<Product> {


    /**
     * 添加一个商品
     * @param product
     */
    Product add(Product product);


    PageDTO query(List<String> idList,
                  BigDecimal minRewardRate, BigDecimal maxRewardRate,
                  List<String> statusList,
                  PageDTO pageDTO);

}
