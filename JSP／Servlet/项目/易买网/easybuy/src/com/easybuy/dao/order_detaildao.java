package com.easybuy.dao;

import java.util.List;

import com.easybuy.entity.easybuy_order_detail;

public interface order_detaildao {
	//添加订单
    public void add(easybuy_order_detail detail) throws Exception;
    //根据id删除订单
	public void deleteById(easybuy_order_detail detail) throws Exception;
	//根据id查询订单
	public easybuy_order_detail getOrderDetailById(Integer id)throws Exception; 
	//查询订单列表
	public List<easybuy_order_detail> getOrderDetailList(Integer orderId)throws Exception;
	//获取订单数目
	public Integer queryOrderDetailCount(int params)throws Exception;

}
