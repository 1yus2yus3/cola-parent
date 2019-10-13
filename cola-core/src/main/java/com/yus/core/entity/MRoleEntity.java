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
@TableName("m_role")
public class MRoleEntity extends Model<MRoleEntity> {

	/**
	* 主键ID
	*/
	@TableId(type = IdType.AUTO)

	private java.lang.Long id;
	/**
	* 角色名称
	*/

	private java.lang.String roleName;
	/**
	* 角色类型
	*/

	private java.lang.Byte roleType;
	/**
	* 备注
	*/

	private java.lang.String remark;
	/**
	* 创建人ID
	*/

	private java.lang.Long creatorId;
	/**
	* 创建人
	*/

	private java.lang.String creator;
	/**
	* 创建时间
	*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")

	private java.util.Date createDate;
	/**
	* 修改人ID
	*/

	private java.lang.Long modifierId;
	/**
	* 修改人
	*/

	private java.lang.String modifier;
	/**
	* 修改时间
	*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")

	private java.util.Date modifyDate;
	/**
	* 是否有效 0,删除 1,正常
	*/

	private java.lang.Byte isValid;

	public MRoleEntity() {
	}

	
	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public java.lang.String getRoleName() {
		return roleName;
	}

	public void setRoleName(java.lang.String roleName) {
		this.roleName = roleName;
	}
	
	public java.lang.Byte getRoleType() {
		return roleType;
	}

	public void setRoleType(java.lang.Byte roleType) {
		this.roleType = roleType;
	}
	
	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
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
	
	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
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
	
	public java.util.Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(java.util.Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public java.lang.Byte getIsValid() {
		return isValid;
	}

	public void setIsValid(java.lang.Byte isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "MRoleDO{" +
			"id=" + id +
			",roleName=" + roleName +
			",roleType=" + roleType +
			",remark=" + remark +
			",creatorId=" + creatorId +
			",creator=" + creator +
			",createDate=" + createDate +
			",modifierId=" + modifierId +
			",modifier=" + modifier +
			",modifyDate=" + modifyDate +
			",isValid=" + isValid +
		'}';
	}

    @Override
    protected Serializable pkVal() {
    	return this.id;
    }
}
