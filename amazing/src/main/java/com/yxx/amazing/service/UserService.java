package com.yxx.amazing.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yxx.amazing.domain.User;

public interface UserService { 
		// 通过用户名获取用户
		User getUserByUserName(String userName);
	 
		Set<String> getRoles(String loginName);

		Set<String> getPermissions(String loginName);
		
		//User login(String loginName,String password);
		// 根据Id 删除用户
		int deleteUserById(Integer id);
		
		// 添加用户
		void saveUser(User user);
		
		//更新用户
		void updateUser(User user);
		
		// 通过id获取用户
		User getUserById(Integer id);

		
		// 显示所有用户(可以进行多条件查询)
		List<User> listAllUserByMap(Map<String,Object> map);
}
