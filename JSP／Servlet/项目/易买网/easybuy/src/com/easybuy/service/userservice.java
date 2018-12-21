package com.easybuy.service;

import java.util.List;

import com.easybuy.entity.easybuy_user;

public interface userservice {
	public boolean add(easybuy_user user);

	public int update(easybuy_user user) ;//更新用户信息

	public int deleteUserById(String id) ;
	
	public List<easybuy_user> getUserList(int currentPageNo,int pageSize);
	
	public int count() throws Exception;
	public easybuy_user denglu(String userName,String password);
	
	public easybuy_user getUser(int id) ;

}
