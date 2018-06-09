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
import com.stylefeng.guns.common.persistence.model.ProductCategory;
import com.stylefeng.guns.modular.product.service.IProductCategoryService;

/**
 * 产品类别控制器
 *
 * @author fengshuonan
 * @Date 2018-06-08 23:37:01
 */
@Controller
@RequestMapping("/productCategory")
public class ProductCategoryController extends BaseController {

    private String PREFIX = "/product/productCategory/";

    @Autowired
    private IProductCategoryService productCategoryService;

    /**
     * 跳转到产品类别首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "productCategory.html";
    }

    /**
     * 跳转到添加产品类别
     */
    @RequestMapping("/productCategory_add")
    public String productCategoryAdd() {
        return PREFIX + "productCategory_add.html";
    }

    /**
     * 跳转到修改产品类别
     */
    @RequestMapping("/productCategory_update/{productCategoryId}")
    public String productCategoryUpdate(@PathVariable Integer productCategoryId, Model model) {
        ProductCategory productCategory = productCategoryService.selectById(productCategoryId);
        model.addAttribute("item",productCategory);
        LogObjectHolder.me().set(productCategory);
        return PREFIX + "productCategory_edit.html";
    }

    /**
     * 获取产品类别列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return productCategoryService.selectList(null);
    }

    /**
     * 新增产品类别
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(ProductCategory productCategory) {
        productCategoryService.insert(productCategory);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除产品类别
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer productCategoryId) {
        productCategoryService.deleteById(productCategoryId);
        return SUCCESS_TIP;
    }

    /**
     * 修改产品类别
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(ProductCategory productCategory) {
        productCategoryService.updateById(productCategory);
        return super.SUCCESS_TIP;
    }

    /**
     * 产品类别详情
     */
    @RequestMapping(value = "/detail/{productCategoryId}")
    @ResponseBody
    public Object detail(@PathVariable("productCategoryId") Integer productCategoryId) {
        return productCategoryService.selectById(productCategoryId);
    }
}
