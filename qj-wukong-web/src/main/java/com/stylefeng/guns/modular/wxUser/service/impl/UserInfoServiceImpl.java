package com.stylefeng.guns.modular.wxUser.service.impl;

import com.stylefeng.guns.common.persistence.model.UserInfo;
import com.stylefeng.guns.common.persistence.dao.UserInfoMapper;
import com.stylefeng.guns.modular.wxUser.service.IUserInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-09
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
	
}
