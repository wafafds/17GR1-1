package com.easybuy.serviceimpl;

import java.util.List;

import com.easybuy.dao.newsdao;
import com.easybuy.daoimpl.newsdaoimpl;
import com.easybuy.entity.easybuy_news;
import com.easybuy.service.newsservice;

public class newsserviceimpl implements newsservice{
	newsdao newsdao= new newsdaoimpl();
	@Override
	public void savenews(easybuy_news news) throws Exception {
		newsdao.save(news);
		
	}

	@Override
	public void updatenews(easybuy_news news) throws Exception {
		newsdao.update(news);
		
	}

	@Override
	public void deletenewsById(Integer id) throws Exception {
		newsdao.deleteById(id);
		
		
	}

	@Override
	public easybuy_news getNewsById(Integer id) throws Exception {
		easybuy_news newsById = newsdao.getNewsById(id);
		
		return newsById;
	}

	@Override
	public List<easybuy_news> queryNewsList(int params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer queryNewsCount(int params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
