package com.stylefeng.guns.modular.wx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stylefeng.guns.modular.wx.model.ReceivingAddress;

/**
 * 收貨地址dao 
 */
public interface ReceivingAddressDao {
	/**
	 * 根据微信id 查询收货地址列表
	 * 
	 * @param wechatId
	 * @return
	 */
	List<ReceivingAddress> getAddressList(String wechatId);

	/**
	 * 添加收货地址
	 * 
	 * @param address
	 * @return
	 */
	int addAddress(@Param("address") ReceivingAddress address);

	/**
	 * 根据id修改收货地址
	 * 
	 * @param address
	 * @return
	 */
	int updateAddressById(@Param("address") ReceivingAddress address);

	/**
	 * 根据微信id修改是否为默认地址
	 * 
	 * @param wechatId
	 * @param isDefault
	 * @return
	 */
	int updateIsDefaultByWechatId(@Param("wechatId") String wechatId, @Param("isDefault") Integer isDefault);

	/**
	 * 根据id查询收货地址
	 * 
	 * @param id
	 * @return
	 */
	ReceivingAddress selectById(int id);
	
	/**
	 * 根据id输出收货地址
	 * @param id
	 * @return
	 */
	int deleteById(int id);
}
