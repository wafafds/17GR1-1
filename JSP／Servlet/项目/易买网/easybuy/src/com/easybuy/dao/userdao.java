package com.easybuy.dao;

import java.util.List;

import com.easybuy.entity.easybuy_user;

public interface userdao {
	int add(easybuy_user user) throws Exception;//�����û���Ϣ

	int update(easybuy_user user) throws Exception;//�����û���Ϣ

	public int deleteUserById(String id) throws Exception;
	
	public List<easybuy_user> getUserList(Integer currentPageNo,Integer pageSize)throws Exception;
	
	public Integer count() throws Exception;
	public easybuy_user denglu(String userName,String password);
	
	public easybuy_user getUser(int id) throws Exception;


}
