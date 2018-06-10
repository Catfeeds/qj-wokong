package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("wk_user_address")
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
	
	@TableField("user_name")
	private String userName;
	
	
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
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserAddressDetail [id=" + id + ", address=" + address + ", phoneNo=" + phoneNo + ", userName="
				+ userName + "]";
	}
	
	

}
