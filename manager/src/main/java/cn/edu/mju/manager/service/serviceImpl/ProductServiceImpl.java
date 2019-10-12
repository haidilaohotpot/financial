package cn.edu.mju.manager.service.serviceImpl;

import cn.edu.mju.dto.PageDTO;
import cn.edu.mju.entity.Product;
import cn.edu.mju.enums.ProductStatusEnum;
import cn.edu.mju.manager.enums.ErrorEnum;
import cn.edu.mju.manager.mapper.ProductMapper;
import cn.edu.mju.manager.service.ProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/10/8
 */
@Service
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {


    @Override
    public Product add(Product product) {

        //数据校验
        checkProduct(product);

        //设置默认值
        setDefault(product);

        //储存
        this.save(product);

        log.debug("创建产品，结果:{}",product);

        return product;
    }


    /**
     *
     * 分页查询
     * @param idList
     * @param minRewardRate
     * @param maxRewardRate
     * @param statusList
     * @param pageDTO
     * @return
     */
    @Override
    public PageDTO query(List<String> idList, BigDecimal minRewardRate, BigDecimal maxRewardRate, List<String> statusList, PageDTO pageDTO) {


        QueryWrapper<Product> wrapper = buildWrapper(idList,minRewardRate,maxRewardRate,statusList);

        IPage<Product> page  = buildPage(pageDTO);

        page = this.page(page, wrapper);

        pageDTO = build(page);

        return pageDTO;
    }

    /**
     * 构建分页数据
     * @param page
     * @return
     */
    private PageDTO build(IPage<Product> page) {

        Integer pages = Math.toIntExact(page.getPages());

        List<Product> data = page.getRecords();

        Integer current = Math.toIntExact(page.getCurrent());

        Integer size = Math.toIntExact(page.getSize());

        Integer total = Math.toIntExact(page.getTotal());

        return new PageDTO(pages, size, current, total, data);

    }

    /**
     * 构建分页对象
     * @param pageDTO
     * @return
     */
    private IPage<Product> buildPage(PageDTO pageDTO) {

        IPage<Product> page = new Page<>();

        page.setSize(pageDTO.getPageSize());

        page.setCurrent(pageDTO.getCurrent());

        return page;
    }

    /**
     * 封装mybatis分页查询所需的对象
     * @param idList
     * @param minRewardRate
     * @param maxRewardRate
     * @param statusList
     * @return
     */
    private QueryWrapper<Product> buildWrapper(List<String> idList, BigDecimal minRewardRate, BigDecimal maxRewardRate, List<String> statusList) {

        QueryWrapper<Product> wrapper = new QueryWrapper<>();

        if (idList != null) {

            wrapper.in("id", idList);
        }


        if (minRewardRate != null  && maxRewardRate != null) {
            wrapper.between("reward_rate", minRewardRate, maxRewardRate);
//            wrapper.or().between("reward_rate", minRewardRate, maxRewardRate);

        }

        if (statusList != null) {

            wrapper.in("status",statusList);
//            wrapper.or().in("status",statusList);
        }


        return wrapper;
    }

    /**
     * 设置默认值
     *
     * 创建时间、更新时间
     * 投资步长、锁定期
     *
     * @param product
     */
    private void setDefault(Product product) {
        if (product.getCreateAt() == null) {
            product.setCreateAt(new Date());
        }
        if (product.getUpdateAt() == null) {
            product.setUpdateAt(new Date());
        }
        if (product.getStepAmount() == null) {
            product.setStepAmount(BigDecimal.ZERO);
        }
        if (product.getLockTerm() == null) {
            product.setLockTerm(0);
        }
        if (product.getStatus() == null) {
            product.setStatus(ProductStatusEnum.AUDITING.name());
        }
    }

    /**
     * 产品数据校验
     * 1.非空数据
     * 2.收益率0-30以内
     * 3.投资步长需为整数
     * @param product
     */
    private void checkProduct(Product product) {

        Assert.notNull(product.getId(),ErrorEnum.ID_NOT_NULL.getCode());

        //其他非空校验

        Assert.isTrue(BigDecimal.ZERO.compareTo(product.getRewardRate()) < 0 && BigDecimal.valueOf(30).compareTo(product.getRewardRate()) >= 0,"收益率错误");

        Assert.isTrue(BigDecimal.valueOf(product.getStepAmount().longValue()).compareTo(product.getStepAmount()) == 0, "投资步长要为整数");


    }
}
