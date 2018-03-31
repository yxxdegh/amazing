/**  
* Title: RoleBo.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年3月12日  
* @version 1.0  
*/  
package com.yxx.amazing.common.bo;

import java.io.Serializable;

import com.yxx.amazing.common.util.StringUtils;
import com.yxx.amazing.domain.Role;

/**  
* Title: RoleBo  
* Description:  
* @author yuanxx  
* @date 2018年3月12日  
*/
public class RoleBo extends Role implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 用户ID (用String， 考虑多个ID，现在只有一个ID)
	 */
	private String userId;
	/**
	 * 是否勾选
	 */
	private String marker;
	
	/**
	 * 
	 * Title: isCheck  
	 * Description:  jackson序列化的时候会转化成check字段
	 * @return
	 */
	public boolean isCheck(){
		return StringUtils.equals(userId,marker);
	}
	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
