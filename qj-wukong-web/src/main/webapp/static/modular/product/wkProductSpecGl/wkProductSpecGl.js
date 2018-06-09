/**
 * 产品规格关联配置管理初始化
 */
var WkProductSpecGl = {
    id: "WkProductSpecGlTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
WkProductSpecGl.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '产品ID', field: 'productId', visible: true, align: 'center', valign: 'middle'},
            {title: '规格ID', field: 'specId', visible: true, align: 'center', valign: 'middle'},
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
WkProductSpecGl.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        WkProductSpecGl.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加产品规格关联配置
 */
WkProductSpecGl.openAddWkProductSpecGl = function () {
    var index = layer.open({
        type: 2,
        title: '添加产品规格关联配置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/wkProductSpecGl/wkProductSpecGl_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看产品规格关联配置详情
 */
WkProductSpecGl.openWkProductSpecGlDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品规格关联配置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wkProductSpecGl/wkProductSpecGl_update/' + WkProductSpecGl.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除产品规格关联配置
 */
WkProductSpecGl.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/wkProductSpecGl/delete", function (data) {
            Feng.success("删除成功!");
            WkProductSpecGl.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("wkProductSpecGlId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询产品规格关联配置列表
 */
WkProductSpecGl.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    WkProductSpecGl.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = WkProductSpecGl.initColumn();
    var table = new BSTable(WkProductSpecGl.id, "/wkProductSpecGl/list", defaultColunms);
    table.setPaginationType("client");
    WkProductSpecGl.table = table.init();
});
