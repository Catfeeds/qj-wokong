/**
 * 初始化产品详情详情对话框
 */
var ProductInfoInfoDlg = {
    productInfoInfoData : {}
};

/**
 * 清除数据
 */
ProductInfoInfoDlg.clearData = function() {
    this.productInfoInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProductInfoInfoDlg.set = function(key, val) {
    this.productInfoInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProductInfoInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ProductInfoInfoDlg.close = function() {
    parent.layer.close(window.parent.ProductInfo.layerIndex);
}

/**
 * 收集数据
 */
ProductInfoInfoDlg.collectData = function() {
    this
    .set('id')
    .set('productId')
    .set('stockNum')
    .set('price')
    .set('colour')
    .set('dimens')
    .set('createdBy')
    .set('createdDate')
    .set('lastUpdatedBy')
    .set('lastUpdateDate')
    ;
}

/**
 * 提交添加
 */
ProductInfoInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/productInfo/add", function(data){
        Feng.success("添加成功!");
        window.parent.ProductInfo.table.refresh();
        ProductInfoInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.productInfoInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ProductInfoInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/productInfo/update", function(data){
        Feng.success("修改成功!");
        window.parent.ProductInfo.table.refresh();
        ProductInfoInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.productInfoInfoData);
    ajax.start();
}

$(function() {

});
