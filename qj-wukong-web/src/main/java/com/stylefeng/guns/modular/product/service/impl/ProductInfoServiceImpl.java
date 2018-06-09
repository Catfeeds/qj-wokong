package com.stylefeng.guns.modular.product.service.impl;

import com.stylefeng.guns.common.persistence.model.ProductInfo;
import com.stylefeng.guns.common.persistence.dao.ProductInfoMapper;
import com.stylefeng.guns.modular.product.service.IProductInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品详情 服务实现类
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-09
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements IProductInfoService {
	
}
