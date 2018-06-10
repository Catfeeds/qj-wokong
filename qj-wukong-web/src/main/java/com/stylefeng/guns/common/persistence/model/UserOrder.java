package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户订单
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-09
 */
@TableName("wk_user_order")
public class UserOrder extends Model<UserOrder> {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	/**
	 * 订单号
	 */
	@TableField("order_no")
	private Integer orderNo;
	/**
	 * 微信id
	 */
	@TableField("we_chat_id")
	private Integer weChatId;
	/**
	 * 商品id
	 */
	@TableField("product_id")
	private String productId;
	/**
	 * 订单价格
	 */
	@TableField("order_money")
	private BigDecimal orderMoney;
	/**
	 * 订单数量
	 */
	@TableField("order_num")
	private Integer orderNum;
	/**
	 * 订单状态
	 */
	@TableField("order_status")
	private Integer orderStatus;
	/**
	 * 是否可用
	 */
	@TableField("is_enable")
	private Integer isEnable;
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
	/**
	 * 地址ID
	 */
	@TableField("address_id")
	private Integer addressId;
	
	private List<ProductPicture> productPictures;

	public List<ProductPicture> getProductPictures() {
		return productPictures;
	}

	public void setProductPictures(List<ProductPicture> productPictures) {
		this.productPictures = productPictures;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getWeChatId() {
		return weChatId;
	}

	public void setWeChatId(Integer weChatId) {
		this.weChatId = weChatId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public BigDecimal getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(BigDecimal orderMoney) {
		this.orderMoney = orderMoney;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
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

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "UserOrder{" + "id=" + id + ", orderNo=" + orderNo + ", weChatId=" + weChatId + ", productId="
				+ productId + ", orderMoney=" + orderMoney + ", orderNum=" + orderNum + ", orderStatus=" + orderStatus
				+ ", isEnable=" + isEnable + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDate=" + lastUpdatedDate + ", dataStatus="
				+ dataStatus + ", addressId=" + addressId + "}";
	}
}
