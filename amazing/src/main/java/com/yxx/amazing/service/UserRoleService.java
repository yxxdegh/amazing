/**  
* Title: UserRoleService.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年3月10日  
* @version 1.0  
*/  
package com.yxx.amazing.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yxx.amazing.common.bo.RoleBo;
import com.yxx.amazing.common.bo.UserRoleBo;
import com.yxx.amazing.domain.Role;

/**  
* Title: UserRoleService  
* Description:  
* @author yuanxx  
* @date 2018年3月10日  
*/
public interface UserRoleService {
			// 通过用户id获取用户的角色
			List<RoleBo> getRolesByUserId(Integer id);
			
			// 获取所有用户和对应的角色
			List<UserRoleBo> listAllUserRoleByMap(Map<String,Object> map);
			
			// 添加用户和角色表数据。param:{ids:[],userId:userId}
			Map<String, Object> addRoleToUser(String param);
			
}
