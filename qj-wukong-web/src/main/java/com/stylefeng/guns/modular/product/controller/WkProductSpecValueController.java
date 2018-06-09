package com.stylefeng.guns.modular.product.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.common.persistence.model.WkProductSpecValue;
import com.stylefeng.guns.modular.product.service.IWkProductSpecValueService;

/**
 * 产品规格值配置控制器
 *
 * @author fengshuonan
 * @Date 2018-06-08 23:44:36
 */
@Controller
@RequestMapping("/wkProductSpecValue")
public class WkProductSpecValueController extends BaseController {

    private String PREFIX = "/product/wkProductSpecValue/";

    @Autowired
    private IWkProductSpecValueService wkProductSpecValueService;

    /**
     * 跳转到产品规格值配置首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "wkProductSpecValue.html";
    }

    /**
     * 跳转到添加产品规格值配置
     */
    @RequestMapping("/wkProductSpecValue_add")
    public String wkProductSpecValueAdd() {
        return PREFIX + "wkProductSpecValue_add.html";
    }

    /**
     * 跳转到修改产品规格值配置
     */
    @RequestMapping("/wkProductSpecValue_update/{wkProductSpecValueId}")
    public String wkProductSpecValueUpdate(@PathVariable Integer wkProductSpecValueId, Model model) {
        WkProductSpecValue wkProductSpecValue = wkProductSpecValueService.selectById(wkProductSpecValueId);
        model.addAttribute("item",wkProductSpecValue);
        LogObjectHolder.me().set(wkProductSpecValue);
        return PREFIX + "wkProductSpecValue_edit.html";
    }

    /**
     * 获取产品规格值配置列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return wkProductSpecValueService.selectList(null);
    }

    /**
     * 新增产品规格值配置
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(WkProductSpecValue wkProductSpecValue) {
        wkProductSpecValueService.insert(wkProductSpecValue);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除产品规格值配置
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer wkProductSpecValueId) {
        wkProductSpecValueService.deleteById(wkProductSpecValueId);
        return SUCCESS_TIP;
    }

    /**
     * 修改产品规格值配置
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(WkProductSpecValue wkProductSpecValue) {
        wkProductSpecValueService.updateById(wkProductSpecValue);
        return super.SUCCESS_TIP;
    }

    /**
     * 产品规格值配置详情
     */
    @RequestMapping(value = "/detail/{wkProductSpecValueId}")
    @ResponseBody
    public Object detail(@PathVariable("wkProductSpecValueId") Integer wkProductSpecValueId) {
        return wkProductSpecValueService.selectById(wkProductSpecValueId);
    }
}
