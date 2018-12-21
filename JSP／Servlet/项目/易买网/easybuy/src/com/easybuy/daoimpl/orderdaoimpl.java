package com.easybuy.daoimpl;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.easybuy.dao.BaseDao;
import com.easybuy.dao.orderdao;
import com.easybuy.entity.easybuy_order;
import com.easybuy.util.EmptyUtils;
import com.easybuy.util.Pager;

public class orderdaoimpl extends BaseDao implements orderdao {

	public easybuy_order tableToClass(ResultSet rs) throws Exception {
		easybuy_order order = new easybuy_order();
		order.setId(rs.getInt("id"));
		order.setUserid(rs.getString("userid"));
		order.setCreateTime(rs.getDate("createTime"));
		order.setCost(rs.getFloat("cost"));
		order.setUserAddress(rs.getString("userAddress"));
		order.setSeriaNumber(rs.getString("seriaNumber"));
		order.setLoginName(rs.getString("loginName"));
		return order;
	}
	public void add(easybuy_order order) {
		Integer id=0;
		String sql="insert into easybuy_order(userid,loginName,userAddress,createTime,cost,seriaNumber) values(?,?,?,?,?,?) ";
		Object[] param=new Object[]{order.getUserid(),order.getLoginName(),order.getUserAddress(),new Date(),order.getCost(),order.getSeriaNumber()};
		try {
			id=this.executeInsert(sql, param);
			order.setId(new Integer(id).intValue());
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		String sql = " delete from easybuy_order where id = ? ";
		Object params[] = new Object[] { id };
		try {
			this.executeUpdate(sql.toString(), params);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
		
	}

	@Override
	public easybuy_order getOrderById(Integer id) {
		String sql = " select * from easybuy_order where id = ? ";
		ResultSet rs = null;
		easybuy_order order = null;
		try {
			Object params[] = new Object[] { id };
			rs = this.executeQuery(sql, params);
			while (rs.next()) {
				order = tableToClass(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
			return order;
		}
	}

	@Override
	public List<easybuy_order> getOrderList(Integer userId,
			Integer currentPageNo, Integer pageSize) {
		List<Object> paramsList=new ArrayList<Object>();   
		List<easybuy_order> orderList=new ArrayList<easybuy_order>();
		StringBuffer sql=new StringBuffer(" select id,userId,loginName,userAddress,createTime,cost,serialNumber from easybuy_order  where 1=1 ");
		if(EmptyUtils.isNotEmpty(userId)){
			sql.append(" and userId = ? ");
			paramsList.add(userId);
		}
		int total = count(userId);
		Pager pager = new Pager(total, pageSize, currentPageNo);
		sql.append(" limit  " + (pager.getCurrentPage() - 1) * pager.getRowPerPage() + "," + pager.getRowPerPage());
		ResultSet rs = this.executeQuery(sql.toString(),paramsList.toArray());
		try {
			while (rs.next()) {
				easybuy_order order = this.tableToClass(rs);
				orderList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
				
		return orderList;
	}

	@Override
	public Integer count(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
