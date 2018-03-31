/**  
* Title: PermissionService.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年3月22日  
* @version 1.0  
*/  
package com.yxx.amazing.service;

import java.util.Set;


/**  
* Title: PermissionService  
* Description:  
* @author yuanxx  
* @date 2018年3月22日  
*/
public interface PermissionService {

	
	/**  
	 * Title: listPermissionByUserId  
	 * Description:  根据用户id获取当前用户的权限列表   shiro 只能放Set类型的权限集合
	 * @param id  
	 */  
	Set<String> getPermissionByUserId(Integer userId);
	
	

	
	

}
