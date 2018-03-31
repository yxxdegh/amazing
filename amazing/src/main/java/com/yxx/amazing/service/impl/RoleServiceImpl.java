package com.yxx.amazing.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxx.amazing.dao.RoleMapper;
import com.yxx.amazing.domain.Role;
import com.yxx.amazing.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> listAllRole() {
		return roleMapper.listAllRole();
	}

	@Override
	public Set<String> getRoleByUserId(Integer id) {
		return roleMapper.getRoleByUserId(id);
	}

	

}
