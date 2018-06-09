package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户隐私文件
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-08
 */
@TableName("wk_upload_file")
public class UploadFile extends Model<UploadFile> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 文件uuid
     */
	@TableField("file_uid")
	private String fileUid;
    /**
     * 用户id
     */
	@TableField("user_id")
	private Integer userId;
    /**
     * 文件类型1-身份证正面
     */
	@TableField("file_type")
	private String fileType;
    /**
     * 文件路径
     */
	@TableField("file_path")
	private String filePath;
    /**
     * 上传时间
     */
	@TableField("upload_time")
	private Date uploadTime;
    /**
     * 所属项目值
     */
	private String project;
    /**
     * 创建人
     */
	@TableField("created_by")
	private Integer createdBy;
    /**
     * 创建时间
     */
	@TableField("created_date")
	private Date createdDate;
    /**
     * 最后更新人ID
     */
	@TableField("last_updated_by")
	private Integer lastUpdatedBy;
    /**
     * 最后更新时间
     */
	@TableField("last_update_date")
	private Date lastUpdateDate;
    /**
     * 数据状态0:已删除,1正常
     */
	@TableField("data_status")
	private Integer dataStatus;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileUid() {
		return fileUid;
	}

	public void setFileUid(String fileUid) {
		this.fileUid = fileUid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Integer lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Integer getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "UploadFile{" +
			"id=" + id +
			", fileUid=" + fileUid +
			", userId=" + userId +
			", fileType=" + fileType +
			", filePath=" + filePath +
			", uploadTime=" + uploadTime +
			", project=" + project +
			", createdBy=" + createdBy +
			", createdDate=" + createdDate +
			", lastUpdatedBy=" + lastUpdatedBy +
			", lastUpdateDate=" + lastUpdateDate +
			", dataStatus=" + dataStatus +
			"}";
	}
}
