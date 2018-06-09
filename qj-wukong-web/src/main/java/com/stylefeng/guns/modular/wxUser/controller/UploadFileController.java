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
import com.stylefeng.guns.common.persistence.model.UploadFile;
import com.stylefeng.guns.modular.wxUser.service.IUploadFileService;

/**
 * 用户隐私文件管理控制器
 *
 * @author fengshuonan
 * @Date 2018-06-09 18:16:43
 */
@Controller
@RequestMapping("/uploadFile")
public class UploadFileController extends BaseController {

    private String PREFIX = "/wxUser/uploadFile/";

    @Autowired
    private IUploadFileService uploadFileService;

    /**
     * 跳转到用户隐私文件管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "uploadFile.html";
    }

    /**
     * 跳转到添加用户隐私文件管理
     */
    @RequestMapping("/uploadFile_add")
    public String uploadFileAdd() {
        return PREFIX + "uploadFile_add.html";
    }

    /**
     * 跳转到修改用户隐私文件管理
     */
    @RequestMapping("/uploadFile_update/{uploadFileId}")
    public String uploadFileUpdate(@PathVariable Integer uploadFileId, Model model) {
        UploadFile uploadFile = uploadFileService.selectById(uploadFileId);
        model.addAttribute("item",uploadFile);
        LogObjectHolder.me().set(uploadFile);
        return PREFIX + "uploadFile_edit.html";
    }

    /**
     * 获取用户隐私文件管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return uploadFileService.selectList(null);
    }

    /**
     * 新增用户隐私文件管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(UploadFile uploadFile) {
        uploadFileService.insert(uploadFile);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除用户隐私文件管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer uploadFileId) {
        uploadFileService.deleteById(uploadFileId);
        return SUCCESS_TIP;
    }

    /**
     * 修改用户隐私文件管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(UploadFile uploadFile) {
        uploadFileService.updateById(uploadFile);
        return super.SUCCESS_TIP;
    }

    /**
     * 用户隐私文件管理详情
     */
    @RequestMapping(value = "/detail/{uploadFileId}")
    @ResponseBody
    public Object detail(@PathVariable("uploadFileId") Integer uploadFileId) {
        return uploadFileService.selectById(uploadFileId);
    }
}
