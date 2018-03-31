package com.yxx.amazing.controller;

import java.util.HashMap;
import java.util.Map;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxx.amazing.domain.User;


/**  
* Title: LoginController  
* Description:  
* @author yuanxx  
* @date 2018年2月6日  
*/  
@Controller
public class LoginController {

	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> login(User user){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassword());
		try {
			subject.login(token);
			resultMap.put("msg", "1");
			String url = "pages/index.jsp";
			resultMap.put("url", url);
		} catch (Exception e) {
			e.printStackTrace();
			token.clear();
		}
		return resultMap;
	}
	
	/**
	 * 退出
	 */
	/*@RequestMapping(value="/pages/logout.do",method =RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> logout(){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		try {
			SecurityUtils.getSubject().logout();
			resultMap.put("msg", 1);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("msg", "退出失败，请重试");
		}
		return resultMap;
	}*/
	
	@RequestMapping(value="/pages/logout.do",method =RequestMethod.GET)
	public String logout(){
		SecurityUtils.getSubject().logout();
		return "redirect:/login.jsp";
	}
}
