package com.easybuy.dao;

import java.util.List;

import com.easybuy.entity.easybuy_product;

public interface productdao {
	public List <easybuy_product> selectproduct();
      public int updateStock(Integer id, Integer quantity) throws Exception;
	
	public Integer add(easybuy_product product) throws Exception;
	

	public Integer update(easybuy_product product) throws Exception;
	
	public Integer deleteProductById(Integer id) throws Exception;
	
	public easybuy_product getProductById(Integer id)throws Exception;
	
	public List<easybuy_product> getProductList(Integer currentPageNo,Integer pageSize,String proName,Integer categoryId,Integer level)throws Exception;
	
	public Integer queryProductCount(String proName,Integer categoryId,Integer level)throws Exception;

}
