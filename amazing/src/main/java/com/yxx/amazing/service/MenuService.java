/**  
* Title: MenuService.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年3月26日  
* @version 1.0  
*/  
package com.yxx.amazing.service;

import java.util.Map;

/**  
* Title: MenuService  
* Description:  
* @author yuanxx  
* @date 2018年3月26日  
*/
public interface MenuService {
	/**  
	 * Title: getTopMenu  
	 * Description:  根据当前登录用户的id获取顶级菜单
	 * @return  
	 */  
	Map<String, Object> getTopMenuByUserId();
	
	/**
	 *   
	 * Title: getLeftMenu  
	 * Description:  通过顶级菜单获取对应的子菜单
	 * @param topMenuId 顶级菜单的id
	 * @return
	 */
	Map<String, Object> getLeftMenu(Integer topMenuId);
}
