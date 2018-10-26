<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="dao.Daobase"%>
<%@ page import="javabean.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'm1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <% 
  request.setCharacterEncoding("utf-8");
  String nam=request.getParameter("userid");
  String ps=request.getParameter("passwd");
  Daobase db=new Daobase();
  ArrayList<User> al=db.selectUser();
  for(User u:al){
	  if(u.getName().equals(nam)&&u.getPassword().equals(ps)){
		  request.getRequestDispatcher("m2.jsp").forward(request, response);
	  }else{
		  response.sendRedirect("mailLogin.jsp");
	  }
  }

  %>
  
  </body>
</html>
