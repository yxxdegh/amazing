/**  
* Title: MenuServiceImpl.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年3月26日  
* @version 1.0  
*/  
package com.yxx.amazing.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxx.amazing.common.bo.LeftMenuBo;
import com.yxx.amazing.dao.PermissionMapper;
import com.yxx.amazing.dao.RoleMapper;
import com.yxx.amazing.domain.Permission;
import com.yxx.amazing.domain.Role;
import com.yxx.amazing.domain.User;
import com.yxx.amazing.service.MenuService;

/**  
* Title: MenuServiceImpl  
* Description:  
* @author yuanxx  
* @date 2018年3月26日  
*/
@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public Map<String, Object> getTopMenuByUserId() {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		try {
			List<Permission> resultList = permissionMapper.listTopMenuByUserId(user.getId());
			resultMap.put("topMenu", resultList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}	
	
	
	@Override
	public Map<String, Object> getLeftMenu(Integer topMenuId) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		// 得到当前登录的用户
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		// 得到当前用户的roleId
		List<Role> roles = roleMapper.listRoleByUserId(user.getId());
		List<Integer> roleIds = new ArrayList<>();
		for (Role Role : roles) {
			roleIds.add(Role.getId());
		}
		System.out.println(roleIds);
		// 得到顶级菜单下的二级菜单 
		List<LeftMenuBo> listLeftMenuBo = permissionMapper.listLeftMenu(topMenuId,roleIds);
		// 得到三级菜单
		for (LeftMenuBo leftMenuBo : listLeftMenuBo) {
			List<LeftMenuBo> listChild = permissionMapper.listChild(leftMenuBo.getId());
			leftMenuBo.setChildren(listChild);
		}
	    resultMap.put("leftMenu", listLeftMenuBo);
		return resultMap;
	}
	
	
}
