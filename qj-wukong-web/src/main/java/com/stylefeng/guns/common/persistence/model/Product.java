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
 * 产品
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-08
 */
@TableName("wk_product")
public class Product extends Model<Product> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="product_id", type= IdType.AUTO)
	private Integer productId;
    /**
     * 商品名称
     */
	@TableField("product_name")
	private String productName;
    /**
     * 商品描述
     */
	private String description;
    /**
     * 商品类别id
     */
	@TableField("category_id")
	private String categoryId;
    /**
     * 商品属性
     */
	@TableField("paramter_attr")
	private String paramterAttr;
    /**
     * 商品参数
     */
	@TableField("paramter_json")
	private String paramterJson;
    /**
     * 上架状态
     */
	private Integer status;
    /**
     * 是否首推0:否,1:是
     */
	@TableField("is_push")
	private Integer isPush;
    /**
     * 排序
     */
	@TableField("order_by")
	private Integer orderBy;
    /**
     * 创建人id
     */
	@TableField("created_by")
	private Integer createdBy;
    /**
     * 创建时间
     */
	@TableField("created_date")
	private Date createdDate;
    /**
     * 最后更新人员id
     */
	@TableField("last_updated_by")
	private Integer lastUpdatedBy;
    /**
     * 修改时间
     */
	@TableField("last_update_date")
	private Date lastUpdateDate;
    /**
     * 数据状态0:已删除,1正常
     */
	@TableField("data_status")
	private Integer dataStatus;


	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getParamterAttr() {
		return paramterAttr;
	}

	public void setParamterAttr(String paramterAttr) {
		this.paramterAttr = paramterAttr;
	}

	public String getParamterJson() {
		return paramterJson;
	}

	public void setParamterJson(String paramterJson) {
		this.paramterJson = paramterJson;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsPush() {
		return isPush;
	}

	public void setIsPush(Integer isPush) {
		this.isPush = isPush;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
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
		return this.productId;
	}

	@Override
	public String toString() {
		return "Product{" +
			"productId=" + productId +
			", productName=" + productName +
			", description=" + description +
			", categoryId=" + categoryId +
			", paramterAttr=" + paramterAttr +
			", paramterJson=" + paramterJson +
			", status=" + status +
			", isPush=" + isPush +
			", orderBy=" + orderBy +
			", createdBy=" + createdBy +
			", createdDate=" + createdDate +
			", lastUpdatedBy=" + lastUpdatedBy +
			", lastUpdateDate=" + lastUpdateDate +
			", dataStatus=" + dataStatus +
			"}";
	}
}
