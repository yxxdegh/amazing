/**  
* Title: LeftMenuBo.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年3月24日  
* @version 1.0  
*/  
package com.yxx.amazing.common.bo;

import java.util.List;

/**  
* Title: LeftMenuBo  
* Description:  这个类封装左侧菜单用的
* @author yuanxx  
* @date 2018年3月24日  
*/
public class LeftMenuBo {
	private Integer id;
	private String title;
	private String icon;
	private String href;
	private Boolean spread;
	private List<LeftMenuBo> children;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	
	
	public Boolean getSpread() {
		return false;
	}
	public void setSpread(Boolean spread) {
		this.spread = spread;
	}
	public List<LeftMenuBo> getChildren() {
		return children;
	}
	public void setChildren(List<LeftMenuBo> children) {
		this.children = children;
	}
	
}
