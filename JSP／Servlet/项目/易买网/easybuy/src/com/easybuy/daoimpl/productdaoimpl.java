package com.easybuy.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.dao.BaseDao;
import com.easybuy.dao.productdao;
import com.easybuy.entity.easybuy_product;

public class productdaoimpl extends BaseDao implements productdao {

	public List<easybuy_product> selectproduct() {
		String sql ="select * form easybuy_product ";
		ResultSet rs = super.executeQuery(sql);
		List<easybuy_product> al = new ArrayList<easybuy_product>();
		easybuy_product product;
		try {
			while(rs.next()){
				product=new easybuy_product();	
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setStock(rs.getInt("stock"));
				product.setCategoryLevel1(rs.getInt("categoryLevel1"));
				product.setCategoryLevel2(rs.getInt("categoryLevel2"));
				product.setCategoryLevel3(rs.getString("CategoryLevel3"));
				product.setFileName(rs.getString("fileName"));
				product.setIsDelete(rs.getString("isDelete"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
	}

	@Override
	public int updateStock(Integer id, Integer quantity) throws Exception {
		Object[] params = new Object[] {id,quantity};
		String sql="update easybuy_product set stock=? where id=?";
		int count = super.executeUpdate(sql, params);
		super.closeAll(null,null,null);
		return count;
	}

	@Override
	public Integer add(easybuy_product product) throws Exception {
		String sql="insert into easybuy_product(name,description,price,stock,categoryLevel1,categoryLevel2,categoryLevel3,fileName,isDelete) values(?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] {product.getName(),product.getDescription(),product.getPrice(),product.getStock(),product.getCategoryLevel1(),product.getCategoryLevel1(),product.getCategoryLevel1(),product.getFileName()};
		int count = super.executeInsert(sql, params);
		super.closeAll(null, null, null);
		return count;
	}

	@Override
	public Integer update(easybuy_product product) throws Exception {
        	String sql = " update easybuy_product set name=?,fileName=?,categoryLevel1=?,categoryLevel3=?,categoryLevel3=? where id=? ";
        	Object[] params = new Object[] {product.getName(),product.getFileName(),product.getCategoryLevel1(),product.getCategoryLevel2(),product.getCategoryLevel3(),product.getId()};
        	int	count=super.executeUpdate(sql, params);
			super.closeAll(null, null, null);
			return count;
		
	}

	@Override
	public Integer deleteProductById(Integer id) throws Exception {
	String sql="Delete from easybuy_product where id=?";
	Object[] params = new Object[]{id};
	int count = super.executeUpdate1(sql, params);
	super.closeAll(null, null, null);
		return count;
	}

	@Override
	public easybuy_product getProductById(Integer id) throws Exception {
		String sql="select  id from easybuy_product where id=?";
		Object[] params = new Object[]{id};
		ResultSet rs = super.executeQuery(sql, params);
		 easybuy_product product = null;
		while(rs.next()){
			  product = new easybuy_product();
			 product.setId(rs.getInt(id));
		}
		
		return product;
	}

	@Override
	public List<easybuy_product> getProductList(Integer currentPageNo,
			Integer pageSize, String proName, Integer categoryId, Integer level)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer queryProductCount(String proName, Integer categoryId,
			Integer level) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
