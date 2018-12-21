package com.easybuy.entity;
//用户表
public class easybuy_user {
	private int id;
	private String loglnName;//用户名
	private String userName;//用户真实姓名
	private String password;//密码
	private String sex;//性别
	private String identityCode;//身份证号
	private String email;//email
	private String moblle;//手机
	private int type;//类型 1为普通用户 2为管理员
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoglnName() {
		return loglnName;
	}
	public void setLoglnName(String loglnName) {
		this.loglnName = loglnName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdentityCode() {
		return identityCode;
	}
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMoblle() {
		return moblle;
	}
	public void setMoblle(String moblle) {
		this.moblle = moblle;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	

}
