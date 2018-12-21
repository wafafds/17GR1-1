package com.easybuy.daoimpl;




import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.dao.BaseDao;
import com.easybuy.dao.order_detaildao;
import com.easybuy.entity.easybuy_order_detail;
import com.easybuy.util.EmptyUtils;

public class order_detaildaoimpl extends BaseDao implements order_detaildao {
	 public easybuy_order_detail tableToClass(ResultSet rs) throws Exception {
		 easybuy_order_detail orderDetail = new easybuy_order_detail();
	        orderDetail.setId(rs.getInt("id"));
	        orderDetail.setOrderid(rs.getInt("orderId"));
	        orderDetail.setProductid(rs.getInt("productId"));
	        orderDetail.setQuantity(rs.getInt("quantity"));
	        orderDetail.setCost(rs.getFloat("cost"));
	        return orderDetail;
	    }
	public void add(easybuy_order_detail detail) throws Exception {
		 Integer id=0;
			String sql=" insert into easybuy_order_detail(orderId,productId,quantity,cost) values(?,?,?,?) ";
	        try {
	            Object param[]=new Object[]{detail.getOrderid(),detail.getProductid(),detail.getId(),detail.getQuantity(),detail.getCost()};
	            id=this.executeInsert(sql,param);
	            detail.setId(id);
	        } catch (Exception e) {
				this.closeResource();
	            e.printStackTrace();
	        }
	}

	public void deleteById(easybuy_order_detail detail) throws Exception {
		String sql = " delete from easybuy_order_detail where id = ? ";
		Object params[] = new Object[] { detail.getId() };
		try {
		this.executeUpdate(sql.toString(), params);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
		
	}

	@Override
	public easybuy_order_detail getOrderDetailById(Integer id) throws Exception {
		String sql = " select orderId,productId,quantity,cost from easybuy_order_detail where id = ? ";
		ResultSet rs = null;
		easybuy_order_detail orderDetail = null;
		try {
			Object params[] = new Object[] { id };
			rs = this.executeQuery(sql, params);
			while (rs.next()) {
				orderDetail = tableToClass(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
			return orderDetail;
		}
	}

	@Override
	public List<easybuy_order_detail> getOrderDetailList(Integer orderId)
			throws Exception {
			List<easybuy_order_detail> orderDetailList = null;
			List<Object> paramsList=new ArrayList<Object>();
			StringBuffer sql = new StringBuffer(" select id,orderId,productId,quantity,cost FROM easybuy_order_detail where 1=1 ");
			
			if(EmptyUtils.isNotEmpty(orderId)){
				sql.append(" and orderId=? ");
				paramsList.add(orderId);
			}
			ResultSet rs = this.executeQuery(sql.toString(), paramsList.toArray());
			try {
				orderDetailList=new ArrayList<easybuy_order_detail>();
				while (rs.next()) {
					easybuy_order_detail orderDetail = this.tableToClass(rs);
					orderDetailList.add(orderDetail);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				this.closeResource();
				return orderDetailList;
			}
	}

	@Override
	public Integer queryOrderDetailCount(int params) throws Exception {
		Integer count = 0;
		List<easybuy_order_detail> orderDetailList = null;
		String sql = " select count(*) FROM easybuy_order_detail ";
		ResultSet rs = this.executeQuery(sql, new Object[] {});
		try {
			orderDetailList=new ArrayList<easybuy_order_detail>();
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
			return count;
		}
	}

}
