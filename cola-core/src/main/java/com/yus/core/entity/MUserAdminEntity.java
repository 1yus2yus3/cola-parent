package com.yus.core.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;

import java.io.Serializable;

/**
* Copyright (C),
* @author: CodeGenerator
* @date: 2019/10/13 23:27
* @description:
*/
@TableName("m_user_admin")
public class MUserAdminEntity extends Model<MUserAdminEntity> {

	/**
	* 主键ID
	*/
	@TableId(type = IdType.AUTO)

	private java.lang.Long id;
	/**
	* 用户名
	*/

	private java.lang.String userName;
	/**
	* 真实姓名
	*/

	private java.lang.String realName;
	/**
	* 登陆密码
	*/

	private java.lang.String password;
	/**
	* 
	*/

	private java.lang.String staffCode;
	/**
	* 手机号
	*/

	private java.lang.String phone;
	/**
	* 地址
	*/

	private java.lang.String address;
	/**
	* 入职时间
	*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")

	private java.util.Date entryDate;
	/**
	* 离职时间
	*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")

	private java.util.Date quitDate;
	/**
	* 创建时间
	*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")

	private java.util.Date createDate;
	/**
	* 修改时间
	*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")

	private java.util.Date modifyDate;
	/**
	* 用户状态
	*/

	private java.lang.Byte userStatus;
	/**
	* 是否有效 0,删除 1,正常
	*/

	private java.lang.Byte isValid;
	/**
	* 创建人ID
	*/

	private java.lang.Long creatorId;
	/**
	* 创建人
	*/

	private java.lang.String creator;
	/**
	* 修改人ID
	*/

	private java.lang.Long modifierId;
	/**
	* 修改人
	*/

	private java.lang.String modifier;

	public MUserAdminEntity() {
	}

	
	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}
	
	public java.lang.String getRealName() {
		return realName;
	}

	public void setRealName(java.lang.String realName) {
		this.realName = realName;
	}
	
	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}
	
	public java.lang.String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(java.lang.String staffCode) {
		this.staffCode = staffCode;
	}
	
	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}
	
	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	
	public java.util.Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(java.util.Date entryDate) {
		this.entryDate = entryDate;
	}
	
	public java.util.Date getQuitDate() {
		return quitDate;
	}

	public void setQuitDate(java.util.Date quitDate) {
		this.quitDate = quitDate;
	}
	
	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	
	public java.util.Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(java.util.Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public java.lang.Byte getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(java.lang.Byte userStatus) {
		this.userStatus = userStatus;
	}
	
	public java.lang.Byte getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Byte isValid) {
		this.isValid = isValid;
	}
	
	public java.lang.Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(java.lang.Long creatorId) {
		this.creatorId = creatorId;
	}
	
	public java.lang.String getCreator() {
		return creator;
	}

	public void setCreator(java.lang.String creator) {
		this.creator = creator;
	}
	
	public java.lang.Long getModifierId() {
		return modifierId;
	}

	public void setModifierId(java.lang.Long modifierId) {
		this.modifierId = modifierId;
	}
	
	public java.lang.String getModifier() {
		return modifier;
	}

	public void setModifier(java.lang.String modifier) {
		this.modifier = modifier;
	}

	@Override
	public String toString() {
		return "MUserAdminDO{" +
			"id=" + id +
			",userName=" + userName +
			",realName=" + realName +
			",password=" + password +
			",staffCode=" + staffCode +
			",phone=" + phone +
			",address=" + address +
			",entryDate=" + entryDate +
			",quitDate=" + quitDate +
			",createDate=" + createDate +
			",modifyDate=" + modifyDate +
			",userStatus=" + userStatus +
			",isValid=" + isValid +
			",creatorId=" + creatorId +
			",creator=" + creator +
			",modifierId=" + modifierId +
			",modifier=" + modifier +
		'}';
	}

    @Override
    protected Serializable pkVal() {
    	return this.id;
    }
}
