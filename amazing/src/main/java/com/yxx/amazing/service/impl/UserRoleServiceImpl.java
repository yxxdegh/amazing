/**  
* Title: UserRoleServiceimpl.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年3月10日  
* @version 1.0  
*/  
package com.yxx.amazing.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxx.amazing.common.bo.RoleBo;
import com.yxx.amazing.common.bo.UserRoleBo;
import com.yxx.amazing.dao.UserRoleMapper;
import com.yxx.amazing.domain.Role;
import com.yxx.amazing.domain.UserRole;
import com.yxx.amazing.service.UserRoleService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**  
* Title: UserRoleServiceimpl  
* Description:  
* @author yuanxx  
* @date 2018年3月10日  
*/
@Service
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	
	@Override
	public List<RoleBo> getRolesByUserId(Integer id) {
		return userRoleMapper.getRolesByUserId(id);
	}

	@Override
	public List<UserRoleBo> listAllUserRoleByMap(Map<String, Object> map) {
		return userRoleMapper.listAllUserRoleByMap(map);
	}



	
	@Override
	public Map<String, Object> addRoleToUser(String param) {
		// 定义封装返回结果的map
		Map<String,Object> resultMap = new HashMap<String, Object>();
		// 解析前台传过来的参数
		JSONObject jsonObject = JSONObject.fromObject(param);
		Integer userId = jsonObject.getInt("userId");
		List<String> listRoleId = (List<String>) JSONArray.toCollection(jsonObject.getJSONArray("ids"));
		try {
			// 先删除原有的
			userRoleMapper.deleteByUserId(userId);
			if (null != listRoleId && listRoleId.size() != 0) {
				for (String roleId : listRoleId) {
					userRoleMapper.saveUserRole(new UserRole(userId,Integer.parseInt(roleId)));
				}
			}
			resultMap.put("msg", "1");
		} catch (Exception e) {
			resultMap.put("msg", "-1");
			e.printStackTrace();
		}
		//清空用户的权限，迫使再次获取权限的时候，得重新加载  暂时未实现
		return resultMap;
	}

}
