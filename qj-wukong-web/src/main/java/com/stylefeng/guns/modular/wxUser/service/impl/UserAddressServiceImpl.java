package com.stylefeng.guns.modular.wxUser.service.impl;

import com.stylefeng.guns.common.persistence.model.UserAddress;
import com.stylefeng.guns.common.persistence.dao.UserAddressMapper;
import com.stylefeng.guns.modular.wxUser.service.IUserAddressService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户地址 服务实现类
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-09
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements IUserAddressService {
	
}
