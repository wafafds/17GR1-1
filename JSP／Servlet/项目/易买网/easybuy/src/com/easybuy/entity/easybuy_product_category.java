package com.easybuy.entity;
//商品分类表
public class easybuy_product_category {
private int id;
private String name;//名字
private int parentid;//父分类
private int type;//类型1.一级分类 2.二级分类  3.三级分类 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getParentid() {
	return parentid;
}
public void setParentid(int parentid) {
	this.parentid = parentid;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}

}
