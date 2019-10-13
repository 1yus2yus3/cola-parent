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
@TableName("m_permission")
public class MPermissionEntity extends Model<MPermissionEntity> {

	/**
	* 主键ID
	*/
	@TableId(type = IdType.AUTO)

	private java.lang.Long id;
	/**
	* 权限名称
	*/

	private java.lang.String permissionName;
	/**
	* 权限类型
	*/

	private java.lang.Byte permissionType;
	/**
	* 权限体系
	*/

	private java.lang.String permissionSystem;
	/**
	* 上级权限ID
	*/

	private java.lang.Long fatherId;
	/**
	* 权限路径
	*/

	private java.lang.String permissionPath;
	/**
	* 权限排序
	*/

	private java.lang.Integer sort;
	/**
	* 权限图标
	*/

	private java.lang.String permissionImg;
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

	public MPermissionEntity() {
	}

	
	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public java.lang.String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(java.lang.String permissionName) {
		this.permissionName = permissionName;
	}
	
	public java.lang.Byte getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(java.lang.Byte permissionType) {
		this.permissionType = permissionType;
	}
	
	public java.lang.String getPermissionSystem() {
		return permissionSystem;
	}

	public void setPermissionSystem(java.lang.String permissionSystem) {
		this.permissionSystem = permissionSystem;
	}
	
	public java.lang.Long getFatherId() {
		return fatherId;
	}

	public void setFatherId(java.lang.Long fatherId) {
		this.fatherId = fatherId;
	}
	
	public java.lang.String getPermissionPath() {
		return permissionPath;
	}

	public void setPermissionPath(java.lang.String permissionPath) {
		this.permissionPath = permissionPath;
	}
	
	public java.lang.Integer getSort() {
		return sort;
	}

	public void setSort(java.lang.Integer sort) {
		this.sort = sort;
	}
	
	public java.lang.String getPermissionImg() {
		return permissionImg;
	}

	public void setPermissionImg(java.lang.String permissionImg) {
		this.permissionImg = permissionImg;
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
		return "MPermissionDO{" +
			"id=" + id +
			",permissionName=" + permissionName +
			",permissionType=" + permissionType +
			",permissionSystem=" + permissionSystem +
			",fatherId=" + fatherId +
			",permissionPath=" + permissionPath +
			",sort=" + sort +
			",permissionImg=" + permissionImg +
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
