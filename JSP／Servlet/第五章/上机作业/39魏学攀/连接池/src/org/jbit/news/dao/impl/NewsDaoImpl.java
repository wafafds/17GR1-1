package org.jbit.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.jbit.news.dao.BaseDao;
import org.jbit.news.dao.CommentsDao;
import org.jbit.news.dao.NewsDao;
import org.jbit.news.entity.Comment;
import org.jbit.news.entity.News;

public class NewsDaoImpl extends BaseDao implements NewsDao {
	public List<News> getAllnews() {
		Connection con=getConnection();
		PreparedStatement ps=null;
		List <News>list = new ArrayList<News>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		//获取所有新闻
		String sql = "select * from news,topic where news.ntid = topic.tid order by ntid,ncreatedate desc";
		try{			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			while(rs.next()){
				News news = new News();
				news.setNid(String.valueOf(rs.getObject("nid")));
				news.setNtid(String.valueOf(rs.getObject("ntid")));
				news.setNtitle((String)rs.getObject("ntitle"));
				news.setNauthor((String)rs.getObject("nauthor"));
				news.setNcontent((String)rs.getObject("ncontent"));
				news.setNcreatedate(sdf.format(rs.getTimestamp("NCREATEDATE")));
				news.setNtname(String.valueOf(rs.getObject("tname")));		
				list.add(news);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(con, ps,  rs);
		}		
		return list;
	}

	public List<News> getAllnewsByTID(int Tid) {
		Connection con=getConnection();
		PreparedStatement ps=null;
		List <News>list = new ArrayList<News>();
		//获取某主题下的所有新闻
		String sql = "select * from news  where ntid = ? order by ncreatedate desc";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try{			
			ps = con.prepareStatement(sql);
			ps.setInt(1, Tid);
			rs = ps.executeQuery();	
			while(rs.next()){				
				News news = new News();
				news.setNid(String.valueOf(rs.getObject("nid")));
				news.setNtid(String.valueOf(rs.getObject("ntid")));
				news.setNtitle((String)rs.getObject("ntitle"));
				news.setNauthor((String)rs.getObject("nauthor"));
				news.setNcontent((String)rs.getObject("ncontent"));
				news.setNcreatedate(sdf.format(rs.getTimestamp("NCREATEDATE")));
				news.setNtname(String.valueOf(rs.getObject("ntitle")));		
				list.add(news);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(con, ps,  rs);
		}		
		return list;
	}

	public List<News> getAllnewsByTName(String Tname) {
		Connection con=getConnection();
		PreparedStatement ps=null;
		List <News>list = new ArrayList<News>();
		//获取某主题下的所有新闻
		String sql = "select * from topic ,news where topic.tid = news.ntid and topic.tname=?";
		try{			
			ps = con.prepareStatement(sql);
			ps.setString(1,Tname);
			rs = ps.executeQuery();	
			while(rs.next()){				
				News news = new News();
				news.setNid(String.valueOf(rs.getObject("nid")));
				news.setNtid(String.valueOf(rs.getObject("ntid")));
				news.setNtitle((String)rs.getObject("ntitle"));
				news.setNauthor((String)rs.getObject("nauthor"));
				news.setNcontent((String)rs.getObject("ncontent"));
				news.setNtname(String.valueOf(rs.getObject("ntitle")));		
				list.add(news);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(con, ps,  rs);
		}		
		return list;
	}

	public News getNewsByNID(int Nid) {
		Connection con=getConnection();
		PreparedStatement ps=null;
		//获取某条新闻
		String sql = "select * from news  where nid = ? ";
		News news = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try{			
			ps = con.prepareStatement(sql);
			ps.setInt(1, Nid);
			rs = ps.executeQuery();	
			if(rs.next()){				
				news = new News();
				news.setNid(String.valueOf(rs.getObject("nid")));
				news.setNtid(String.valueOf(rs.getObject("ntid")));
				news.setNtitle((String)rs.getObject("ntitle"));
				news.setNauthor((String)rs.getObject("nauthor"));
				news.setNcontent((String)rs.getObject("ncontent"));
				news.setNcreatedate(sdf.format(rs.getTimestamp("NCREATEDATE")));
				news.setNtname(String.valueOf(rs.getObject("ntitle")));
			}
			CommentsDao commentsDao=new CommentsDaoImpl();
			List<Comment> comments=commentsDao.getCommentsByNid(String.valueOf(Nid));
			news.setComments(comments);//设置此新闻下的所有评论
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(con, ps,  rs);
		}		
		return news;
	}
}
