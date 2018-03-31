/**  
* Title: PermissionMapper.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年3月21日  
* @version 1.0  
*/  
package com.yxx.amazing.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.yxx.amazing.common.bo.LeftMenuBo;
import com.yxx.amazing.domain.Permission;


/**  
* Title: PermissionMapper  
* Description:  
* @author yuanxx  
* @date 2018年3月21日  
*/
public interface PermissionMapper {
	
	// 根据用户id获取顶级菜单
	List<Permission> listTopMenuByUserId(Integer userId);
	
	// 根据顶级菜单的id和当前用户拥有的角色id获取子菜单
	List<LeftMenuBo> listLeftMenu(@Param("topMenuId") Integer topMenuId,@Param("roleIds") List<Integer> roleIds);
	
	// 根据一级子菜单id获取二级菜单
	List<LeftMenuBo> listChild(Integer id);
	
	List<Permission> listPermissionsByUserId(Integer userId);
	// shiro需要的权限列表
	Set<String> getPermissionByUserId(Integer userId);
	
	

}
