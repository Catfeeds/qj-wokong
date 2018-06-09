/**
 * 初始化订单管理详情对话框
 */
var UserOrderInfoDlg = {
    userOrderInfoData : {}
};

/**
 * 清除数据
 */
UserOrderInfoDlg.clearData = function() {
    this.userOrderInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UserOrderInfoDlg.set = function(key, val) {
    this.userOrderInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UserOrderInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
UserOrderInfoDlg.close = function() {
    parent.layer.close(window.parent.UserOrder.layerIndex);
}

/**
 * 收集数据
 */
UserOrderInfoDlg.collectData = function() {
    this
    .set('id')
    .set('orderNo')
    .set('weChatId')
    .set('productId')
    .set('orderMoney')
    .set('orderNum')
    .set('orderStatus')
    .set('isEnable')
    .set('createdBy')
    .set('createdDate')
    .set('lastUpdatedBy')
    .set('lastUpdatedDate')
    .set('dataStatus')
    ;
}

/**
 * 提交添加
 */
UserOrderInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/userOrder/add", function(data){
        Feng.success("添加成功!");
        window.parent.UserOrder.table.refresh();
        UserOrderInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.userOrderInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
UserOrderInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/userOrder/update", function(data){
        Feng.success("修改成功!");
        window.parent.UserOrder.table.refresh();
        UserOrderInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.userOrderInfoData);
    ajax.start();
}

$(function() {

});
