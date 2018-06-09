/**
 * 初始化产品规格关联配置详情对话框
 */
var WkProductSpecGlInfoDlg = {
    wkProductSpecGlInfoData : {}
};

/**
 * 清除数据
 */
WkProductSpecGlInfoDlg.clearData = function() {
    this.wkProductSpecGlInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WkProductSpecGlInfoDlg.set = function(key, val) {
    this.wkProductSpecGlInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WkProductSpecGlInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
WkProductSpecGlInfoDlg.close = function() {
    parent.layer.close(window.parent.WkProductSpecGl.layerIndex);
}

/**
 * 收集数据
 */
WkProductSpecGlInfoDlg.collectData = function() {
    this
    .set('id')
    .set('productId')
    .set('specId')
    .set('createdBy')
    .set('createdDate')
    .set('lastUpdatedBy')
    .set('lastUpdateDate')
    ;
}

/**
 * 提交添加
 */
WkProductSpecGlInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wkProductSpecGl/add", function(data){
        Feng.success("添加成功!");
        window.parent.WkProductSpecGl.table.refresh();
        WkProductSpecGlInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wkProductSpecGlInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
WkProductSpecGlInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wkProductSpecGl/update", function(data){
        Feng.success("修改成功!");
        window.parent.WkProductSpecGl.table.refresh();
        WkProductSpecGlInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wkProductSpecGlInfoData);
    ajax.start();
}

$(function() {

});
