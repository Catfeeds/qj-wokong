package com.stylefeng.guns.modular.order.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.common.persistence.model.UserOrder;
import com.stylefeng.guns.modular.order.service.IUserOrderService;

/**
 * 订单管理控制器
 *
 * @author fengshuonan
 * @Date 2018-06-09 17:57:50
 */
@Controller
@RequestMapping("/userOrder")
public class UserOrderController extends BaseController {

    private String PREFIX = "/order/userOrder/";

    @Autowired
    private IUserOrderService userOrderService;

    /**
     * 跳转到订单管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "userOrder.html";
    }

    /**
     * 跳转到添加订单管理
     */
    @RequestMapping("/userOrder_add")
    public String userOrderAdd() {
        return PREFIX + "userOrder_add.html";
    }

    /**
     * 跳转到修改订单管理
     */
    @RequestMapping("/userOrder_update/{userOrderId}")
    public String userOrderUpdate(@PathVariable Integer userOrderId, Model model) {
        UserOrder userOrder = userOrderService.selectById(userOrderId);
        model.addAttribute("item",userOrder);
        LogObjectHolder.me().set(userOrder);
        return PREFIX + "userOrder_edit.html";
    }

    /**
     * 获取订单管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return userOrderService.selectList(null);
    }

    /**
     * 新增订单管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(UserOrder userOrder) {
        userOrderService.insert(userOrder);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除订单管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer userOrderId) {
        userOrderService.deleteById(userOrderId);
        return SUCCESS_TIP;
    }

    /**
     * 修改订单管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(UserOrder userOrder) {
        userOrderService.updateById(userOrder);
        return super.SUCCESS_TIP;
    }

    /**
     * 订单管理详情
     */
    @RequestMapping(value = "/detail/{userOrderId}")
    @ResponseBody
    public Object detail(@PathVariable("userOrderId") Integer userOrderId) {
        return userOrderService.selectById(userOrderId);
    }
}
