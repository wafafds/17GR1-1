package com.easybuy.dao;

import java.util.List;

import com.easybuy.entity.easybuy_product_category;

public interface productdao_categorydao {
void deleteById(Integer parseLong);//����idɾ����Ʒ����
	
	public List<easybuy_product_category> queryProductCategorylist(int param);

	public List<easybuy_product_category> queryAllProductCategorylist(int param);
	
	public easybuy_product_category queryProductCategoryById(Integer id);
	//������Ʒ
	public Integer save(easybuy_product_category productCategory) ;
	
	public Integer queryProductCategoryCount(int param);
	//������Ʒ
	public void update( easybuy_product_category productCategory) ;

}
