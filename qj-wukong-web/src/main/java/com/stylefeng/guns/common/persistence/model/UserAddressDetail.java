package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("wb_user_address_detail")
public class UserAddressDetail extends Model<WbUserOrderDetail>{

	private static final long serialVersionUID = 1L;

	@Override
	protected Serializable pkVal() {
		return null;
	}
	
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	
	@TableField("address")
	private String address;
	
	@TableField("phone_no")
	private String phoneNo;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserAddressDetail [id=" + id + ", address=" + address + ", phoneNo=" + phoneNo + "]";
	}
	
	

}
