/**
 * 初始化产品图片关联信息配置详情对话框
 */
var ProductPictureInfoDlg = {
    productPictureInfoData : {}
};

/**
 * 清除数据
 */
ProductPictureInfoDlg.clearData = function() {
    this.productPictureInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProductPictureInfoDlg.set = function(key, val) {
    this.productPictureInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProductPictureInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ProductPictureInfoDlg.close = function() {
    parent.layer.close(window.parent.ProductPicture.layerIndex);
}

/**
 * 收集数据
 */
ProductPictureInfoDlg.collectData = function() {
    this
    .set('id')
    .set('productId')
    .set('fileUid')
    .set('createdBy')
    .set('createdDate')
    .set('lastUpdatedBy')
    .set('lastUpdatedDate')
    ;
}

/**
 * 提交添加
 */
ProductPictureInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/productPicture/add", function(data){
        Feng.success("添加成功!");
        window.parent.ProductPicture.table.refresh();
        ProductPictureInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.productPictureInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ProductPictureInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/productPicture/update", function(data){
        Feng.success("修改成功!");
        window.parent.ProductPicture.table.refresh();
        ProductPictureInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.productPictureInfoData);
    ajax.start();
}

$(function() {

});
