package com.yxx.amazing.dao;

import java.util.List;
import java.util.Set;

import com.yxx.amazing.domain.Role;

public interface RoleMapper {
	// 获取所有角色
	List<Role> listAllRole();
	
	// 通过用户id获取用户的角色(在realm中调用这个方法，必须返回set)
	Set<String> getRoleByUserId(Integer id);
	
	//  通过用户id获取用户的角色
	List<Role> listRoleByUserId(Integer userId);
}
