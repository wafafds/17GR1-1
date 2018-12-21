package com.easybuy.service;


import java.util.List;

import com.easybuy.entity.easybuy_product_category;
import com.easybuy.util.ProductCategoryVo;

public interface product_categoryservice {
	/**
     * 根据id查询商品分类
     * @param id
     * @return
     */
	//
    public easybuy_product_category getById(Integer id);
    /**
     * 查询商品分类列表
     * @param params
     * @return
     */
    public List<easybuy_product_category> queryProductCategoryList();
    /**
     * 查询数目
     * @param params
     * @return
     */
    public int queryProductCategoryCount();
    /**
     * 修改商品分类
     * @param params
     */
    public void modifyProductCategory(easybuy_product_category productCategory);
    /**
     * 添加商品分类
     * @param params
     */
    public void addProductCategory(easybuy_product_category productCategory);
    /**
     * 根据id删除
     * @param id
     */
    public void deleteById(Integer id);
    /**
     * 查询全部的商品分类
     * @return
     */
    public List<ProductCategoryVo> queryAllProductCategoryList();
    /**
     * 根据sql查询商品分类
     * @param params
     * @return
     */
    public List<easybuy_product_category> queryProductCategorylistBySql();
    public List<ProductCategoryVo> addproductCateroryvo()throws Exception;
}



