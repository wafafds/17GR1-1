package com.easybuy.dao;

import java.util.List;

import com.easybuy.entity.easybuy_order_detail;

public interface order_detaildao {
	//��Ӷ���
    public void add(easybuy_order_detail detail) throws Exception;
    //����idɾ������
	public void deleteById(easybuy_order_detail detail) throws Exception;
	//����id��ѯ����
	public easybuy_order_detail getOrderDetailById(Integer id)throws Exception; 
	//��ѯ�����б�
	public List<easybuy_order_detail> getOrderDetailList(Integer orderId)throws Exception;
	//��ȡ������Ŀ
	public Integer queryOrderDetailCount(int params)throws Exception;

}
