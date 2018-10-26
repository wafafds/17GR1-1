<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'info.jsp' starting page</title>
    
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
    request.setCharacterEncoding("UTF-8");
    String name=request.getParameter("txtUser");
    String password=request.getParameter("txtPass");
    String repassword=request.getParameter("txtRPass");
    String[] sex=request.getParameterValues("gen");
    for(String gen:sex){
    if(sex!=null){
    out.println(gen);
    }
    }
    String email=request.getParameter("txtEmail");
    String year=request.getParameter("year");
    String month=request.getParameter("month");
    String day=request.getParameter("day");
    
    out.println(name+"</br>"+password+"</br>"+sex+"</br>"+email+"</br>"+year+"</br>"+month+"</br>"+day+"</br>");
     
    
  
    
    
    
    
     %> <br>
  </body>
</html>
