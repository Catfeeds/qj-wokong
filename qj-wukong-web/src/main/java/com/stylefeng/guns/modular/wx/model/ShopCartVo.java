package com.stylefeng.guns.modular.wx.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 订单表
 * @author wuhuigui
 *
 */
@TableName("wb_user_order_detail")
public class ShopCartVo extends Model<ShopCartVo> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 订单号
     */
	@TableField("order_no")
	private String orderNo;
	/**
	 * 微信id
	 */
	@NotBlank
	@TableField("we_chat_id")
	private String weChatId;       
	/**
	 * 商品id
	 */
	@NotBlank
	@TableField("product_id")
	private String productId;       
	/**
	 * 订单价格
	 */
	@TableField("order_money")
	private String orderMoney;
	/**
	 * 数量
	 */
	@NotBlank
	@TableField("order_num")
	private String orderNum;
	/**
	 * 订单状态
	 */
	@TableField("order_status")
	private String orderStatus;
	/**
	 * 是否可用
	 */
	@NotBlank
	@TableField("is_enable")
	private String isEnable="Y";        
	/**
	 * 创建人ID
	 */
	@TableField("created_by")
	private String createdBy;      
	/**
	 * 创建时间
	 */
	@TableField("created_date")
	private String createdDate;     
	/**
	 * 最后更新人ID
	 */
	@TableField("last_updated_by")
	private String lastUpdatedBy;
	/**
	 * 修改时间
	 */
	@TableField("last_updated_date")
	private String lastUpdatedDate;
	/**
	 * 数据状态0:已删除,1正常
	 */
	@NotBlank
	@TableField("data_status")
	private String dataStatus="1";
	/**
	 * 地址ID
	 */
	@TableField("address_id")
	private String addressId;
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getWeChatId() {
		return weChatId;
	}

	public void setWeChatId(String weChatId) {
		this.weChatId = weChatId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(String orderMoney) {
		this.orderMoney = orderMoney;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}       
	

}
