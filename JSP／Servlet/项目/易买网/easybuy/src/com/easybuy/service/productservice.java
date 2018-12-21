package com.easybuy.service;

import java.util.List;

import com.easybuy.entity.easybuy_product;
import com.easybuy.util.ProductCategoryVo;

   public interface productservice {
	   public List <easybuy_product> selectproduct();
    public int updateStockserice(Integer id, Integer quantity) throws Exception;
	
	public Integer addproduct(easybuy_product product) throws Exception;
	

	public Integer updateproduct(easybuy_product product) throws Exception;
	
	public Integer deleteProductsericeById(int id) throws Exception;
	
	public easybuy_product getProductsericeById(Integer id)throws Exception;
	
	
	public Integer queryProductsericeCount(String proName,Integer categoryId,Integer level)throws Exception;

}
