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
import com.stylefeng.guns.common.persistence.model.WkProductSpecGl;
import com.stylefeng.guns.modular.product.service.IWkProductSpecGlService;

/**
 * 产品规格关联配置控制器
 *
 * @author fengshuonan
 * @Date 2018-06-08 23:46:05
 */
@Controller
@RequestMapping("/wkProductSpecGl")
public class WkProductSpecGlController extends BaseController {

    private String PREFIX = "/product/wkProductSpecGl/";

    @Autowired
    private IWkProductSpecGlService wkProductSpecGlService;

    /**
     * 跳转到产品规格关联配置首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "wkProductSpecGl.html";
    }

    /**
     * 跳转到添加产品规格关联配置
     */
    @RequestMapping("/wkProductSpecGl_add")
    public String wkProductSpecGlAdd() {
        return PREFIX + "wkProductSpecGl_add.html";
    }

    /**
     * 跳转到修改产品规格关联配置
     */
    @RequestMapping("/wkProductSpecGl_update/{wkProductSpecGlId}")
    public String wkProductSpecGlUpdate(@PathVariable Integer wkProductSpecGlId, Model model) {
        WkProductSpecGl wkProductSpecGl = wkProductSpecGlService.selectById(wkProductSpecGlId);
        model.addAttribute("item",wkProductSpecGl);
        LogObjectHolder.me().set(wkProductSpecGl);
        return PREFIX + "wkProductSpecGl_edit.html";
    }

    /**
     * 获取产品规格关联配置列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return wkProductSpecGlService.selectList(null);
    }

    /**
     * 新增产品规格关联配置
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(WkProductSpecGl wkProductSpecGl) {
        wkProductSpecGlService.insert(wkProductSpecGl);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除产品规格关联配置
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer wkProductSpecGlId) {
        wkProductSpecGlService.deleteById(wkProductSpecGlId);
        return SUCCESS_TIP;
    }

    /**
     * 修改产品规格关联配置
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(WkProductSpecGl wkProductSpecGl) {
        wkProductSpecGlService.updateById(wkProductSpecGl);
        return super.SUCCESS_TIP;
    }

    /**
     * 产品规格关联配置详情
     */
    @RequestMapping(value = "/detail/{wkProductSpecGlId}")
    @ResponseBody
    public Object detail(@PathVariable("wkProductSpecGlId") Integer wkProductSpecGlId) {
        return wkProductSpecGlService.selectById(wkProductSpecGlId);
    }
}
