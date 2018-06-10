package com.stylefeng.guns.modular.order.service.impl;

import com.stylefeng.guns.common.persistence.model.WbUserOrderDetail;
import com.stylefeng.guns.common.persistence.dao.WbUserOrderDetailMapper;
import com.stylefeng.guns.modular.order.service.IWbUserOrderDetailService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户订单明细表 服务实现类
 * </p>
 *
 * @author gaoxuefeng
 * @since 2018-06-06
 */
@Service
public class WbUserOrderDetailServiceImpl extends ServiceImpl<WbUserOrderDetailMapper, WbUserOrderDetail> implements IWbUserOrderDetailService {

	@Autowired
	private WbUserOrderDetailMapper wbUserOrderDetailMapper;
	
	@Override
	public List<WbUserOrderDetail> selectOrderDetailLits() {
		return wbUserOrderDetailMapper.selectOrderDetailLits();
	}

	@Override
	public WbUserOrderDetail selectUpdateOrderInfo(Integer wbUserOrderDetailId) {
		return wbUserOrderDetailMapper.selectUpdateOrderInfo(wbUserOrderDetailId);
	}

	@Override
	public boolean updateOrderById(WbUserOrderDetail wbUserOrderDetail) {
		Integer result = wbUserOrderDetailMapper.updateOrderById(wbUserOrderDetail);
		return null != result && result >= 1;
	}
}
