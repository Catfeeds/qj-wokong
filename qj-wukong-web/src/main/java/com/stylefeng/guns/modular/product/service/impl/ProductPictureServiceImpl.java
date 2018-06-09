package com.stylefeng.guns.modular.product.service.impl;

import com.stylefeng.guns.common.persistence.model.ProductPicture;
import com.stylefeng.guns.common.persistence.dao.ProductPictureMapper;
import com.stylefeng.guns.modular.product.service.IProductPictureService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品图片关联信息表 服务实现类
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-08
 */
@Service
public class ProductPictureServiceImpl extends ServiceImpl<ProductPictureMapper, ProductPicture> implements IProductPictureService {
	
}
