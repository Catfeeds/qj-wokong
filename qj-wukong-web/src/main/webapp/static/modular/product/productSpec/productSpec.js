/**
 * 产品规格配置管理初始化
 */
var ProductSpec = {
    id: "ProductSpecTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ProductSpec.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '规格编号', field: 'specNo', visible: true, align: 'center', valign: 'middle'},
            {title: '规格名称', field: 'specName', visible: true, align: 'center', valign: 'middle'},
            {title: '创建人', field: 'createdBy', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createdDate', visible: true, align: 'center', valign: 'middle'},
            {title: '最后更新人ID', field: 'lastUpdatedBy', visible: true, align: 'center', valign: 'middle'},
            {title: '最后更新时间', field: 'lastUpdateDate', visible: true, align: 'center', valign: 'middle'},
            {title: '数据状态0:已删除,1正常', field: 'dataStatus', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
ProductSpec.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ProductSpec.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加产品规格配置
 */
ProductSpec.openAddProductSpec = function () {
    var index = layer.open({
        type: 2,
        title: '添加产品规格配置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/productSpec/productSpec_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看产品规格配置详情
 */
ProductSpec.openProductSpecDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品规格配置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/productSpec/productSpec_update/' + ProductSpec.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除产品规格配置
 */
ProductSpec.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/productSpec/delete", function (data) {
            Feng.success("删除成功!");
            ProductSpec.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("productSpecId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询产品规格配置列表
 */
ProductSpec.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    ProductSpec.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ProductSpec.initColumn();
    var table = new BSTable(ProductSpec.id, "/productSpec/list", defaultColunms);
    table.setPaginationType("client");
    ProductSpec.table = table.init();
});
