package com.yxx.amazing.core.shiro.token;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.yxx.amazing.domain.User;
import com.yxx.amazing.service.PermissionService;
import com.yxx.amazing.service.RoleService;
import com.yxx.amazing.service.UserService;


public class SampleRealm extends AuthorizingRealm {

	@Autowired
	UserService userService;
	@Autowired
	PermissionService permissionService;
	@Autowired
	RoleService roleService;
	/**
	 *  认证信息，主要针对用户登录
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String userName = token.getUsername();
		// 通过前台传过来的userName从数据库获取User
		User user =	userService.getUserByUserName(userName); 
		if (null == user) {
			throw new AccountException("帐号或密码不正确！");
		}else{
			// 更新登录时间 LastloginTime
			User u=new User();
			u.setId(user.getId());
			u.setLastLoginTime(new Date());
			userService.updateUser(u);
			// 获取数据库中MD5密码
			String hashedCredentials=user.getPassword();
			String realmName=getName();
			// 获取加密时的盐
			ByteSource credentialsSalt=ByteSource.Util.bytes(userName);
			SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(user, hashedCredentials, credentialsSalt, realmName);
			return simpleAuthenticationInfo;
		}
    }
	
	 /** 
     * 授权 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	String userName=(String)principals.getPrimaryPrincipal();
    	User user=userService.getUserByUserName(userName);
    	SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
		//根据用户ID查询角色（role），放入到Authorization里。因为SimpleAuthorizationInfo的setRoles只能接收set<String>
		Set<String> roles=roleService.getRoleByUserId(user.getId());
		info.setRoles(roles);
		//根据用户ID查询权限（permission），放入到Authorization里。
		Set<String> permissions = permissionService.getPermissionByUserId(user.getId());
		info.setStringPermissions(permissions);
		return info;
    }  
   
 
}
