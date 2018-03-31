package com.yxx.amazing.dao;

import java.util.List;
import java.util.Map;

import com.yxx.amazing.domain.User;

public interface UserMapper{
	
	// 显示所有用户(可以进行多条件查询)
	List<User> listAllUserByMap(Map<String,Object> map);
	
	// 根据id删除用户
	int deleteUserById(Integer id);
	
	// 添加用户
	void saveUser(User user);
	
	// 更新用户
	void updateUser(User user);
	
	// 通过id获取用户
	User getUserById(Integer id);
	
	// 通过用户名获取用户
	User getUserByUserName(String userName);
	
	int deleteBatch(List<Integer>  ids);
}
