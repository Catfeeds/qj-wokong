/**
 * 初始化用户地址管理详情对话框
 */
var UserAddressInfoDlg = {
    userAddressInfoData : {}
};

/**
 * 清除数据
 */
UserAddressInfoDlg.clearData = function() {
    this.userAddressInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UserAddressInfoDlg.set = function(key, val) {
    this.userAddressInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UserAddressInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
UserAddressInfoDlg.close = function() {
    parent.layer.close(window.parent.UserAddress.layerIndex);
}

/**
 * 收集数据
 */
UserAddressInfoDlg.collectData = function() {
    this
    .set('id')
    .set('weChatId')
    .set('provinceId')
    .set('cityId')
    .set('areaId')
    .set('address')
    .set('userName')
    .set('consignee')
    .set('phoneNo')
    .set('code')
    .set('isDefault')
    .set('createdBy')
    .set('createdDate')
    .set('lastUpdatedBy')
    .set('lastUpdateDate')
    ;
}

/**
 * 提交添加
 */
UserAddressInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/userAddress/add", function(data){
        Feng.success("添加成功!");
        window.parent.UserAddress.table.refresh();
        UserAddressInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.userAddressInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
UserAddressInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/userAddress/update", function(data){
        Feng.success("修改成功!");
        window.parent.UserAddress.table.refresh();
        UserAddressInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.userAddressInfoData);
    ajax.start();
}

$(function() {

});
