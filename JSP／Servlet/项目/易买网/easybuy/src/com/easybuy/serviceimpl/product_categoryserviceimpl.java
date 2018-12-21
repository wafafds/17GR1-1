package com.easybuy.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.easybuy.daoimpl.productdao_categorydaoimpl;
import com.easybuy.entity.easybuy_product_category;
import com.easybuy.service.product_categoryservice;
import com.easybuy.util.ProductCategoryVo;

public class product_categoryserviceimpl implements product_categoryservice{

	@Override
	public easybuy_product_category getById(Integer id) {
		productdao_categorydaoimpl categorydaoimpl = new productdao_categorydaoimpl();
		easybuy_product_category queryProductCategoryById = categorydaoimpl.queryProductCategoryById(id);
		return queryProductCategoryById;
	}

	@Override
	public List<easybuy_product_category> queryProductCategoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryProductCategoryCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifyProductCategory(easybuy_product_category productCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProductCategory(easybuy_product_category productCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductCategoryVo> queryAllProductCategoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<easybuy_product_category> queryProductCategorylistBySql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCategoryVo> addproductCateroryvo() throws Exception {
		List<ProductCategoryVo> VO=new ArrayList<ProductCategoryVo>();
		List<easybuy_product_category> productcategory=(List<easybuy_product_category>) getById(null);
		for(easybuy_product_category productCategory:productcategory){
			ProductCategoryVo vo2 = new  ProductCategoryVo();
			vo2.setProductCategory(productCategory);
			List<easybuy_product_category> productcategory2=new ArrayList<easybuy_product_category>();
			for(easybuy_product_category productCategory2:productcategory){
				ProductCategoryVo vo3 = new  ProductCategoryVo();
				
			}
		}
		return null;
	}

}
