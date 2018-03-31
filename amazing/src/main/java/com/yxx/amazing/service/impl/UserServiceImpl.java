package com.yxx.amazing.service.impl;



import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxx.amazing.dao.UserMapper;
import com.yxx.amazing.domain.User;
import com.yxx.amazing.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserByUserName(String userName) {
		return userMapper.getUserByUserName(userName);
	}

	

	@Override
	public Set<String> getRoles(String loginName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getPermissions(String loginName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUserById(Integer id) {
		return userMapper.deleteUserById(id);
	}

	@Override
	public void saveUser(User user) {
		userMapper.saveUser(user);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Override
	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

	@Override
	public List<User> listAllUserByMap(Map<String, Object> map) {
		return userMapper.listAllUserByMap(map);
	}





	

	
	



}
