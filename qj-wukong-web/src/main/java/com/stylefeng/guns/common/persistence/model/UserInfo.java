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
 * 用户表
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-09
 */
@TableName("wk_user_info")
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 微信id
     */
	@TableField("we_chat_id")
	private Integer weChatId;
    /**
     * 微信号
     */
	@TableField("we_chat_no")
	private String weChatNo;
    /**
     * 手机号
     */
	@TableField("phone_no")
	private String phoneNo;
    /**
     * 创建人ID
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
     * 修改时间
     */
	@TableField("last_updated_date")
	private Date lastUpdatedDate;
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

	public Integer getWeChatId() {
		return weChatId;
	}

	public void setWeChatId(Integer weChatId) {
		this.weChatId = weChatId;
	}

	public String getWeChatNo() {
		return weChatNo;
	}

	public void setWeChatNo(String weChatNo) {
		this.weChatNo = weChatNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
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
		return "UserInfo{" +
			"id=" + id +
			", weChatId=" + weChatId +
			", weChatNo=" + weChatNo +
			", phoneNo=" + phoneNo +
			", createdBy=" + createdBy +
			", createdDate=" + createdDate +
			", lastUpdatedBy=" + lastUpdatedBy +
			", lastUpdatedDate=" + lastUpdatedDate +
			", dataStatus=" + dataStatus +
			"}";
	}
}
