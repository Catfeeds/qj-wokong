package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;


@TableName("wk_product")
public class WKProduct extends Model<WbUserOrderDetail>{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected Serializable pkVal() {
		return null;
	}
	
	@TableId(value="product_id", type= IdType.AUTO)
	private Integer productId;
	
	@TableField("product_name")
	private String productName;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "WKProduct [productId=" + productId + ", productName=" + productName + "]";
	}
	
	

}
