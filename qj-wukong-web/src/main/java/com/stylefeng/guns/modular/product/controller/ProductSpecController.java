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
import com.stylefeng.guns.common.persistence.model.ProductSpec;
import com.stylefeng.guns.modular.product.service.IProductSpecService;

/**
 * 产品规格配置控制器
 *
 * @author fengshuonan
 * @Date 2018-06-08 23:42:56
 */
@Controller
@RequestMapping("/productSpec")
public class ProductSpecController extends BaseController {

    private String PREFIX = "/product/productSpec/";

    @Autowired
    private IProductSpecService productSpecService;

    /**
     * 跳转到产品规格配置首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "productSpec.html";
    }

    /**
     * 跳转到添加产品规格配置
     */
    @RequestMapping("/productSpec_add")
    public String productSpecAdd() {
        return PREFIX + "productSpec_add.html";
    }

    /**
     * 跳转到修改产品规格配置
     */
    @RequestMapping("/productSpec_update/{productSpecId}")
    public String productSpecUpdate(@PathVariable Integer productSpecId, Model model) {
        ProductSpec productSpec = productSpecService.selectById(productSpecId);
        model.addAttribute("item",productSpec);
        LogObjectHolder.me().set(productSpec);
        return PREFIX + "productSpec_edit.html";
    }

    /**
     * 获取产品规格配置列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return productSpecService.selectList(null);
    }

    /**
     * 新增产品规格配置
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(ProductSpec productSpec) {
        productSpecService.insert(productSpec);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除产品规格配置
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer productSpecId) {
        productSpecService.deleteById(productSpecId);
        return SUCCESS_TIP;
    }

    /**
     * 修改产品规格配置
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(ProductSpec productSpec) {
        productSpecService.updateById(productSpec);
        return super.SUCCESS_TIP;
    }

    /**
     * 产品规格配置详情
     */
    @RequestMapping(value = "/detail/{productSpecId}")
    @ResponseBody
    public Object detail(@PathVariable("productSpecId") Integer productSpecId) {
        return productSpecService.selectById(productSpecId);
    }
}
