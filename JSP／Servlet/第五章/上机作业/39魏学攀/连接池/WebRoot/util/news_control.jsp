<%@page import="org.jbit.news.dao.CommentsDao"%>
<%@page import="org.jbit.news.dao.impl.CommentsDaoImpl"%>
<%@page import="org.jbit.news.dao.impl.TopicsDaoImpl"%>
<%@page import="org.jbit.news.dao.TopicsDao"%>
<%@page import="org.jbit.news.dao.NewsDao"%>
<%@page import="org.jbit.news.dao.impl.NewsDaoImpl,org.jbit.news.entity.*"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String opr = request.getParameter("opr");
	NewsDao newsDao=new NewsDaoImpl();
	TopicsDao topicDao=new TopicsDaoImpl();
	if(opr.equals("list")){//编辑新闻时对新闻的查找
		List<News> list=newsDao.getAllnews();	
		session.setAttribute("list",list);
		response.sendRedirect("../newspages/admin.jsp");
	}else if(opr.equals("listTitle")){//首次进入首页面
		List<News> list1 = newsDao.getAllnewsByTName("国内");
		List<News> list2 = newsDao.getAllnewsByTName("国际");
		List<News> list3 = newsDao.getAllnewsByTName("娱乐");
		List<Topic> list4 = topicDao.getAllTopics();
		List<News> list5 = newsDao.getAllnews();
		session.setAttribute("list1",list1);//左侧国内新闻
		session.setAttribute("list2",list2);//左侧国际新闻
		session.setAttribute("list3",list3);//左侧娱乐新闻
		session.setAttribute("list4",list4);//所有的主题
		session.setAttribute("list5",list5);//中间的所有新闻
		response.sendRedirect("../index.jsp");			
	}else if(opr.equals("topicNew")){//中间的某主题下的新闻		
		String Tid=request.getParameter("tid");
		List<News> list5 = newsDao.getAllnewsByTID(Integer.valueOf(Tid));
		session.setAttribute("list5",list5);//中间的某主题下的新闻
		response.sendRedirect("../index.jsp");	
	}else if(opr.equals("readNew")){//读取某条新闻
		String Nid=request.getParameter("nid");
		News news=newsDao.getNewsByNID(Integer.valueOf(Nid));		
		session.setAttribute("news",news);//用户具体点击的某条新闻		
		response.sendRedirect("../news_read.jsp");
	}else if(opr.equals("addComment")){//添加评论
		String cauthor = request.getParameter("cauthor");
		String cnid = request.getParameter("nid");
		String cip = request.getParameter("cip");
		String ccontent = request.getParameter("ccontent");
		java.util.Date date = new java.util.Date();
		Timestamp cdate = new Timestamp(date.getTime());
		Comment comment  = new Comment();
		comment.setCnid(cnid);		
		comment.setCcontent(ccontent);
		comment.setCdate(cdate.toString());
		comment.setCip(cip);
		comment.setCauthor(cauthor);		
		CommentsDao commentsDao=new CommentsDaoImpl();
		if(commentsDao.addComment(comment)>0){%>
			<script type="text/javascript">
				alert("已经成功添加评论，点击确认返回原来页面");
				location.href="../index.jsp";
			</script>
		<%}else{%>
			<script type="text/javascript">
				alert("添加新闻失败！请联系管理员查找原因！点击确认返回原来页面");
				location.href="../index.jsp";
			</script>
		<%}
	}
%>

