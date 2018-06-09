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
 * 用户地址
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-09
 */
@TableName("wk_user_address")
public class UserAddress extends Model<UserAddress> {

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
     * 省份id
     */
	@TableField("province_id")
	private String provinceId;
    /**
     * 城市id
     */
	@TableField("city_id")
	private String cityId;
    /**
     * 区域id
     */
	@TableField("area_id")
	private String areaId;
    /**
     * 收货地址
     */
	private String address;
    /**
     * 收货人名称
     */
	@TableField("user_name")
	private String userName;
    /**
     * 收货人
     */
	private String consignee;
    /**
     * 手机号
     */
	@TableField("phone_no")
	private String phoneNo;
    /**
     * 邮编
     */
	private String code;
    /**
     * 是否是默认地址 0:默认 1:非默认
     */
	@TableField("is_default")
	private Integer isDefault;
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
     * 最后更新修改时间
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

	public Integer getWeChatId() {
		return weChatId;
	}

	public void setWeChatId(Integer weChatId) {
		this.weChatId = weChatId;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
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
		return "UserAddress{" +
			"id=" + id +
			", weChatId=" + weChatId +
			", provinceId=" + provinceId +
			", cityId=" + cityId +
			", areaId=" + areaId +
			", address=" + address +
			", userName=" + userName +
			", consignee=" + consignee +
			", phoneNo=" + phoneNo +
			", code=" + code +
			", isDefault=" + isDefault +
			", createdBy=" + createdBy +
			", createdDate=" + createdDate +
			", lastUpdatedBy=" + lastUpdatedBy +
			", lastUpdateDate=" + lastUpdateDate +
			", dataStatus=" + dataStatus +
			"}";
	}
}
