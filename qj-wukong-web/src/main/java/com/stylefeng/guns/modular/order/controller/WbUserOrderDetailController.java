package com.stylefeng.guns.modular.order.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.common.persistence.model.WbUserOrderDetail;
import com.stylefeng.guns.modular.order.service.IWbUserOrderDetailService;

/**
 * 订单管理控制器
 *
 * @author fengshuonan
 * @Date 2018-06-06 20:59:28
 */
@Controller
@RequestMapping("/wbUserOrderDetail")
public class WbUserOrderDetailController extends BaseController {

    private String PREFIX = "/order/wbUserOrderDetail/";

    @Autowired
    private IWbUserOrderDetailService wbUserOrderDetailService;

    /**
     * 跳转到订单管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "wbUserOrderDetail.html";
    }

    /**
     * 跳转到添加订单管理
     */
    @RequestMapping("/wbUserOrderDetail_add")
    public String wbUserOrderDetailAdd() {
        return PREFIX + "wbUserOrderDetail_add.html";
    }

    /**
     * 跳转到修改订单管理
     */
    @RequestMapping("/wbUserOrderDetail_update/{wbUserOrderDetailId}")
    public String wbUserOrderDetailUpdate(@PathVariable Integer wbUserOrderDetailId, Model model) {
        WbUserOrderDetail wbUserOrderDetail = wbUserOrderDetailService.selectById(wbUserOrderDetailId);
        model.addAttribute("item",wbUserOrderDetail);
        LogObjectHolder.me().set(wbUserOrderDetail);
        return PREFIX + "wbUserOrderDetail_edit.html";
    }

    /**
     * 获取订单管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    	List<Map<String, WbUserOrderDetail>>  list = wbUserOrderDetailService.selectOrderDetailLits();
    	System.err.println(list);
        return list;
    }

    /**
     * 新增订单管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(WbUserOrderDetail wbUserOrderDetail) {
        wbUserOrderDetailService.insert(wbUserOrderDetail);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除订单管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer wbUserOrderDetailId) {
        wbUserOrderDetailService.deleteById(wbUserOrderDetailId);
        return SUCCESS_TIP;
    }

    /**
     * 修改订单管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(WbUserOrderDetail wbUserOrderDetail) {
        wbUserOrderDetailService.updateById(wbUserOrderDetail);
        return super.SUCCESS_TIP;
    }

    /**
     * 订单管理详情
     */
    @RequestMapping(value = "/detail/{wbUserOrderDetailId}")
    @ResponseBody
    public Object detail(@PathVariable("wbUserOrderDetailId") Integer wbUserOrderDetailId) {
        return wbUserOrderDetailService.selectById(wbUserOrderDetailId);
    }
}
