package com.easybuy.entity;

import java.util.Date;

//订单表
public class easybuy_order {
private int id;//编号
private String userid;//用户id
private String loginName;//用户名
private String userAddress;//用户地址
private Date createTime;//创建时间
private float cost;//金额
private int status;//状态
private int type;//类型
private String seriaNumber;//订单号
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getLoginName() {
	return loginName;
}
public void setLoginName(String loginName) {
	this.loginName = loginName;
}
public String getUserAddress() {
	return userAddress;
}
public void setUserAddress(String userAddress) {
	this.userAddress = userAddress;
}
public Date getCreateTime() {
	return createTime;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}
public float getCost() {
	return cost;
}
public void setCost(float cost) {
	this.cost = cost;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public String getSeriaNumber() {
	return seriaNumber;
}
public void setSeriaNumber(String seriaNumber) {
	this.seriaNumber = seriaNumber;
}




}
