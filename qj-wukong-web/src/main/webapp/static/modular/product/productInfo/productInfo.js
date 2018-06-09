/**
 * 产品详情管理初始化
 */
var ProductInfo = {
    id: "ProductInfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ProductInfo.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '商品id', field: 'productId', visible: true, align: 'center', valign: 'middle'},
            {title: '商品库存', field: 'stockNum', visible: true, align: 'center', valign: 'middle'},
            {title: '商品价格', field: 'price', visible: true, align: 'center', valign: 'middle'},
            {title: '商品颜色', field: 'colour', visible: true, align: 'center', valign: 'middle'},
            {title: '商品尺寸', field: 'dimens', visible: true, align: 'center', valign: 'middle'},
            {title: '创建人id', field: 'createdBy', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createdDate', visible: true, align: 'center', valign: 'middle'},
            {title: '最后更新人ID', field: 'lastUpdatedBy', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'lastUpdateDate', visible: true, align: 'center', valign: 'middle'},
            {title: '数据状态0:已删除,1正常', field: 'dataStatus', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
ProductInfo.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ProductInfo.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加产品详情
 */
ProductInfo.openAddProductInfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加产品详情',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/productInfo/productInfo_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看产品详情详情
 */
ProductInfo.openProductInfoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品详情详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/productInfo/productInfo_update/' + ProductInfo.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除产品详情
 */
ProductInfo.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/productInfo/delete", function (data) {
            Feng.success("删除成功!");
            ProductInfo.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("productInfoId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询产品详情列表
 */
ProductInfo.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    ProductInfo.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ProductInfo.initColumn();
    var table = new BSTable(ProductInfo.id, "/productInfo/list", defaultColunms);
    table.setPaginationType("client");
    ProductInfo.table = table.init();
});
