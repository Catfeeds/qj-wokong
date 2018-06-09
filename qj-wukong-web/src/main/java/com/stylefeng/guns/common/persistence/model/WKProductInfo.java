package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("wk_product_info")
public class WKProductInfo extends Model<WbUserOrderDetail>{

	private static final long serialVersionUID = 1L;

	@Override
	protected Serializable pkVal() {
		return null;
	}
	
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	
	@TableField("colour")
	private String colour;
	
	@TableField("dimens")
	private String dimens;

	public String getColour() {
		return colour;
	}
	
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getDimens() {
		return dimens;
	}

	public void setDimens(String dimens) {
		this.dimens = dimens;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "WKProductInfo [id=" + id + ", colour=" + colour + ", dimens=" + dimens + "]";
	}
	
	
}
