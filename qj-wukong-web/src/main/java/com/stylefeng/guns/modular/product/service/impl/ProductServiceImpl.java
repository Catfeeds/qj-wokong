package com.stylefeng.guns.modular.product.service.impl;

import com.stylefeng.guns.common.persistence.model.Product;
import com.stylefeng.guns.common.persistence.dao.ProductMapper;
import com.stylefeng.guns.modular.product.service.IProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品 服务实现类
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-08
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
	
}
