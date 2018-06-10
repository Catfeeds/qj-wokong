package com.stylefeng.guns.common.persistence.dao;

import com.stylefeng.guns.common.persistence.model.WbUserOrderDetail;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	List<WbUserOrderDetail> selectOrderDetailLits();

	/**
	 * @author gaoxuefeng
	 * 根具订单ID获取即将修改的订单信息
	 * @param wbUserOrderDetailId 订单ID
	 * @return 即将修改的订单信息
	 */
	WbUserOrderDetail selectUpdateOrderInfo(@Param("id")Integer wbUserOrderDetailId);

	/**
	 * @author gaoxuefeng
	 * 根具订单ID修改订单信息
	 * @param wbUserOrderDetail 订单信息
	 * @return 受影响的条数
	 */
	Integer updateOrderById(WbUserOrderDetail wbUserOrderDetail);
}