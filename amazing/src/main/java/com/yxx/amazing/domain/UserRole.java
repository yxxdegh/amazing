package com.yxx.amazing.domain;

public class UserRole {
	
	private int userId;
	
	private int roleId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public UserRole(int userId, int roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}
	public UserRole() {
	}
	@Override
	public String toString() {
		return "UserRole [userId=" + userId + ", roleId=" + roleId + "]";
	}
	
	
}
