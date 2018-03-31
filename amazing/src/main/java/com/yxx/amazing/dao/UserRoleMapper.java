/**  
* Title: UserRoleMapper.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年3月8日  
* @version 1.0  
*/  
package com.yxx.amazing.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yxx.amazing.common.bo.RoleBo;
import com.yxx.amazing.common.bo.UserRoleBo;
import com.yxx.amazing.domain.Role;
import com.yxx.amazing.domain.UserRole;

/**  
* Title: UserRoleMapper  
* Description:  
* @author yuanxx  
* @date 2018年3月8日  
*/
public interface UserRoleMapper {

	// 通过用户id获取用户的角色（返回RoleBo可以展示复选框）
	List<RoleBo> getRolesByUserId(Integer id);
	
	// 获取所有用户和对应的角色
	List<UserRoleBo> listAllUserRoleByMap(Map<String,Object> map);
	
	// 根据用户id删除tbl_user_role中的记录
	int deleteByUserId(Integer userId);
	
	// 增加用户和角色的关联关系
	int saveUserRole(UserRole userRole);
	
}
