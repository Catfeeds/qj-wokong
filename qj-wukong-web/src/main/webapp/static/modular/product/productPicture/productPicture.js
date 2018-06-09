/**
 * 产品图片关联信息配置管理初始化
 */
var ProductPicture = {
    id: "ProductPictureTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ProductPicture.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '商品id', field: 'productId', visible: true, align: 'center', valign: 'middle'},
            {title: '文件uuid', field: 'fileUid', visible: true, align: 'center', valign: 'middle'},
            {title: '创建人ID', field: 'createdBy', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createdDate', visible: true, align: 'center', valign: 'middle'},
            {title: '最后更新人ID', field: 'lastUpdatedBy', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'lastUpdatedDate', visible: true, align: 'center', valign: 'middle'},
            {title: '数据状态0:已删除,1正常', field: 'dataStatus', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
ProductPicture.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ProductPicture.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加产品图片关联信息配置
 */
ProductPicture.openAddProductPicture = function () {
    var index = layer.open({
        type: 2,
        title: '添加产品图片关联信息配置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/productPicture/productPicture_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看产品图片关联信息配置详情
 */
ProductPicture.openProductPictureDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品图片关联信息配置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/productPicture/productPicture_update/' + ProductPicture.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除产品图片关联信息配置
 */
ProductPicture.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/productPicture/delete", function (data) {
            Feng.success("删除成功!");
            ProductPicture.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("productPictureId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询产品图片关联信息配置列表
 */
ProductPicture.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    ProductPicture.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ProductPicture.initColumn();
    var table = new BSTable(ProductPicture.id, "/productPicture/list", defaultColunms);
    table.setPaginationType("client");
    ProductPicture.table = table.init();
});
