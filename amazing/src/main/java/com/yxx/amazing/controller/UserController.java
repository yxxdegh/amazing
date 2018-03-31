 package com.yxx.amazing.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxx.amazing.domain.User;
import com.yxx.amazing.service.UserService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping(value="/pages/user")
public class UserController {
	
		@Autowired
		private UserService userService;
			
		@RequestMapping(value="/listAllUser.do" , method = RequestMethod.POST)
		@ResponseBody
		public Map<String,Object> listAllUser(int pageSize,int currentPage,User user,String startTime,String endTime){
			// 定义封装返回结果的map
			Map<String,Object> resultMap=new HashMap<String,Object>();
			// 定义查询结果的list
			List<User> userList=new ArrayList<User>();
			// 定义封装查询参数的map
			Map<String,Object> map=new HashMap<String,Object>();
				Integer id = user.getId();
				String userName = user.getUserName();
			if (null != startTime && "" != startTime) {
				map.put("startTime", startTime);
			}if (null != endTime && "" != endTime) {
				map.put("endTime", endTime);
			}if (null != id ) {
				map.put("id", id);
			}if (null != userName && "" != userName) {
				map.put("userName", userName);	
			}
			try {
				// 分页插件传入当前第几页currentPage和每页显示多少条pageSize
				PageHelper.startPage(currentPage,pageSize);
				userList=userService.listAllUserByMap(map);
				// 通过PageInfo对象获取分页的各项信息
				PageInfo<User> info=new PageInfo<>(userList);
				Long totalCount= info.getTotal(); // 获取总条数
				// int totalPage=info.getPages(); // 总页数
				// int	currentPage2=info.getPageNum();// 当前页
				resultMap.put("data", userList);
				resultMap.put("count", totalCount);// 总条数
				resultMap.put("msg", "1");
				resultMap.put("code", 0);
			} catch (Exception e) {
				resultMap.put("msg", "-100");
				e.printStackTrace();
			}
				return resultMap;
		}
		
		@RequestMapping(value="/deleteUserByIds.do",method = RequestMethod.POST)
		@ResponseBody
		public Map<String,Object> deleteUserByIds(@RequestBody String ids){
			Map<String,Object> resultMap = new HashMap<String,Object>();
			try {
				int successCount = 0;
				if (ids == null || "".equals(ids)) {
					resultMap.put("msg", "-1");
					return resultMap;
				}
				 JSONArray jSONArray = JSONArray.fromObject(ids);  
				 for(int i=0; i<jSONArray.size(); i++){
					int id = jSONArray.getInt(i);
					successCount += userService.deleteUserById(id);
				 }
					resultMap.put("msg", "1");
					resultMap.put("successCount", successCount);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return resultMap;
		}
		
		@RequestMapping(value="/saveUser.do",method=RequestMethod.POST)
		@ResponseBody
		public Map<String,Object> saveUser(User user){
			Map<String,Object> resultMap=new HashMap<String,Object>();
			try {
				String password = new SimpleHash("MD5",user.getPassword(),user.getUserName(),1024).toString();
				user.setPassword(password);
				Date date = new Date();// Mon Feb 26 14:49:55 CST 2018
				user.setCreateTime(date);
				user.setLastLoginTime(date);
				user.setStatus(User._1);
				userService.saveUser(user);
				resultMap.put("msg", "1");
			} catch (Exception e) {
				e.printStackTrace();
				resultMap.put("msg", "-1");
			}
			return resultMap;
		}
		
		@RequestMapping(value="/updateUser.do",method=RequestMethod.POST)
		@ResponseBody
		public Map<String,Object> updateUser(User user){
			Map<String,Object> resultMap=new HashMap<String,Object>();
			try {
				userService.updateUser(user);
				resultMap.put("msg", "1");
			} catch (Exception e) {
				e.printStackTrace();
				resultMap.put("msg", "-1");
			}
			return resultMap;
		}
		
		@RequestMapping(value="/getUserById.do",method=RequestMethod.POST)
		@ResponseBody
		public Map<String,Object> getUserById(String id){
			Map<String,Object> resultMap=new HashMap<String,Object>();
			try {
				Integer IntegerId=new Integer(id);
				User user = userService.getUserById(IntegerId);
				if (null != user) {
					resultMap.put("user", user);
					resultMap.put("msg", "1");
				}
			} catch (Exception e) {
				resultMap.put("msg", "-1");
				e.printStackTrace();
			}
			return resultMap;
		}
		
		/*@RequestMapping(value="/listMenu.do",method=RequestMethod.POST)
		@ResponseBody
		public Map<String,Object> getMenu(){
			List<Menu> menuList=new ArrayList<Menu>();
			return resultMap;
		}*/
}
