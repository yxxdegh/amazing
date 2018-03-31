package com.yxx.amazing.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxx.amazing.domain.Role;
import com.yxx.amazing.service.RoleService;

@Controller
@RequestMapping(value="/pages/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/listAllRole.do" ,method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> listAllRole(int pageSize,int currentPage){
		Map<String,Object> resultMap=new HashMap<String,Object>();
		List<Role> roleList=new ArrayList<Role>();
		try{
			// 分页插件传入当前第几页currentPage和每页显示多少条pageSize
			PageHelper.startPage(currentPage,pageSize);
			roleList=roleService.listAllRole();
			PageInfo<Role> info=new PageInfo<>(roleList);
			Long totalCount= info.getTotal();
			int totalPage=info.getPages();
			int	currentPage2=info.getPageNum();
			resultMap.put("data", roleList);
			resultMap.put("count", totalCount);// 总条数
			resultMap.put("msg", "1");
			resultMap.put("code", 0);
		}catch (Exception e) {
			resultMap.put("msg", "-100");
			e.printStackTrace();
		}
		return resultMap;
	}
	
}
