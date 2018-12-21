package com.easybuy.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.easybuy.dao.BaseDao;
import com.easybuy.dao.newsdao;
import com.easybuy.entity.easybuy_news;

public class newsdaoimpl extends BaseDao implements newsdao{

	public void save(easybuy_news news) throws Exception {
		String sql = " INSERT into easybuy_news(title,content,createTime) values( ?, ?, ?) ";
		Object[] params = new Object[] { news.getTitle(), news.getContent(),new Date() };
		super.executeUpdate(sql, params);
		
	}

	public void update(easybuy_news news) throws Exception {
		String sql="update easybuy_news set title=?,content=? where id=?";
		Object params=new Object[]{news.getTitle(),news.getContent(),news.getId()};
		super.executeUpdate(sql, params);
		
	}

	public void deleteById(Integer id) throws Exception {
		String sql = " delete from easybuy_news where id = ? ";
		Object params[] = new Object[] { id };
		super.executeUpdate(sql, params);
		
	}

	public easybuy_news getNewsById(Integer id) throws Exception {
		String sql = " select * from easybuy_news where id = ? ";
		easybuy_news  news = null;
			Object params[] = new Object[] { id };
			ResultSet rs = super.executeQuery(sql, params);
			while (rs.next()) {
				news = new easybuy_news  ();
				news.setId(rs.getInt(id));
			}
			super.closeResource();
			return news;
		}

	public List<easybuy_news> queryNewsList(int params) throws Exception {
		List<easybuy_news> al = new ArrayList<easybuy_news>();;
		String sql = " select id,title,content,createTime FROM easybuy_news ";
		ResultSet rs = this.executeQuery(sql, new Object[] {});
			while (rs.next()) {
				easybuy_news news = new easybuy_news();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setCreateTime(rs.getDate("createTime"));
				al.add(news);
			}
			super.closeResource();
			return al;
		}

	public Integer queryNewsCount(int params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
