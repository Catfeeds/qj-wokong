/**
 * 订单管理管理初始化
 */
var UserOrder = {
    id: "UserOrderTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
UserOrder.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '订单号', field: 'orderNo', visible: true, align: 'center', valign: 'middle'},
            {title: '微信id', field: 'weChatId', visible: true, align: 'center', valign: 'middle'},
            {title: '商品id', field: 'productId', visible: true, align: 'center', valign: 'middle'},
            {title: '订单价格', field: 'orderMoney', visible: true, align: 'center', valign: 'middle'},
            {title: '订单数量', field: 'orderNum', visible: true, align: 'center', valign: 'middle'},
            {title: '订单状态', field: 'orderStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '是否可用', field: 'isEnable', visible: true, align: 'center', valign: 'middle'},
            {title: '创建人ID', field: 'createdBy', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createdDate', visible: true, align: 'center', valign: 'middle'},
            {title: '最后更新人ID', field: 'lastUpdatedBy', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'lastUpdatedDate', visible: true, align: 'center', valign: 'middle'},
            {title: '数据状态0:已删除,1正常', field: 'dataStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '地址ID', field: 'addressId', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
UserOrder.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        UserOrder.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加订单管理
 */
UserOrder.openAddUserOrder = function () {
    var index = layer.open({
        type: 2,
        title: '添加订单管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/userOrder/userOrder_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看订单管理详情
 */
UserOrder.openUserOrderDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '订单管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/userOrder/userOrder_update/' + UserOrder.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除订单管理
 */
UserOrder.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/userOrder/delete", function (data) {
            Feng.success("删除成功!");
            UserOrder.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("userOrderId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询订单管理列表
 */
UserOrder.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    UserOrder.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = UserOrder.initColumn();
    var table = new BSTable(UserOrder.id, "/userOrder/list", defaultColunms);
    table.setPaginationType("client");
    UserOrder.table = table.init();
});
