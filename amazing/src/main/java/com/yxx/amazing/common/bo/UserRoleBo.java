/**  
* Title: UserRoleBo.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年3月10日  
* @version 1.0  
*/  
package com.yxx.amazing.common.bo;

import java.io.Serializable;

import com.yxx.amazing.domain.User;

/**  
* Title: UserRoleBo  
* Description:  
* @author yuanxx  
* @date 2018年3月10日  
*/
public class UserRoleBo extends User implements Serializable{
	private static final long serialVersionUID = 1L;
		//Role Name列转行，以,分割
		private String roleNames;
		//Role Id列转行，以‘,’分割
		private String roleIds;
		public String getRoleNames() {
			return roleNames;
		}
		public void setRoleNames(String roleNames) {
			this.roleNames = roleNames;
		}
		public String getRoleIds() {
			return roleIds;
		}
		public void setRoleIds(String roleIds) {
			this.roleIds = roleIds;
		}

	
}
