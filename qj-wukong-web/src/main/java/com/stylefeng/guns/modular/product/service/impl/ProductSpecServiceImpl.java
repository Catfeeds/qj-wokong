package com.stylefeng.guns.modular.product.service.impl;

import com.stylefeng.guns.common.persistence.model.ProductSpec;
import com.stylefeng.guns.common.persistence.dao.ProductSpecMapper;
import com.stylefeng.guns.modular.product.service.IProductSpecService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品规格 服务实现类
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-08
 */
@Service
public class ProductSpecServiceImpl extends ServiceImpl<ProductSpecMapper, ProductSpec> implements IProductSpecService {
	
}
