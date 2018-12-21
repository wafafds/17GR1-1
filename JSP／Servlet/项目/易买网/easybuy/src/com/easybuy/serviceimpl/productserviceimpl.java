package com.easybuy.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.easybuy.dao.productdao;
import com.easybuy.daoimpl.productdaoimpl;
import com.easybuy.entity.easybuy_product;
import com.easybuy.service.productservice;
import com.easybuy.util.ProductCategoryVo;

public class productserviceimpl implements productservice {

	private productdao productdao = new productdaoimpl();

	@Override
	public int updateStockserice(Integer id, Integer quantity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer addproduct(easybuy_product product) throws Exception {
		Integer add = productdao.add(product);
		return add;
	}

	public Integer updateproduct(easybuy_product product) throws Exception {
		Integer update = productdao.update(product);
		return update;
	}

	public Integer deleteProductsericeById(int id) throws Exception {
		Integer productid = productdao.deleteProductById(id);
		return productid;
	}

	@Override
	public easybuy_product getProductsericeById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Integer queryProductsericeCount(String proName, Integer categoryId,
			Integer level) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<easybuy_product> selectproduct() {
		List<easybuy_product> selectproduct = productdao.selectproduct();
		return selectproduct;
	}

	

}
