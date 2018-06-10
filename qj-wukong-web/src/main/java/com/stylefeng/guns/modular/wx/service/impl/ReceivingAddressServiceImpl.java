package com.stylefeng.guns.modular.wx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stylefeng.guns.modular.wx.dao.ReceivingAddressDao;
import com.stylefeng.guns.modular.wx.model.ReceivingAddress;
import com.stylefeng.guns.modular.wx.service.IReceivingAddressService;

/**
 * 用户收货地址 服务类
 * 
 * @author Administrator
 *
 */
@Service
@Transactional
public class ReceivingAddressServiceImpl implements IReceivingAddressService {
	@Resource
	private ReceivingAddressDao addressDao;

	@Override
	public List<ReceivingAddress> getAddressList(String wechatId) throws Exception {
		// TODO Auto-generated method stub
		return addressDao.getAddressList(wechatId);
	}

	@Override
	public int addAddress(ReceivingAddress address) throws Exception {
		// TODO Auto-generated method stub
		if ("0".equals(address.getIsDefault())) {
			addressDao.updateIsDefaultByWechatId(address.getWechatId(), 1);
		}
		return addressDao.addAddress(address);
	}

	@Override
	public ReceivingAddress selectById(int id) {
		return addressDao.selectById(id);
	}

	@Override
	public int updateAddressById(ReceivingAddress address) throws Exception {
		if ("0".equals(address.getIsDefault())) {
			addressDao.updateIsDefaultByWechatId(address.getWechatId(), 1);
		}
		return addressDao.updateAddressById(address);
	}

	@Override
	public int deleteById(int id) {
		return addressDao.deleteById(id);
	}

}
