/**
 * 初始化用户隐私文件p配置详情对话框
 */
var UploadFileInfoDlg = {
    uploadFileInfoData : {}
};

/**
 * 清除数据
 */
UploadFileInfoDlg.clearData = function() {
    this.uploadFileInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UploadFileInfoDlg.set = function(key, val) {
    this.uploadFileInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UploadFileInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
UploadFileInfoDlg.close = function() {
    parent.layer.close(window.parent.UploadFile.layerIndex);
}

/**
 * 收集数据
 */
UploadFileInfoDlg.collectData = function() {
    this
    .set('id')
    .set('fileUid')
    .set('userId')
    .set('fileType')
    .set('filePath')
    .set('uploadTime')
    .set('project')
    .set('createdBy')
    .set('createdDate')
    .set('lastUpdatedBy')
    .set('lastUpdateDate')
    ;
}

/**
 * 提交添加
 */
UploadFileInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/uploadFile/add", function(data){
        Feng.success("添加成功!");
        window.parent.UploadFile.table.refresh();
        UploadFileInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.uploadFileInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
UploadFileInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/uploadFile/update", function(data){
        Feng.success("修改成功!");
        window.parent.UploadFile.table.refresh();
        UploadFileInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.uploadFileInfoData);
    ajax.start();
}

$(function() {

});
