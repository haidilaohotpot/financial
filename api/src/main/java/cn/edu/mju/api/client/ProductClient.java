package cn.edu.mju.api.client;

import cn.edu.mju.api.dto.PageDTO;
import cn.edu.mju.api.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 产品的客户端
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/10/13
 */
@Service
@FeignClient("manager")
public interface ProductClient {


    @GetMapping("/manager/product/list")
    PageDTO query(@RequestParam Map<String,Object> params);


    @GetMapping("/manager/product/{id}")
    Product findOne(@PathVariable("id") String id);


}
