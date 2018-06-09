/**
 * 用户隐私文件p配置管理初始化
 */
var UploadFile = {
    id: "UploadFileTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
UploadFile.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '文件uuid', field: 'fileUid', visible: true, align: 'center', valign: 'middle'},
            {title: '用户id', field: 'userId', visible: true, align: 'center', valign: 'middle'},
            {title: '文件类型1-身份证正面', field: 'fileType', visible: true, align: 'center', valign: 'middle'},
            {title: '文件路径', field: 'filePath', visible: true, align: 'center', valign: 'middle'},
            {title: '上传时间', field: 'uploadTime', visible: true, align: 'center', valign: 'middle'},
            {title: '所属项目值', field: 'project', visible: true, align: 'center', valign: 'middle'},
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
UploadFile.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        UploadFile.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加用户隐私文件p配置
 */
UploadFile.openAddUploadFile = function () {
    var index = layer.open({
        type: 2,
        title: '添加用户隐私文件p配置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/uploadFile/uploadFile_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看用户隐私文件p配置详情
 */
UploadFile.openUploadFileDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '用户隐私文件p配置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/uploadFile/uploadFile_update/' + UploadFile.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除用户隐私文件p配置
 */
UploadFile.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/uploadFile/delete", function (data) {
            Feng.success("删除成功!");
            UploadFile.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("uploadFileId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询用户隐私文件p配置列表
 */
UploadFile.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    UploadFile.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = UploadFile.initColumn();
    var table = new BSTable(UploadFile.id, "/uploadFile/list", defaultColunms);
    table.setPaginationType("client");
    UploadFile.table = table.init();
});
