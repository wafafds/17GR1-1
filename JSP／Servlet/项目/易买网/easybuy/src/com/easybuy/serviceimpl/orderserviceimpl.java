package com.easybuy.serviceimpl;

import java.util.List;

import com.easybuy.entity.easybuy_order;
import com.easybuy.entity.easybuy_order_detail;
import com.easybuy.entity.easybuy_user;
import com.easybuy.service.orderservice;

public class orderserviceimpl implements orderservice {

	@Override
	public easybuy_order payShoppingCart(easybuy_user user, String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<easybuy_order> getOrderList(Integer userId,
			Integer currentPageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(Integer userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<easybuy_order_detail> getOrderDetailList(Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
