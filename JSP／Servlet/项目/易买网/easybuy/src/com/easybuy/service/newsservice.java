package com.easybuy.service;

import java.util.List;

import com.easybuy.entity.easybuy_news;

public interface newsservice {
	//��������
	public void savenews(easybuy_news news) throws Exception;
	//��������
	public void updatenews(easybuy_news news) throws Exception;
	//����idɾ������
	public void deletenewsById(Integer id) throws Exception;
	//����ID��ȡ����
	public easybuy_news getNewsById(Integer id)throws Exception; 
	//��ѯ�����б�
	public List<easybuy_news> queryNewsList(int params)throws Exception; 
	//��ѯ��Ŀ
	public Integer queryNewsCount(int params)throws Exception; 
	

}
