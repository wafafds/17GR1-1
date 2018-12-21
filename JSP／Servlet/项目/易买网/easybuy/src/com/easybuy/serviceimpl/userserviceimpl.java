package com.easybuy.serviceimpl;

import java.sql.Connection;
import java.util.List;

import com.easybuy.dao.BaseDao;
import com.easybuy.dao.userdao;
import com.easybuy.daoimpl.userdaoimpl;
import com.easybuy.entity.easybuy_user;
import com.easybuy.service.userservice;

public class userserviceimpl  implements userservice{

	public boolean add(easybuy_user user) {
		
		userdao userdao = new userdaoimpl();
		int add=0;
		try {
			add= userdao.add(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return add>0;
	}

	public int update(easybuy_user user) {
		return 0;
	}

	public int deleteUserById(String id) {
		return 0;
	}

	public List<easybuy_user> getUserList(int currentPageNo, int pageSize) {
		return null;
	}

	public int count() throws Exception {
		return 0;
	}

	public easybuy_user denglu(String userName, String password) {
		userdao userdao = new userdaoimpl();
		easybuy_user denglu = userdao.denglu(userName, password);
		return denglu;
	}

	public easybuy_user getUser(int id) {
		userdao userdao = new userdaoimpl();
		easybuy_user user =null;
		try {
			 user = userdao.getUser(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
