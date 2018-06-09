/**
 * 初始化产品规格值配置详情对话框
 */
var WkProductSpecValueInfoDlg = {
    wkProductSpecValueInfoData : {}
};

/**
 * 清除数据
 */
WkProductSpecValueInfoDlg.clearData = function() {
    this.wkProductSpecValueInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WkProductSpecValueInfoDlg.set = function(key, val) {
    this.wkProductSpecValueInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WkProductSpecValueInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
WkProductSpecValueInfoDlg.close = function() {
    parent.layer.close(window.parent.WkProductSpecValue.layerIndex);
}

/**
 * 收集数据
 */
WkProductSpecValueInfoDlg.collectData = function() {
    this
    .set('id')
    .set('specId')
    .set('specValue')
    .set('createdBy')
    .set('createdDate')
    .set('lastUpdatedBy')
    .set('lastUpdateDate')
    ;
}

/**
 * 提交添加
 */
WkProductSpecValueInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wkProductSpecValue/add", function(data){
        Feng.success("添加成功!");
        window.parent.WkProductSpecValue.table.refresh();
        WkProductSpecValueInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wkProductSpecValueInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
WkProductSpecValueInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wkProductSpecValue/update", function(data){
        Feng.success("修改成功!");
        window.parent.WkProductSpecValue.table.refresh();
        WkProductSpecValueInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wkProductSpecValueInfoData);
    ajax.start();
}

$(function() {

});
