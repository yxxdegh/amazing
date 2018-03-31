package com.yxx.amazing.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	// 0:禁止登录
	public static final Long _0 = new Long(0);
	// 1:有效
	public static final Long _1 = new Long(1);
	private Integer id;
    private String userName;
    private String email;
    private String password;
    
    /**创建时间  加上该注解，springmvc可以自动把前台的string类型的日期转成后台的Date类型*/
   /* @DateTimeFormat(pattern = "yyyy-MM-dd")*/
    private Date createTime;
    
    /**最后登录时间*/
    private Date lastLoginTime;
    
    /**1:有效，0:禁止登录*/
    private Long status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

/*	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(LocalDateTime lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}*/

	public Long getStatus() {
		return status;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public User() {
	}

	public User(Integer id, String userName, String email, String password, Date createTime, Date lastLoginTime) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.createTime = createTime;
		this.lastLoginTime = lastLoginTime;
	}
    
	
	
	
}
