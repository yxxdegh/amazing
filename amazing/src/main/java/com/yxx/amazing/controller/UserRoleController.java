/**  
* Title: UserRoleController.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年3月10日  
* @version 1.0  
*/  
package com.yxx.amazing.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxx.amazing.common.bo.RoleBo;
import com.yxx.amazing.common.bo.UserRoleBo;
import com.yxx.amazing.domain.Role;
import com.yxx.amazing.domain.User;
import com.yxx.amazing.domain.UserRole;
import com.yxx.amazing.service.UserRoleService;

/**  
* Title: UserRoleController  
* Description:  
* @author yuanxx  
* @date 2018年3月10日  
*/
@Controller
@RequestMapping(value="/pages/role")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;
	
	/**
	 * 
	 * Title: listAllUserRole  
	 * Description:  展示所有的用户，并且展示用户所拥有的角色
	 * @param pageSize
	 * @param currentPage
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/listAllUserRole.do",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> listAllUserRole(int pageSize,int currentPage,User user){
		// 定义封装返回结果的map
		Map<String,Object> resultMap=new HashMap<String,Object>();
		// 定义查询结果的list
		List<UserRoleBo> userRoleList=new ArrayList<UserRoleBo>();
		// 定义封装查询参数的map
		Map<String,Object> map=new HashMap<String,Object>();
			String userName = user.getUserName();
			if (null != userName && "" != userName) {
				map.put("userName", userName);	
			}
		try {
			// 分页插件传入当前第几页currentPage和每页显示多少条pageSize
			PageHelper.startPage(currentPage,pageSize);
			userRoleList=userRoleService.listAllUserRoleByMap(map);
			// 通过PageInfo对象获取分页的各项信息
			PageInfo<UserRoleBo> info=new PageInfo<>(userRoleList);
			Long totalCount= info.getTotal(); // 获取总条数
			resultMap.put("data", userRoleList);
			resultMap.put("count", totalCount);// 总条数
			resultMap.put("msg", "1");
			resultMap.put("code", 0);
		} catch (Exception e) {
			resultMap.put("msg", "-100");
			e.printStackTrace();
		}
			return resultMap;
	}
	
	/**
	 * 
	 * Title: getRolesByUserId 
	 * Description:  根据用户id获取该用户所拥有的角色
	 * @param id
	 * @return
	 */
	@RequestMapping(value="getRolesByUserId.do")
	@ResponseBody
	public List<RoleBo> getRolesByUserId(Integer id){
		return userRoleService.getRolesByUserId(id);
	}
	
	/**
	 * 
	 * Title: saveRoleToUser  
	 * Description:操作用户的角色，把勾选的角色保存到相应的用户
	 */
	@RequestMapping(value="saveRoleToUser.do")
	@ResponseBody
	public  Map<String,Object> saveRoleToUser(@RequestBody String param){
		return userRoleService.addRoleToUser(param);
	}
	
	
}
