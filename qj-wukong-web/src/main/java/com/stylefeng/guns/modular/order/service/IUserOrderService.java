package com.stylefeng.guns.modular.order.service;

import com.stylefeng.guns.common.persistence.model.UserOrder;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户订单 服务类
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-09
 */
public interface IUserOrderService extends IService<UserOrder> {
	/**
	 * 根据微信id查询订单
	 * 
	 * @param wechatId
	 * @return
	 */
	List<UserOrder> selectByWechatId(String wechatId,String orderStatus);
}
