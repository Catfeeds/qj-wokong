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
import com.stylefeng.guns.common.persistence.model.ProductPicture;
import com.stylefeng.guns.modular.product.service.IProductPictureService;

/**
 * 产品图片关联信息配置控制器
 *
 * @author fengshuonan
 * @Date 2018-06-08 23:57:40
 */
@Controller
@RequestMapping("/productPicture")
public class ProductPictureController extends BaseController {

    private String PREFIX = "/product/productPicture/";

    @Autowired
    private IProductPictureService productPictureService;

    /**
     * 跳转到产品图片关联信息配置首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "productPicture.html";
    }

    /**
     * 跳转到添加产品图片关联信息配置
     */
    @RequestMapping("/productPicture_add")
    public String productPictureAdd() {
        return PREFIX + "productPicture_add.html";
    }

    /**
     * 跳转到修改产品图片关联信息配置
     */
    @RequestMapping("/productPicture_update/{productPictureId}")
    public String productPictureUpdate(@PathVariable Integer productPictureId, Model model) {
        ProductPicture productPicture = productPictureService.selectById(productPictureId);
        model.addAttribute("item",productPicture);
        LogObjectHolder.me().set(productPicture);
        return PREFIX + "productPicture_edit.html";
    }

    /**
     * 获取产品图片关联信息配置列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return productPictureService.selectList(null);
    }

    /**
     * 新增产品图片关联信息配置
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(ProductPicture productPicture) {
        productPictureService.insert(productPicture);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除产品图片关联信息配置
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer productPictureId) {
        productPictureService.deleteById(productPictureId);
        return SUCCESS_TIP;
    }

    /**
     * 修改产品图片关联信息配置
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(ProductPicture productPicture) {
        productPictureService.updateById(productPicture);
        return super.SUCCESS_TIP;
    }

    /**
     * 产品图片关联信息配置详情
     */
    @RequestMapping(value = "/detail/{productPictureId}")
    @ResponseBody
    public Object detail(@PathVariable("productPictureId") Integer productPictureId) {
        return productPictureService.selectById(productPictureId);
    }
}
