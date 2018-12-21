package com.easybuy.dao;

import java.util.List;

import com.easybuy.entity.easybuy_product_category;

public interface productdao_categorydao {
void deleteById(Integer parseLong);//根据id删除商品分类
	
	public List<easybuy_product_category> queryProductCategorylist(int param);

	public List<easybuy_product_category> queryAllProductCategorylist(int param);
	
	public easybuy_product_category queryProductCategoryById(Integer id);
	//保存商品
	public Integer save(easybuy_product_category productCategory) ;
	
	public Integer queryProductCategoryCount(int param);
	//更新商品
	public void update( easybuy_product_category productCategory) ;

}
