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
@TableName("m_role_permission")
public class MRolePermissionEntity extends Model<MRolePermissionEntity> {

	/**
	* 主键ID
	*/
	@TableId(type = IdType.AUTO)

	private java.lang.Long id;
	/**
	* 角色ID
	*/

	private java.lang.Long roleId;
	/**
	* 权限ID
	*/

	private java.lang.Long permissionId;

	public MRolePermissionEntity() {
	}

	
	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public java.lang.Long getRoleId() {
		return roleId;
	}

	public void setRoleId(java.lang.Long roleId) {
		this.roleId = roleId;
	}
	
	public java.lang.Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(java.lang.Long permissionId) {
		this.permissionId = permissionId;
	}

	@Override
	public String toString() {
		return "MRolePermissionDO{" +
			"id=" + id +
			",roleId=" + roleId +
			",permissionId=" + permissionId +
		'}';
	}

    @Override
    protected Serializable pkVal() {
    	return this.id;
    }
}
