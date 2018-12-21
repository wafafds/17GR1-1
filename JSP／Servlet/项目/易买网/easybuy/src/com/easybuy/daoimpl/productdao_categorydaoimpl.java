package com.easybuy.daoimpl;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.dao.BaseDao;
import com.easybuy.dao.productdao_categorydao;
import com.easybuy.entity.easybuy_product_category;

public class productdao_categorydaoimpl extends BaseDao implements productdao_categorydao {

	public easybuy_product_category tableToClass(ResultSet rs) throws Exception {
		easybuy_product_category productCategory = new easybuy_product_category();
		productCategory.setId(rs.getInt("id"));
		productCategory.setName(rs.getString("name"));
		productCategory.setParentid(rs.getInt("setParentid"));
		productCategory.setType(rs.getInt("type"));
		return productCategory;
	}
	
	public void deleteById(Integer id) {
		String sql = " delete from easybuy_product_category where id = ? ";
		Object params[] = new Object[] { id };
		this.executeUpdate(sql.toString(), params);	
		
	}

	@Override
	public List<easybuy_product_category> queryProductCategorylist(int param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<easybuy_product_category> queryAllProductCategorylist(int param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public easybuy_product_category queryProductCategoryById(Integer id) {
		List<Object> paramsList=new ArrayList<Object>();   
		easybuy_product_category productCategory=null;
		StringBuffer sql=new StringBuffer("SELECT id,name,parentId,type,iconClass  FROM easybuy_product_category where id = ? ");
		Object Object =new Object[]{id};
		ResultSet rs=this.executeQuery(sql.toString(),Object);
		try {
			while (rs.next()) {
				productCategory = this.tableToClass(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
		return productCategory;
	}

	
	@Override
	public Integer save(easybuy_product_category productCategory) {
		Integer id=0;
    	try {
    		String sql=" INSERT into easybuy_product_category(name,parentid,type) values(?,?,?) ";
            Object param[]=new Object[]{productCategory.getName(),productCategory.getParentid(),productCategory.getType()};
            id=this.executeInsert(sql,param);
            productCategory.setId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	this.closeResource();
        }
    	return id;
	}

	@Override
	public Integer queryProductCategoryCount(int param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update( easybuy_product_category productCategory) {
		try {
        	Object[] params = new Object[] {productCategory.getName(),productCategory.getParentid(),productCategory.getType(),productCategory.getId()};
        	String sql = " UPDATE easybuy_product_category SET name=?,parentid=?,type=?WHERE id =?  ";
    		this.executeUpdate(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	this.closeResource();
        }		
	}

}
