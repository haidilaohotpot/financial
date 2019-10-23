package cn.edu.mju.seller.controller;


import cn.edu.mju.seller.dto.PageDTO;
import cn.edu.mju.seller.entity.Product;
import cn.edu.mju.seller.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/10/13
 */
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public PageDTO query(@RequestParam Map<String,Object> params){


        log.debug("params={}",params);
        return productService.query(params);
    }


    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") String id){

        log.debug("id={}",id);
        return productService.findOne(id);
    }




}
