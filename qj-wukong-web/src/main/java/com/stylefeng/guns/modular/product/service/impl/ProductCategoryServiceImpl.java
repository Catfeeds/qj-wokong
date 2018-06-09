package com.stylefeng.guns.modular.product.service.impl;

import com.stylefeng.guns.common.persistence.model.ProductCategory;
import com.stylefeng.guns.common.persistence.dao.ProductCategoryMapper;
import com.stylefeng.guns.modular.product.service.IProductCategoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品类别表 服务实现类
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-08
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements IProductCategoryService {
	
}
