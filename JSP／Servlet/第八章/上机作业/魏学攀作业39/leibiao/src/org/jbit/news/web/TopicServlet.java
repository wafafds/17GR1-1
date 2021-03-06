﻿package org.jbit.news.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jbit.news.biz.TopicsBiz;
import org.jbit.news.biz.impl.TopicsBizImpl;
import org.jbit.news.entity.Topic;

public class TopicServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String opr = request.getParameter("opr");
		TopicsBiz topicsBiz = new TopicsBizImpl();
	
		String contextPath = request.getContextPath();
		if (opr.equals("update")) { 
			String tid = request.getParameter("tid");
			String tname = request.getParameter("tname");
			Map<String, String> topic = new HashMap<String, String>();
			topic.put("tid", tid);
			topic.put("tname", tname);
			Topic t=topicsBiz.findTopicByName(tname);
			if(t==null){
				if (topicsBiz.updateTopic(topic) > 0) {
					out.print("<script type='text/javascript'>"
							+ "alert('已经成功更新主题，点击确认返回主题列表');" + "location.href='"
							+ contextPath + "/TopicServlet?opr=list';</script>");
				} else {
					out.print("<script type='text/javascript'>"
							+ "alert('更新主题失败，点击确认返回主题列表');" + "location.href='"
							+ contextPath + "/newspages/topic_list.jsp';	</script>");
				}
			}else{
				out.print("<script type='text/javascript'>"
						+ "alert('更新主题失败，此主题已经存在');" + "location.href='"
						+ contextPath + "/newspages/topic_modify.jsp?tid="+tid+"&tname="+tname+"';	</script>");
			}			
		} else if (opr.equals("list")) {
			List<Topic> list = topicsBiz.getAllTopics();
			request.getSession().setAttribute("list4", list);
			response.sendRedirect(contextPath + "/newspages/topic_list.jsp");			
		} else if (opr.equals("add")) {
			String tname = request.getParameter("tname");
			Topic topic = topicsBiz.findTopicByName(tname);
			if (topic == null) {
				topicsBiz.addTopic(tname);
				List<Topic> list4 = topicsBiz.getAllTopics();
				request.getSession().setAttribute("list4", list4);
				out.print("<script type='text/javascript'>"
						+ "alert('当前主题创建成功，点击确认返回主题列表！');"
						+ "location.href='"+contextPath + "/TopicServlet?opr=list';"
						+ "</script>");
			}else{
				out.print("<script type='text/javascript'>"
						+ "alert('当前主题已存在，请输入不同的主题！');"
						+ "location.href='"+contextPath + "/newspages/topic_add.jsp';"
						+ "</script>");
			}
		}else if(opr.equals("del")){
			String tid = request.getParameter("tid");
			int result=topicsBiz.deleteTopic(tid);
			if(result==1){
				List<Topic> list4 = topicsBiz.getAllTopics();	
				request.getSession().setAttribute("list4",list4);
				out.print("<script type='text/javascript'>"
						+ "alert('已经成功删除主题，点击确认返回原来页面！');"
						+"location.href='"+contextPath + "/TopicServlet?opr=list';"
						+ "</script>");
			}else if(result==-1){
				out.print("<script type='text/javascript'>"
						+ "alert('删除主题失败！请联系管理员查找原因！点击确认返回原来页面！');"
						+"location.href='"+contextPath + "/TopicServlet?opr=list';"
						+ "</script>");
			}else{
				out.print("<script type='text/javascript'>"
						+ "alert('该主题下还有文章，不能删除！');"
						+"location.href='"+contextPath + "/TopicServlet?opr=list';"
						+ "</script>");
			}
		}
		out.flush();
		out.close();
	}

}
