package com.stylefeng.guns.modular.order.service;

import com.stylefeng.guns.common.persistence.model.WbUserOrderDetail;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户订单明细表 服务类
 * </p>
 *
 * @author gaoxuefeng
 * @since 2018-06-06
 */
@Service
public interface IWbUserOrderDetailService extends IService<WbUserOrderDetail> {
	
	/**
	 * @author gaoxuefeng
	 * @return	返回订单列表信息
	 */
	List<Map<String, WbUserOrderDetail>> selectOrderDetailLits();
}
