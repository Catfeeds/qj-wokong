package com.stylefeng.guns.modular.gaoxuefeng.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.common.persistence.model.WbUserAddressDetail;
import com.stylefeng.guns.modular.gaoxuefeng.service.IWbUserAddressDetailService;

/**
 * 用户控制器
 *
 * @author fengshuonan
 * @Date 2018-06-08 22:17:08
 */
@Controller
@RequestMapping("/wbUserAddressDetail")
public class WbUserAddressDetailController extends BaseController {

    private String PREFIX = "/gaoxuefeng/wbUserAddressDetail/";

    @Autowired
    private IWbUserAddressDetailService wbUserAddressDetailService;

    /**
     * 跳转到用户首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "wbUserAddressDetail.html";
    }

    /**
     * 跳转到添加用户
     */
    @RequestMapping("/wbUserAddressDetail_add")
    public String wbUserAddressDetailAdd() {
        return PREFIX + "wbUserAddressDetail_add.html";
    }

    /**
     * 跳转到修改用户
     */
    @RequestMapping("/wbUserAddressDetail_update/{wbUserAddressDetailId}")
    public String wbUserAddressDetailUpdate(@PathVariable Integer wbUserAddressDetailId, Model model) {
        WbUserAddressDetail wbUserAddressDetail = wbUserAddressDetailService.selectById(wbUserAddressDetailId);
        model.addAttribute("item",wbUserAddressDetail);
        LogObjectHolder.me().set(wbUserAddressDetail);
        return PREFIX + "wbUserAddressDetail_edit.html";
    }

    /**
     * 获取用户列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return wbUserAddressDetailService.selectList(null);
    }

    /**
     * 新增用户
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(WbUserAddressDetail wbUserAddressDetail) {
        wbUserAddressDetailService.insert(wbUserAddressDetail);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer wbUserAddressDetailId) {
        wbUserAddressDetailService.deleteById(wbUserAddressDetailId);
        return SUCCESS_TIP;
    }

    /**
     * 修改用户
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(WbUserAddressDetail wbUserAddressDetail) {
        wbUserAddressDetailService.updateById(wbUserAddressDetail);
        return super.SUCCESS_TIP;
    }

    /**
     * 用户详情
     */
    @RequestMapping(value = "/detail/{wbUserAddressDetailId}")
    @ResponseBody
    public Object detail(@PathVariable("wbUserAddressDetailId") Integer wbUserAddressDetailId) {
        return wbUserAddressDetailService.selectById(wbUserAddressDetailId);
    }
}
