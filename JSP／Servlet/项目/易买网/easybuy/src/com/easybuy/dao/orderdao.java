package com.easybuy.dao;

import java.util.List;

import com.easybuy.entity.easybuy_order;

public interface orderdao {
	//添加订单
public void add(easybuy_order order) ;
//根据id删除订单
	public void deleteById(Integer id);
	//根据id查询订单
	public easybuy_order getOrderById(Integer id) ;
	//查询订单列表
	public List<easybuy_order> getOrderList(Integer userId,Integer currentPageNo,Integer pageSize) ;
	//获取订单数目
	public Integer count(Integer userId);

}
