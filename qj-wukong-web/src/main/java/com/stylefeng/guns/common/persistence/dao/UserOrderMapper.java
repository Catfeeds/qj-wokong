package com.stylefeng.guns.common.persistence.dao;

import com.stylefeng.guns.common.persistence.model.UserOrder;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 用户订单 Mapper 接口
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-09
 */
public interface UserOrderMapper extends BaseMapper<UserOrder> {
	/**
	 * 根据微信id查询订单
	 * 
	 * @param wechatId
	 * @return
	 */
	List<UserOrder> selectByWechatId(@Param("wechatId")String wechatId,@Param("orderStatus")String orderStatus);
}