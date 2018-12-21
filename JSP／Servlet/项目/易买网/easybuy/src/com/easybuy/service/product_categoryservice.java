package com.easybuy.service;


import java.util.List;

import com.easybuy.entity.easybuy_product_category;
import com.easybuy.util.ProductCategoryVo;

public interface product_categoryservice {
	/**
     * ����id��ѯ��Ʒ����
     * @param id
     * @return
     */
	//
    public easybuy_product_category getById(Integer id);
    /**
     * ��ѯ��Ʒ�����б�
     * @param params
     * @return
     */
    public List<easybuy_product_category> queryProductCategoryList();
    /**
     * ��ѯ��Ŀ
     * @param params
     * @return
     */
    public int queryProductCategoryCount();
    /**
     * �޸���Ʒ����
     * @param params
     */
    public void modifyProductCategory(easybuy_product_category productCategory);
    /**
     * �����Ʒ����
     * @param params
     */
    public void addProductCategory(easybuy_product_category productCategory);
    /**
     * ����idɾ��
     * @param id
     */
    public void deleteById(Integer id);
    /**
     * ��ѯȫ������Ʒ����
     * @return
     */
    public List<ProductCategoryVo> queryAllProductCategoryList();
    /**
     * ����sql��ѯ��Ʒ����
     * @param params
     * @return
     */
    public List<easybuy_product_category> queryProductCategorylistBySql();
    public List<ProductCategoryVo> addproductCateroryvo()throws Exception;
}



