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
 * 产品规格值表
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-08
 */
@TableName("wk_product_spec_value")
public class WkProductSpecValue extends Model<WkProductSpecValue> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 规格id
     */
	@TableField("spec_id")
	private Integer specId;
    /**
     * 规格值
     */
	@TableField("spec_value")
	private String specValue;
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

	public Integer getSpecId() {
		return specId;
	}

	public void setSpecId(Integer specId) {
		this.specId = specId;
	}

	public String getSpecValue() {
		return specValue;
	}

	public void setSpecValue(String specValue) {
		this.specValue = specValue;
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
		return "WkProductSpecValue{" +
			"id=" + id +
			", specId=" + specId +
			", specValue=" + specValue +
			", createdBy=" + createdBy +
			", createdDate=" + createdDate +
			", lastUpdatedBy=" + lastUpdatedBy +
			", lastUpdateDate=" + lastUpdateDate +
			", dataStatus=" + dataStatus +
			"}";
	}
}
