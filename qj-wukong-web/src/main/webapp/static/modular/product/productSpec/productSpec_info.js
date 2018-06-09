/**
 * 初始化产品规格配置详情对话框
 */
var ProductSpecInfoDlg = {
    productSpecInfoData : {}
};

/**
 * 清除数据
 */
ProductSpecInfoDlg.clearData = function() {
    this.productSpecInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProductSpecInfoDlg.set = function(key, val) {
    this.productSpecInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProductSpecInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ProductSpecInfoDlg.close = function() {
    parent.layer.close(window.parent.ProductSpec.layerIndex);
}

/**
 * 收集数据
 */
ProductSpecInfoDlg.collectData = function() {
    this
    .set('id')
    .set('specNo')
    .set('specName')
    .set('createdBy')
    .set('createdDate')
    .set('lastUpdatedBy')
    .set('lastUpdateDate')
    ;
}

/**
 * 提交添加
 */
ProductSpecInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/productSpec/add", function(data){
        Feng.success("添加成功!");
        window.parent.ProductSpec.table.refresh();
        ProductSpecInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.productSpecInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ProductSpecInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/productSpec/update", function(data){
        Feng.success("修改成功!");
        window.parent.ProductSpec.table.refresh();
        ProductSpecInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.productSpecInfoData);
    ajax.start();
}

$(function() {

});
