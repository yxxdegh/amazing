package com.yxx.amazing.service;

import java.util.List;
import java.util.Set;

import com.yxx.amazing.domain.Role;

public interface RoleService { 
	
		
	  	// 获取所有角色
		List<Role> listAllRole();
		// 根据用户Id获取所有角色(在realm中使用这个方法)
		Set<String> getRoleByUserId(Integer id);
		
}
