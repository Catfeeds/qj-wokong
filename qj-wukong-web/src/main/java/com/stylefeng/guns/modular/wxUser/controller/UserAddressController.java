package com.stylefeng.guns.modular.wxUser.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.common.persistence.model.UserAddress;
import com.stylefeng.guns.modular.wxUser.service.IUserAddressService;

/**
 * 用户地址管理控制器
 *
 * @author fengshuonan
 * @Date 2018-06-09 17:48:55
 */
@Controller
@RequestMapping("/userAddress")
public class UserAddressController extends BaseController {

    private String PREFIX = "/wxUser/userAddress/";

    @Autowired
    private IUserAddressService userAddressService;

    /**
     * 跳转到用户地址管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "userAddress.html";
    }

    /**
     * 跳转到添加用户地址管理
     */
    @RequestMapping("/userAddress_add")
    public String userAddressAdd() {
        return PREFIX + "userAddress_add.html";
    }

    /**
     * 跳转到修改用户地址管理
     */
    @RequestMapping("/userAddress_update/{userAddressId}")
    public String userAddressUpdate(@PathVariable Integer userAddressId, Model model) {
        UserAddress userAddress = userAddressService.selectById(userAddressId);
        model.addAttribute("item",userAddress);
        LogObjectHolder.me().set(userAddress);
        return PREFIX + "userAddress_edit.html";
    }

    /**
     * 获取用户地址管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return userAddressService.selectList(null);
    }

    /**
     * 新增用户地址管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(UserAddress userAddress) {
        userAddressService.insert(userAddress);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除用户地址管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer userAddressId) {
        userAddressService.deleteById(userAddressId);
        return SUCCESS_TIP;
    }

    /**
     * 修改用户地址管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(UserAddress userAddress) {
        userAddressService.updateById(userAddress);
        return super.SUCCESS_TIP;
    }

    /**
     * 用户地址管理详情
     */
    @RequestMapping(value = "/detail/{userAddressId}")
    @ResponseBody
    public Object detail(@PathVariable("userAddressId") Integer userAddressId) {
        return userAddressService.selectById(userAddressId);
    }
}
