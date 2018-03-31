/**  
* Title: PermissionServiceImpl.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年3月22日  
* @version 1.0  
*/  
package com.yxx.amazing.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxx.amazing.dao.PermissionMapper;
import com.yxx.amazing.service.PermissionService;

/**  
* Title: PermissionServiceImpl  
* Description:  
* @author yuanxx  
* @date 2018年3月22日  
*/
@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public Set<String> getPermissionByUserId(Integer userId) {
		return permissionMapper.getPermissionByUserId(userId);
	}

	

	

	
	
	
}
