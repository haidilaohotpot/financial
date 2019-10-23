package cn.edu.mju.api.controller;

import cn.edu.mju.api.client.ProductClient;
import cn.edu.mju.api.dto.PageDTO;
import cn.edu.mju.api.entity.Product;
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
    private ProductClient productClient;

    @GetMapping("/list")
    public PageDTO query(@RequestParam Map<String,Object> params){


        log.debug("params={}",params);
        return productClient.query(params);
    }


    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") String id){

        log.debug("id={}",id);
        return productClient.findOne(id);
    }




}
