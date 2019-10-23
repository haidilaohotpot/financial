package cn.edu.mju.seller.service;

import cn.edu.mju.seller.dto.PageDTO;
import cn.edu.mju.seller.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/10/17
 */

@Service
@FeignClient("zuul")
public interface ProductService {


    @GetMapping("/v1/api/product/list")
    PageDTO query(@RequestParam Map<String,Object> params);


    @GetMapping("/v1/api/product/{id}")
    Product findOne(@PathVariable("id") String id);



}
