package com.yxx.amazing.domain;

import java.util.List;

import net.sf.json.JSONObject;

public class Permission {
	
	private Integer id;
	
	private String url;
	
	private String name;
	
	private Integer pid;
	
	private int type;
	
	private String icon;
	
	private List<Permission> children;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public List<Permission> getChildren() {
		return children;
	}
	public void setChildren(List<Permission> children) {
		this.children = children;
	}
	
	
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
	
}
