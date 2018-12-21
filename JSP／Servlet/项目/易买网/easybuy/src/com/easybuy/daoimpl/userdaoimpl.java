package com.easybuy.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.easybuy.dao.BaseDao;
import com.easybuy.dao.userdao;
import com.easybuy.entity.easybuy_user;

public class userdaoimpl extends BaseDao implements userdao {

	public int add(easybuy_user user) throws Exception {
		int id=0;
    	try {
    		String sql=" INSERT into easybuy_user(loginName,userName,password,sex,identityCode,email,mobile) values(?,?,?,?,?,?,?) ";
            try {
                Object param[]=new Object[]{user.getLoglnName(),user.getUserName(),user.getPassword(),user.getSex(),user.getIdentityCode(),user.getEmail(),user.getMoblle()};
                id=super.executeInsert(sql,param);
                user.setId(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	super.closeResource();
        }
    	return id;
	}

	
	@Override
	public int update(easybuy_user user) throws Exception {
		Integer count=0;
		try {
        	Object[] params = new Object[] {user.getLoglnName(),user.getUserName(),user.getType(),user.getSex(),user.getIdentityCode(),user.getEmail(),user.getMoblle(),user.getId()};
        	String sql = " UPDATE easybuy_user SET loginName=?,userName =?,type=?,sex =?, identityCode =?, email =?, moblle =? WHERE id =?  ";
			count=this.executeUpdate(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	this.closeResource();
			return count;
        }
	}

	@Override
	public int deleteUserById(String id) throws Exception {
		Integer count=0;
		String sql = " delete from easybuy_user where id = ? ";
		Object params[] = new Object[] { id };
		try{
			count=this.executeUpdate(sql.toString(), params);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
        	this.closeResource();
			return count;
		}
	}

	@Override
	public List<easybuy_user> getUserList(Integer currentPageNo,
			Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer count() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  easybuy_user denglu(String userName, String password) {
		String sql="select * form easybuy_user where userName=? and password=?";
		ResultSet rs = super.executeQuery(sql, userName,password);
		easybuy_user user = null;
		try {
			while(rs.next()){
				user=new easybuy_user();
				user.setUserName(rs.getString(userName));
				user.setUserName(rs.getString(password));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public easybuy_user getUser(int id) throws Exception {
		String sql ="select id from easybuy_user where id=?";
		ResultSet rs = super.executeQuery(sql);
		easybuy_user user2 =null;
		while(rs.next()){
			user2= new easybuy_user();
			user2.setId(rs.getInt(id));
			
		}
		return user2;
	}

}
