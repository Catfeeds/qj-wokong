package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户订单明细表
 * </p>
 *
 * @author gaoxuefeng
 * @since 2018-06-06
 */
@TableName("wb_user_order_detail")
public class WbUserOrderDetail extends Model<WbUserOrderDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	@TableId(value="id", type= IdType.AUTO)
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
     * 创建时间
     */
	@TableField("created_date")
	private Date createdDate;
    /**
     * 修改时间
     */
	@TableField("last_updated_date")
	private Date lastUpdatedDate;
	
	private UserAddressDetail userAddressDetail;
	
	private WKProduct wkProduct;
	
	private WKProductInfo wkProductInfo;


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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	
	

	public UserAddressDetail getUserAddressDetail() {
		return userAddressDetail;
	}

	public void setUserAddressDetail(UserAddressDetail userAddressDetail) {
		this.userAddressDetail = userAddressDetail;
	}

	public WKProduct getWkProduct() {
		return wkProduct;
	}

	public void setWkProduct(WKProduct wkProduct) {
		this.wkProduct = wkProduct;
	}

	public WKProductInfo getWkProductInfo() {
		return wkProductInfo;
	}

	public void setWkProductInfo(WKProductInfo wkProductInfo) {
		this.wkProductInfo = wkProductInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "WbUserOrderDetail [id=" + id + ", orderNo=" + orderNo + ", weChatId=" + weChatId + ", productId="
				+ productId + ", orderMoney=" + orderMoney + ", orderNum=" + orderNum + ", orderStatus=" + orderStatus
				+ ", isEnable=" + isEnable + ", createdDate=" + createdDate + ", lastUpdatedDate=" + lastUpdatedDate
				+ ", userAddressDetail=" + userAddressDetail + ", wkProduct=" + wkProduct + ", wkProductInfo="
				+ wkProductInfo + "]";
	}
}
