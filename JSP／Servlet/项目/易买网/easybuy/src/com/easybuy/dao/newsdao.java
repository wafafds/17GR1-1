package com.easybuy.dao;

import java.util.List;

import com.easybuy.entity.easybuy_news;

   public interface newsdao {
    //��������
	public void save(easybuy_news news) throws Exception;
    //��������
	public void update(easybuy_news news) throws Exception;
	//����idɾ������
	public void deleteById(Integer id) throws Exception;
	//����id��ѯ����
	public easybuy_news getNewsById(Integer id)throws Exception; 
	//��ѯ�����б�
	public List<easybuy_news> queryNewsList(int params)throws Exception; 
	//��ѯ��Ŀ
	public Integer queryNewsCount(int params)throws Exception; 

}
