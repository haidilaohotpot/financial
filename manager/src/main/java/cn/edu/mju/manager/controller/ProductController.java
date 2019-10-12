package cn.edu.mju.manager.controller;

import cn.edu.mju.dto.PageDTO;
import cn.edu.mju.entity.Product;
import cn.edu.mju.manager.service.ProductService;
import cn.edu.mju.util.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/10/8
 */
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    /**
     * 分页查询商品
     * @param params
     * @return
     */
    @GetMapping("/list")
    public PageDTO query(@RequestParam Map<String,Object> params) {

        log.debug("查询参数,{}",params);


        String[] statusList = RequestUtils.getStringList(params,"statusList");

        BigDecimal minRewardRate = RequestUtils.getBigDecimal(params,"minRewardRate");

        BigDecimal maxRewardRate =RequestUtils.getBigDecimal(params,"maxRewardRate");

        String[] idList = RequestUtils.getStringList(params,"idList");

        Integer pageSize = RequestUtils.getInt(params, "pageSize");

        Integer pageNo = RequestUtils.getInt(params, "pageNo");

        PageDTO pageDTO = new PageDTO();

        pageDTO.setCurrent(pageNo);

        pageDTO.setPageSize(pageSize);


        List<String> ids = null;
        List<String> status = null;

        if (idList != null) {
            ids = Arrays.asList(idList);
        }

        if (statusList != null) {
            status = Arrays.asList(statusList);
        }

        pageDTO = productService.query(ids, minRewardRate, maxRewardRate, status, pageDTO);

        return pageDTO;
    }



    /**
     * 添加一个产品
     * @param product
     * @return
     */
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {

        log.info("创建产品，参数：{}", product);

        Product result = productService.add(product);

        log.info("创建结果为，{}", result);

        return result;
    }


    /**
     * 根据id查询单个产品
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") String id) {

        Assert.notNull(id, "产品id不能为空");

        log.debug("查询单个产品,id={}", id);

        Product product = productService.getById(id);

        log.debug("查询单个产品的结果为：{}", product);

        return product;
    }

}
