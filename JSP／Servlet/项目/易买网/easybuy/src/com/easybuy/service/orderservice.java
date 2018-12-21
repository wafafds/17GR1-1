package com.easybuy.service;


import java.util.List;

import com.easybuy.entity.easybuy_order;
import com.easybuy.entity.easybuy_order_detail;
import com.easybuy.entity.easybuy_user;

public interface orderservice {
	/**
	 * OrderService接口方法：
	 * （1）结算订单（返回类型：Order对象，参数：ShoppingCart对象、User对象、收货地址）。
	 * （2）根据查询条件，分页显示订单信息列表（返回类型：List<Order>，参数：当前页码、页码容量，用户id）。
	 * （3）根据条件查询订单表总记录数（返回类型：int，参数：用户id）。
	 * （4）根据订单id查询订单明细列表（返回类型：List<OrderDetail>，参数：订单id）。ShoppingCart cart,
	 *
	 */

	public easybuy_order payShoppingCart( easybuy_user user,String address);//结算订单
	
	public List<easybuy_order> getOrderList(Integer userId,//根据查询条件，分页显示订单信息列表
									Integer currentPageNo,
									Integer pageSize);

    public int count(Integer userId);//根据条件查询订单表总记录数
    
    public List<easybuy_order_detail> getOrderDetailList(Integer orderId);//根据订单id查询订单明细列表
}
