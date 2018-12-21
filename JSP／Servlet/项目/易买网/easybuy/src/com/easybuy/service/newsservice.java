package com.easybuy.service;

import java.util.List;

import com.easybuy.entity.easybuy_news;

public interface newsservice {
	//保存新闻
	public void savenews(easybuy_news news) throws Exception;
	//更新新闻
	public void updatenews(easybuy_news news) throws Exception;
	//根据id删除新闻
	public void deletenewsById(Integer id) throws Exception;
	//根据ID获取新闻
	public easybuy_news getNewsById(Integer id)throws Exception; 
	//查询新闻列表
	public List<easybuy_news> queryNewsList(int params)throws Exception; 
	//查询数目
	public Integer queryNewsCount(int params)throws Exception; 
	

}
