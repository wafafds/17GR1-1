package com.easybuy.dao;

import java.util.List;

import com.easybuy.entity.easybuy_order;

public interface orderdao {
	//��Ӷ���
public void add(easybuy_order order) ;
//����idɾ������
	public void deleteById(Integer id);
	//����id��ѯ����
	public easybuy_order getOrderById(Integer id) ;
	//��ѯ�����б�
	public List<easybuy_order> getOrderList(Integer userId,Integer currentPageNo,Integer pageSize) ;
	//��ȡ������Ŀ
	public Integer count(Integer userId);

}
