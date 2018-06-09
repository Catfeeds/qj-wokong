/**
 * 产品管理初始化
 */
var Product = {
    id: "ProductTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Product.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'productId', visible: true, align: 'center', valign: 'middle'},
            {title: '商品名称', field: 'productName', visible: true, align: 'center', valign: 'middle'},
            {title: '商品描述', field: 'description', visible: true, align: 'center', valign: 'middle'},
            {title: '商品类别id', field: 'categoryId', visible: true, align: 'center', valign: 'middle'},
            {title: '商品属性', field: 'paramterAttr', visible: true, align: 'center', valign: 'middle'},
            {title: '商品参数', field: 'paramterJson', visible: true, align: 'center', valign: 'middle'},
            {title: '上架状态', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '是否首推0:否,1:是', field: 'isPush', visible: true, align: 'center', valign: 'middle'},
            {title: '排序', field: 'orderBy', visible: true, align: 'center', valign: 'middle'},
            {title: '创建人id', field: 'createdBy', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createdDate', visible: true, align: 'center', valign: 'middle'},
            {title: '最后更新人员id', field: 'lastUpdatedBy', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'lastUpdateDate', visible: true, align: 'center', valign: 'middle'},
            {title: '数据状态0:已删除,1正常', field: 'dataStatus', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Product.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Product.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加产品
 */
Product.openAddProduct = function () {
    var index = layer.open({
        type: 2,
        title: '添加产品',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/product/product_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看产品详情
 */
Product.openProductDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/product/product_update/' + Product.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除产品
 */
Product.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/product/delete", function (data) {
            Feng.success("删除成功!");
            Product.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("productId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询产品列表
 */
Product.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Product.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Product.initColumn();
    var table = new BSTable(Product.id, "/product/list", defaultColunms);
    table.setPaginationType("client");
    Product.table = table.init();
});
