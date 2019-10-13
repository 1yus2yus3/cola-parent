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
@TableName("m_user_role")
public class MUserRoleEntity extends Model<MUserRoleEntity> {

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
	* 用户ID
	*/

	private java.lang.Long userId;

	public MUserRoleEntity() {
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
	
	public java.lang.Long getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "MUserRoleDO{" +
			"id=" + id +
			",roleId=" + roleId +
			",userId=" + userId +
		'}';
	}

    @Override
    protected Serializable pkVal() {
    	return this.id;
    }
}
