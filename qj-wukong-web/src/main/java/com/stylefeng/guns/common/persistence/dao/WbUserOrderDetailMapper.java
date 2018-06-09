package com.stylefeng.guns.common.persistence.dao;

import com.stylefeng.guns.common.persistence.model.WbUserOrderDetail;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 用户订单明细表 Mapper 接口
 * </p>
 *
 * @author gaoxuefeng
 * @since 2018-06-06
 */
public interface WbUserOrderDetailMapper extends BaseMapper<WbUserOrderDetail> {

	/**
	 * @author gaoxuefeng
	 * @return	返回订单列表信息
	 */
	List<Map<String, WbUserOrderDetail>> selectOrderDetailLits();

}