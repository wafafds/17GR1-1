<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用EL展示问卷信息</title>

  </head>
  
  <body>
  		您填写的内容是：<br>
    	昵称：${requestScope.question.username }<br>
    	所在城市：${requestScope.question.city }<br>
    	使用的开发语言有：${requestScope.question.languages }
  </body>
</html>
