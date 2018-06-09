package com.stylefeng.guns.modular.wx.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stylefeng.guns.common.persistence.model.Customer;
import com.stylefeng.guns.common.persistence.model.User;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.ErrorTip;

/**
 * 
 * @author zhou
 *
 */
@Controller
@RequestMapping("/wx/shopCart")
public class ShopCartController extends BaseController {

    /**
     * 查询列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    	List<User>  list = new ArrayList<User>();
    	User user1 = new User();
    	user1.setId(1);
    	user1.setName("小明");
        return list;
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Customer customer) {
        return SUCCESS_TIP;
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Long shopId) {
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Customer customer) {
        return SUCCESS_TIP;
    }
    
    /**
     * 错误
     * 80-成功
     * 90-错误
     */
    @RequestMapping(value = "/error")
    @ResponseBody
    public ErrorTip error() {
    	 return new ErrorTip(8010, "运行报错");
    }
}
