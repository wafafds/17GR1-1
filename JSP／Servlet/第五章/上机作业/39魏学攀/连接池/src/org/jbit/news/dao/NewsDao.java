package org.jbit.news.dao;

import java.util.List;

import org.jbit.news.entity.News;

public interface NewsDao{
	//获取所有新闻
	public List<News> getAllnews();	
	//获取某主题下的所有新闻
	public List<News> getAllnewsByTID(int Tid);	
	//获取某主题下的所有新闻
	public List<News> getAllnewsByTName(String Tname);	
	//获取某条新闻
	public News getNewsByNID(int Nid);
}