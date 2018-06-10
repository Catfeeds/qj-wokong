package com.stylefeng.guns.modular.wx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stylefeng.guns.common.persistence.model.UserOrder;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.SuccessTip;
import com.stylefeng.guns.modular.order.service.IUserOrderService;

import springfox.documentation.spring.web.json.Json;

/**
 * 订单管理控制器
 *
 */
@Controller
@RequestMapping("/wx/order")
public class WxOrderController extends BaseController {

	@Autowired
	private IUserOrderService userOrderService;

	/**
	 * 根据用户查询订单
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Object listByWechatId(String wechatId,String orderStatus) {
		List<UserOrder> userOrders = userOrderService.selectByWechatId(wechatId,orderStatus);
		System.out.println(userOrders);
		return new SuccessTip(SUCCESS_CODE, "查询订单成功", userOrders);
	}
}
