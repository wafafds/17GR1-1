package org.jbit.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.jbit.news.dao.BaseDao;
import org.jbit.news.dao.CommentsDao;
import org.jbit.news.entity.Comment;

public class CommentsDaoImpl extends BaseDao implements CommentsDao {

	public List<Comment> getCommentsByNid(String nid) {//通过nid查找评论
		Connection con=getConnection();
		PreparedStatement ps=null;
		
		List <Comment>list = new ArrayList<Comment>();		
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");
		String sql = "select * from comments"
					+ " where cnid = "
					+ nid
					+ " order by cdate desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Comment comment = new Comment();
				comment.setCid(String.valueOf(rs.getInt("cid")));
				comment.setCnid(String.valueOf(rs.getInt("cnid")));
				comment.setCauthor(rs.getString("cauthor"));
				comment.setCip(rs.getString("cip"));
				comment.setCcontent(rs.getString("ccontent"));
				comment.setCdate(sdf.format(rs.getObject("cdate")));
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{closeAll(con, ps,  rs);}
		return list;
	}

	public int addComment(Comment comment) {//添加评论
		String sql = "insert into comments (CNID,CCONTENT,CDATE,CIP,CAUTHOR) values(?,?,?,?,?)";
		System.out.println(comment.getCnid()+":"+comment.getCcontent()+":"+comment.getCdate()+":"+
				comment.getCip()+":"+comment.getCauthor());
		return exceuteUpdate(sql,new Object[]{comment.getCnid(),comment.getCcontent(),comment.getCdate(),
				comment.getCip(),comment.getCauthor()});
	}	
}
