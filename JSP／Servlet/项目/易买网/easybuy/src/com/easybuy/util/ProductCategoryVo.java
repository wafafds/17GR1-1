package com.easybuy.util;

import com.easybuy.entity.easybuy_product;
import com.easybuy.entity.easybuy_product_category;

import java.io.Serializable;
import java.util.List;


public class ProductCategoryVo implements Serializable {

    private easybuy_product_category productCategory;
    private List<ProductCategoryVo> productCategoryVoList;
    private List<easybuy_product> productList;

    public easybuy_product_category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(easybuy_product_category productCategory) {
        this.productCategory = productCategory;
    }

    public List<ProductCategoryVo> getProductCategoryVoList() {
        return productCategoryVoList;
    }

    public void setProductCategoryVoList(List<ProductCategoryVo> productCategoryVoList) {
        this.productCategoryVoList = productCategoryVoList;
    }

    public List<easybuy_product> getProductList() {
        return productList;
    }

    public void setProductList(List<easybuy_product> productList) {
        this.productList = productList;
    }
}
