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
		Connection con = getConnection();
		PreparedStatement ps = null;
		List<News> list = new ArrayList<News>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		// 鑾峰彇鎵�湁鏂伴椈
		String sql = "select * from news,topic where news.ntid = topic.tid order by ncreatedate desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setNid(String.valueOf(rs.getObject("nid")));
				news.setNtid(String.valueOf(rs.getObject("ntid")));
				news.setNtitle((String) rs.getObject("ntitle"));
				news.setNauthor((String) rs.getObject("nauthor"));
				news.setNcontent((String) rs.getObject("ncontent"));
				news.setNcreatedate(sdf.format(rs.getTimestamp("NCREATEDATE")));
				news.setNtname(String.valueOf(rs.getObject("tname")));
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(con, ps, rs);
		}
		return list;
	}

	public List<News> getAllnewsByPage1(int Tid, int pageSize, int pageNo) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		List<News> list = new ArrayList<News>();
		int startIndex=(pageNo-1)*pageSize;
		// 鑾峰彇鎵�湁鏂伴椈鏁扮洰
		String sql = "SELECT * FROM news,topic WHERE news.ntid=topic.tid and news.ntid="+Tid+" order by news.ncreatedate desc limit "+startIndex+","+pageSize ;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setNcontent(rs.getString("ncontent"));
				news.setNsummary(rs.getString("nsummary"));
				news.setNid(String.valueOf(rs.getObject("nid")));
				news.setNtid(String.valueOf(rs.getObject("ntid")));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNtname(rs.getString("tname"));
				news.setNcreatedate(rs.getString("ncreatedate"));
				news.setNpicpath(rs.getString("npicpath"));
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(con, ps, rs);
		}
		return list;
	}

	public List<News> getAllnewsByTName(String Tname) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		List<News> list = new ArrayList<News>();
		// 鑾峰彇鏌愪富棰樹笅鐨勬墍鏈夋柊闂�
		String sql = "select * from topic ,news where topic.tid = news.ntid and topic.tname=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Tname);
			rs = ps.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setNid(String.valueOf(rs.getObject("nid")));
				news.setNtid(String.valueOf(rs.getObject("ntid")));
				news.setNtitle((String) rs.getObject("ntitle"));
				news.setNauthor((String) rs.getObject("nauthor"));
				news.setNcontent((String) rs.getObject("ncontent"));
				news.setNtname(String.valueOf(rs.getObject("ntitle")));
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(con, ps, rs);
		}
		return list;
	}

	public News getNewsByNID(int Nid) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		// 鑾峰彇鏌愭潯鏂伴椈
		String sql = "select * from news  where nid = ? ";
		News news = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, Nid);
			rs = ps.executeQuery();
			if (rs.next()) {
				news = new News();
				news.setNid(String.valueOf(rs.getObject("nid")));
				news.setNtid(String.valueOf(rs.getObject("ntid")));
				news.setNtitle((String) rs.getObject("ntitle"));
				news.setNsummary((String) rs.getObject("NSUMMARY"));
				news.setNauthor((String) rs.getObject("nauthor"));
				news.setNcontent((String) rs.getObject("ncontent"));
				news.setNcreatedate(sdf.format(rs.getTimestamp("NCREATEDATE")));
				news.setNtname(String.valueOf(rs.getObject("ntitle")));
			}
			CommentsDao commentsDao = new CommentsDaoImpl();
			List<Comment> comments = commentsDao.getCommentsByNid(String
					.valueOf(Nid));
			news.setComments(comments);// 璁剧疆姝ゆ柊闂讳笅鐨勬墍鏈夎瘎璁�
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(con, ps, rs);
		}
		return news;
	}

	// 鍒犻櫎鏂伴椈
	public int deleteNews(String nid) {
		String sql = "delete from news where nid = ?"; // 鍒犻櫎姝ゆ柊闂�
		return exceuteUpdate(sql, new Object[] { Integer.valueOf(nid) });
	}

	// 鑾峰彇鎵�湁鏂伴椈鏁扮洰
	public int countNews(String Tid) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		int count = 0;
		String sql ="";
		// 鑾峰彇鎵�湁鏂伴椈鏁扮洰
		if(Tid==null){
			sql = "select count(*) from news";
		}else{
			sql = "select count(*) from news where ntid="+Integer.valueOf(Tid);
		}		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(con, ps, rs);
		}
		return count;
	}

	// 閫氳繃鍒嗛〉鑾峰彇鎵�湁鏂伴椈
	public List<News> getAllnewsByPage(int Tid,int page_info_no, int page_no){
		Connection con=getConnection();
		PreparedStatement ps=null;
		List<News> list=new ArrayList<News>();		
		//鑾峰彇鎵�湁鏂伴椈鏁扮洰
			String sql = "select top "+page_info_no+" * "
				+ "from news,topic"
				+ " where news.ntid = topic.tid and ntid="+Tid+" and nid not in( select top "
				+ (page_info_no*(page_no-1))
				+" nid from news,topic where news.ntid = topic.tid and ntid="+Tid+"order by news.ncreatedate desc)"
				+" order by news.ncreatedate desc";	
		try{			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			while(rs.next()){
				News news = new News();
				news.setNcontent( rs.getString("ncontent"));
				news.setNsummary( rs.getString("nsummary"));	
				news.setNid( String.valueOf(rs.getObject("nid")));
				news.setNtid(String.valueOf(rs.getObject("ntid")));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor( rs.getString("nauthor"));
				news.setNtname( rs.getString("tname"));				
				news.setNcreatedate( rs.getString("ncreatedate"));
				news.setNpicpath(rs.getString("npicpath"));								
				list.add(news);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(con, ps,  rs);
		}		
		return list;		
	}
	
    //娣诲姞鏂伴椈
	public int addNews(News news) {			
		String sql = "insert into news(NTID,NTITLE,NAUTHOR,NCONTENT,NSUMMARY,NCREATEDATE,NMODIFYDATE,NPICPATH) values(?,?,?,?,?,getdate(),getdate(),?)";		
				return exceuteUpdate(sql,new Object[]{news.getNtid(),news.getNtitle(),news.getNauthor()
						,news.getNcontent(),news.getNsummary(),news.getNpicpath()});		
	}

	//缂栬緫鏂伴椈
	public int updateNews(News news) {		
		String sql = "update news set NTID=?,NTITLE=?,NAUTHOR=?,NCONTENT=?,NSUMMARY=?,NCREATEDATE=getdate(),NMODIFYDATE=getdate(),NPICPATH=? "
				+ "where nid = ?" ;	
		return exceuteUpdate(sql,new Object[]{news.getNtid(),news.getNtitle(),news.getNauthor()
				,news.getNcontent(),news.getNsummary(),news.getNpicpath(),news.getNid()});
	}

	@Override
	public List<News> getAllnewsByTID(int Tid) {
		// TODO Auto-generated method stub
		return null;
	}
}
