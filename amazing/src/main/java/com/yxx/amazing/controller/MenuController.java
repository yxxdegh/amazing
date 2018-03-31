/**  
* Title: MenuController.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年3月26日  
* @version 1.0  
*/  
package com.yxx.amazing.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxx.amazing.service.MenuService;

/**  
* Title: MenuController  
* Description:  登录后用户菜单相关的Controller
* @author yuanxx  
* @date 2018年3月26日  
*/
@Controller
@RequestMapping(value="/pages")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * 
	 * Title: getTopMenu  
	 * Description:  根据当前登录用户的id获取顶级菜单
	 * @return
	 */
	@RequestMapping(value="getTopMenu.do")
	@ResponseBody
	public Map<String,Object> getTopMenu(){
		return menuService.getTopMenuByUserId();
	}
	
	
	/**
	 * 
	 * Title: getLeftMenu  
	 * Description: 获得当前用户顶级菜单下的子菜单
	 * @return
	 */
	@RequestMapping(value="getLeftMenu.do")
	@ResponseBody
	public Map<String,Object> getLeftMenu(Integer topMenuId){
		return menuService.getLeftMenu(topMenuId);
	}
}
