/**
 * 产品规格值配置管理初始化
 */
var WkProductSpecValue = {
    id: "WkProductSpecValueTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
WkProductSpecValue.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '规格id', field: 'specId', visible: true, align: 'center', valign: 'middle'},
            {title: '规格值', field: 'specValue', visible: true, align: 'center', valign: 'middle'},
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
WkProductSpecValue.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        WkProductSpecValue.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加产品规格值配置
 */
WkProductSpecValue.openAddWkProductSpecValue = function () {
    var index = layer.open({
        type: 2,
        title: '添加产品规格值配置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/wkProductSpecValue/wkProductSpecValue_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看产品规格值配置详情
 */
WkProductSpecValue.openWkProductSpecValueDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品规格值配置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wkProductSpecValue/wkProductSpecValue_update/' + WkProductSpecValue.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除产品规格值配置
 */
WkProductSpecValue.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/wkProductSpecValue/delete", function (data) {
            Feng.success("删除成功!");
            WkProductSpecValue.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("wkProductSpecValueId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询产品规格值配置列表
 */
WkProductSpecValue.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    WkProductSpecValue.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = WkProductSpecValue.initColumn();
    var table = new BSTable(WkProductSpecValue.id, "/wkProductSpecValue/list", defaultColunms);
    table.setPaginationType("client");
    WkProductSpecValue.table = table.init();
});
