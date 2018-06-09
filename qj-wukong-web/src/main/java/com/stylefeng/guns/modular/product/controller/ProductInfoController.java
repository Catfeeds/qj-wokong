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
import com.stylefeng.guns.common.persistence.model.ProductInfo;
import com.stylefeng.guns.modular.product.service.IProductInfoService;

/**
 * 产品详情控制器
 *
 * @author fengshuonan
 * @Date 2018-06-09 17:44:23
 */
@Controller
@RequestMapping("/productInfo")
public class ProductInfoController extends BaseController {

    private String PREFIX = "/product/productInfo/";

    @Autowired
    private IProductInfoService productInfoService;

    /**
     * 跳转到产品详情首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "productInfo.html";
    }

    /**
     * 跳转到添加产品详情
     */
    @RequestMapping("/productInfo_add")
    public String productInfoAdd() {
        return PREFIX + "productInfo_add.html";
    }

    /**
     * 跳转到修改产品详情
     */
    @RequestMapping("/productInfo_update/{productInfoId}")
    public String productInfoUpdate(@PathVariable Integer productInfoId, Model model) {
        ProductInfo productInfo = productInfoService.selectById(productInfoId);
        model.addAttribute("item",productInfo);
        LogObjectHolder.me().set(productInfo);
        return PREFIX + "productInfo_edit.html";
    }

    /**
     * 获取产品详情列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return productInfoService.selectList(null);
    }

    /**
     * 新增产品详情
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(ProductInfo productInfo) {
        productInfoService.insert(productInfo);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除产品详情
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer productInfoId) {
        productInfoService.deleteById(productInfoId);
        return SUCCESS_TIP;
    }

    /**
     * 修改产品详情
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(ProductInfo productInfo) {
        productInfoService.updateById(productInfo);
        return super.SUCCESS_TIP;
    }

    /**
     * 产品详情详情
     */
    @RequestMapping(value = "/detail/{productInfoId}")
    @ResponseBody
    public Object detail(@PathVariable("productInfoId") Integer productInfoId) {
        return productInfoService.selectById(productInfoId);
    }
}
