package com.easybuy.dao;

import java.util.List;

import com.easybuy.entity.easybuy_news;

   public interface newsdao {
    //保存新闻
	public void save(easybuy_news news) throws Exception;
    //更新新闻
	public void update(easybuy_news news) throws Exception;
	//根据id删除新闻
	public void deleteById(Integer id) throws Exception;
	//根据id查询新闻
	public easybuy_news getNewsById(Integer id)throws Exception; 
	//查询新闻列表
	public List<easybuy_news> queryNewsList(int params)throws Exception; 
	//查询数目
	public Integer queryNewsCount(int params)throws Exception; 

}
