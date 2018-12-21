package com.easybuy.dao;

import java.util.List;

import com.easybuy.entity.easybuy_user;

public interface userdao {
	int add(easybuy_user user) throws Exception;//新增用户信息

	int update(easybuy_user user) throws Exception;//更新用户信息

	public int deleteUserById(String id) throws Exception;
	
	public List<easybuy_user> getUserList(Integer currentPageNo,Integer pageSize)throws Exception;
	
	public Integer count() throws Exception;
	public easybuy_user denglu(String userName,String password);
	
	public easybuy_user getUser(int id) throws Exception;


}
