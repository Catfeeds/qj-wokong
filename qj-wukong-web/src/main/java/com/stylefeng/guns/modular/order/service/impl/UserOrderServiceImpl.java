package com.stylefeng.guns.modular.order.service.impl;

import com.stylefeng.guns.common.persistence.model.UserOrder;
import com.stylefeng.guns.common.persistence.dao.UserOrderMapper;
import com.stylefeng.guns.modular.order.service.IUserOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户订单 服务实现类
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-09
 */
@Service
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements IUserOrderService {
	@Autowired
	UserOrderMapper userOrderMapper;

	@Override
	public List<UserOrder> selectByWechatId(String wechatId,String orderStatus) {
		return userOrderMapper.selectByWechatId(wechatId,orderStatus);
	}

}
