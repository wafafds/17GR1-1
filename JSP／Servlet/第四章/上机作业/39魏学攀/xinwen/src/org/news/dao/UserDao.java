package org.news.dao;


import org.news.entity.User;

public interface UserDao{
	public User findUser(String uname, String password);		 
}