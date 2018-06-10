package com.stylefeng.guns.modular.wx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stylefeng.guns.modular.wx.model.ReceivingAddress;

/**
 * 用户收货地址 服务接口
 * 
 * @author Administrator
 *
 */
public interface IReceivingAddressService {
	/**
	 * 获取用户收货地址列表
	 * 
	 * @param wechatId
	 * @return
	 */
	List<ReceivingAddress> getAddressList(String wechatId) throws Exception;

	/**
	 * 添加收货地址
	 * 
	 * @param address
	 * @return
	 * @throws Exception
	 */
	int addAddress(ReceivingAddress address) throws Exception;

	/**
	 * 根据id查询收货地址
	 * 
	 * @param id
	 * @return
	 */
	ReceivingAddress selectById(int id) throws Exception;

	/**
	 * 根据id修改收货地址
	 * 
	 * @param address
	 * @return
	 */
	int updateAddressById(ReceivingAddress address) throws Exception;

	/**
	 * 根据id输出收货地址
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(int id);
}
