<%@page import="org.jbit.news.entity.News"%>
<%@page import="org.jbit.news.dao.impl.NewsDaoImpl"%>
<%@page import="org.jbit.news.dao.NewsDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<div class="sidebar">
    <h1> <img src="images/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>
      	<%
      		NewsDao newsDao=new NewsDaoImpl();
      		int i=0;
      		for(News news: list1){  
      		i++;
      		if(i==6)break;     		
      	%>      	
     		<li> <a href='news_read.jsp?nid=<%=news.getNid() %>'><b> <%=news.getNtitle() %></b></a> </li>
      	<%} %>
      </ul>
    </div>
    <h1> <img src="images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>
      	<% 	
      		i=0;
      		for(News news: list2){ 
      		i++;
      		if(i==6)break;
      	%>
      	
     		<li> <a href='news_read.jsp?nid=<%=news.getNid() %>'><b> <%=news.getNtitle() %></b></a> </li>
      	<%} %>
      </ul>
    </div>
    <h1> <img src="images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
      	<%      	
      		i=0;
      		for(News news: list3){ 
      		i++;
      		if(i==6)break;
      	%>      	
     		<li> <a href='news_read.jsp?nid=<%=news.getNid() %>'><b> <%=news.getNtitle() %></b></a> </li>
      	<%} %>
      </ul>
    </div>
  </div>
<%
	request.removeAttribute("news_in_topic");
%>
