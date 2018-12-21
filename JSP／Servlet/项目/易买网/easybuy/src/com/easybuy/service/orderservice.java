package com.easybuy.service;


import java.util.List;

import com.easybuy.entity.easybuy_order;
import com.easybuy.entity.easybuy_order_detail;
import com.easybuy.entity.easybuy_user;

public interface orderservice {
	/**
	 * OrderService�ӿڷ�����
	 * ��1�����㶩�����������ͣ�Order���󣬲�����ShoppingCart����User�����ջ���ַ����
	 * ��2�����ݲ�ѯ��������ҳ��ʾ������Ϣ�б��������ͣ�List<Order>����������ǰҳ�롢ҳ���������û�id����
	 * ��3������������ѯ�������ܼ�¼�����������ͣ�int���������û�id����
	 * ��4�����ݶ���id��ѯ������ϸ�б��������ͣ�List<OrderDetail>������������id����ShoppingCart cart,
	 *
	 */

	public easybuy_order payShoppingCart( easybuy_user user,String address);//���㶩��
	
	public List<easybuy_order> getOrderList(Integer userId,//���ݲ�ѯ��������ҳ��ʾ������Ϣ�б�
									Integer currentPageNo,
									Integer pageSize);

    public int count(Integer userId);//����������ѯ�������ܼ�¼��
    
    public List<easybuy_order_detail> getOrderDetailList(Integer orderId);//���ݶ���id��ѯ������ϸ�б�
}
