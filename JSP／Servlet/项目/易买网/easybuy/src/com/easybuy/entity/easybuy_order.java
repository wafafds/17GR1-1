package com.easybuy.entity;

import java.util.Date;

//������
public class easybuy_order {
private int id;//���
private String userid;//�û�id
private String loginName;//�û���
private String userAddress;//�û���ַ
private Date createTime;//����ʱ��
private float cost;//���
private int status;//״̬
private int type;//����
private String seriaNumber;//������
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
