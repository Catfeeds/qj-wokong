/**
 * 初始化订单管理详情对话框
 */
var WbUserOrderDetailInfoDlg = {
    wbUserOrderDetailInfoData : {}
};

/**
 * 清除数据
 */
WbUserOrderDetailInfoDlg.clearData = function() {
    this.wbUserOrderDetailInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WbUserOrderDetailInfoDlg.set = function(key, val) {
    this.wbUserOrderDetailInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WbUserOrderDetailInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
WbUserOrderDetailInfoDlg.close = function() {
    parent.layer.close(window.parent.WbUserOrderDetail.layerIndex);
}

/**
 * 收集数据
 */
WbUserOrderDetailInfoDlg.collectData = function() {
    this
    .set('id')
    .set('orderNo')
    .set('weChatId')
    .set('productId')
    .set('orderMoney')
    .set('orderNum')
    .set('orderStatus')
    .set('isEnable')
    .set('createdDate')
    ;
}

/**
 * 提交添加
 */
WbUserOrderDetailInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wbUserOrderDetail/add", function(data){
        Feng.success("添加成功!");
        window.parent.WbUserOrderDetail.table.refresh();
        WbUserOrderDetailInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wbUserOrderDetailInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
WbUserOrderDetailInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wbUserOrderDetail/update", function(data){
        Feng.success("修改成功!");
        window.parent.WbUserOrderDetail.table.refresh();
        WbUserOrderDetailInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wbUserOrderDetailInfoData);
    ajax.start();
}

$(function() {

});
