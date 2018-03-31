/**  
* Title: Picture.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年3月1日  
* @version 1.0  
*/  
package com.yxx.amazing.domain;

/**  
* Title: Picture  
* Description:  
* @author yuanxx  
* @date 2018年3月1日  
*/
public class Picture {
	private Integer id;
	private String pictureName;
	private String src;
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Picture [id=" + id + ", pictureName=" + pictureName + ", src=" + src + ", description=" + description
				+ "]";
	}
	
}
