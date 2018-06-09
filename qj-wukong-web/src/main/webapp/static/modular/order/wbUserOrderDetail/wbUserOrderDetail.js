/**
 * 订单管理管理初始化
 */
var WbUserOrderDetail = {
    id: "WbUserOrderDetailTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
WbUserOrderDetail.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '订单号', field: 'orderNo', visible: true, align: 'center', valign: 'middle'},
            {title: '商品名称', field: 'productName', visible: true, align: 'center', valign: 'middle'},
            {title: '收货地址', field: 'address', visible: true, align: 'center', valign: 'middle'},
            {title: '收货号码', field: 'phoneNo', visible: true, align: 'center', valign: 'middle'},
            {title: '订单价格', field: 'orderMoney', visible: true, align: 'center', valign: 'middle'},
            {title: '商品颜色', field: 'colour', visible: true, align: 'center', valign: 'middle'},
            {title: '商品尺寸', field: 'dimens', visible: true, align: 'center', valign: 'middle'},
            {title: '订单数量', field: 'orderNum', visible: true, align: 'center', valign: 'middle'},
            {title: '订单状态', field: 'orderStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createdDate', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
WbUserOrderDetail.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        WbUserOrderDetail.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加订单管理
 */
WbUserOrderDetail.openAddWbUserOrderDetail = function () {
    var index = layer.open({
        type: 2,
        title: '添加订单管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/wbUserOrderDetail/wbUserOrderDetail_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看订单管理详情
 */
WbUserOrderDetail.openWbUserOrderDetailDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '订单管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wbUserOrderDetail/wbUserOrderDetail_update/' + WbUserOrderDetail.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除订单管理
 */
WbUserOrderDetail.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/wbUserOrderDetail/delete", function (data) {
            Feng.success("删除成功!");
            WbUserOrderDetail.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("wbUserOrderDetailId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询订单管理列表
 */
WbUserOrderDetail.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    WbUserOrderDetail.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = WbUserOrderDetail.initColumn();
    var table = new BSTable(WbUserOrderDetail.id, "/wbUserOrderDetail/list", defaultColunms);
    table.setPaginationType("client");
    WbUserOrderDetail.table = table.init();
});
