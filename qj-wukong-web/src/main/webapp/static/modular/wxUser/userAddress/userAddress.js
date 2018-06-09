/**
 * 用户地址管理管理初始化
 */
var UserAddress = {
    id: "UserAddressTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
UserAddress.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '微信id', field: 'weChatId', visible: true, align: 'center', valign: 'middle'},
            {title: '省份id', field: 'provinceId', visible: true, align: 'center', valign: 'middle'},
            {title: '城市id', field: 'cityId', visible: true, align: 'center', valign: 'middle'},
            {title: '区域id', field: 'areaId', visible: true, align: 'center', valign: 'middle'},
            {title: '收货地址', field: 'address', visible: true, align: 'center', valign: 'middle'},
            {title: '收货人名称', field: 'userName', visible: true, align: 'center', valign: 'middle'},
            {title: '收货人', field: 'consignee', visible: true, align: 'center', valign: 'middle'},
            {title: '手机号', field: 'phoneNo', visible: true, align: 'center', valign: 'middle'},
            {title: '邮编', field: 'code', visible: true, align: 'center', valign: 'middle'},
            {title: '是否是默认地址 0:默认 1:非默认', field: 'isDefault', visible: true, align: 'center', valign: 'middle'},
            {title: '创建人ID', field: 'createdBy', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createdDate', visible: true, align: 'center', valign: 'middle'},
            {title: '最后更新人ID', field: 'lastUpdatedBy', visible: true, align: 'center', valign: 'middle'},
            {title: '最后更新修改时间', field: 'lastUpdateDate', visible: true, align: 'center', valign: 'middle'},
            {title: '数据状态0:已删除,1正常', field: 'dataStatus', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
UserAddress.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        UserAddress.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加用户地址管理
 */
UserAddress.openAddUserAddress = function () {
    var index = layer.open({
        type: 2,
        title: '添加用户地址管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/userAddress/userAddress_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看用户地址管理详情
 */
UserAddress.openUserAddressDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '用户地址管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/userAddress/userAddress_update/' + UserAddress.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除用户地址管理
 */
UserAddress.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/userAddress/delete", function (data) {
            Feng.success("删除成功!");
            UserAddress.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("userAddressId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询用户地址管理列表
 */
UserAddress.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    UserAddress.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = UserAddress.initColumn();
    var table = new BSTable(UserAddress.id, "/userAddress/list", defaultColunms);
    table.setPaginationType("client");
    UserAddress.table = table.init();
});
