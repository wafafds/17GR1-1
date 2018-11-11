<%@page import="org.jbit.news.entity.Comment"%>
<%@page import="org.jbit.news.entity.Topic"%>
<%@page import="org.jbit.news.entity.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/read.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function checkComment(){
		var cauthor = document.getElementById("cauthor");
		var content = document.getElementById("ccontent");
		if(cauthor.value == ""){
			alert("用户名不能为空！！");
			return false;
		}else if(content.value == ""){
			alert("评论内容不能为空！！");
			return false;
		}
		return true;
	}
</script>
<%	
	String cip = request.getRemoteAddr();
	News n=(News)session.getAttribute("news");
	List<Comment> comments=(List<Comment>)n.getComments();
	List<News> list1 = (List<News>)session.getAttribute("list1");
      List<News> list2 = (List<News>)session.getAttribute("list2");
      List<News> list3 = (List<News>)session.getAttribute("list3");      
      if(list1==null&&list2==null&&list3==null){
      	response.sendRedirect("util/news_control.jsp?opr=readNew");
      	return;
      }else{%>

<div id="container">
  <%@include file="index-elements/index_sidebar.jsp"%>
  <div class="main">
    <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="classlist">
        <table width="80%" align="center">
          <tr width="100%">
            <td colspan="2" align="center"><%=n.getNtitle() %></td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
          <tr>
            <td align="center">作者：<%=n.getNauthor() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             </a></td>
            <td align="left">发布时间：<%=n.getNcreatedate() %></td>
          </tr>          
          <tr>
            <td colspan="2" align="center"></td>
          </tr>
          <tr>
            <td colspan="2"><%=n.getNcontent() %></td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
        </table>
      </ul>
      <ul class="classlist">
        <table width="80%" align="center">
        
        <%
        if(comments.size()<=0){%>
	        <td colspan="6"> 暂无评论！ </td>
	          <tr>
	            <td colspan="6"><hr />
	            </td>
	          </tr>
        <%}else{
        	for(Comment comment: comments){ %>
        		<tr>
				    <td> 留言人： </td>
				    <td><%=comment.getCauthor()%></td>
					<td> IP： </td>
					<td><%=comment.getCip()%></td>
					<td> 留言时间： </td>
					<td><%=comment.getCdate()%></td>
				</tr>
				<tr>
					<td colspan="6"><%=comment.getCcontent()%></td>
				</tr>
				<tr>
					<td colspan="6"><hr />
					</td>
				</tr>
       	<%	 }
       	 }        
         %>
        </table>
      </ul>
      <ul class="classlist">
        <form action="util/news_control.jsp?opr=addComment&nid=<%=n.getNid() %>" method="post" onSubmit="return checkComment()">
          <table width="80%" align="center">
            <tr>
              <td> 评 论 </td>
            </tr>
            <tr>
              <td> 用户名： </td>
              <td>
	              <%if(session.getAttribute("admin")!=null&&session.getAttribute("admin").toString().length()>0){%>
	              <input id="cauthor" name="cauthor" value="<%=session.getAttribute("admin") %>" readonly="readonly" style="border:0px;"/>
	              <%}else{%>
	              <input id="cauthor" name="cauthor" value="这家伙很懒什么也没留下"/>
	               <%} %> 
                IP：
                <input name="cip" id="cip" value="<%=cip %>" readonly="readonly" style="border:0px;"/>
              </td>
            </tr>
            <tr>
              <td colspan="2"><textarea name="ccontent" id="ccontent" cols="70" rows="10"></textarea>
              </td>
            </tr>
            <td><input name="submit" value="发  表" type="submit"/>
              </td>
          </table>
        </form>
      </ul>
    </div>
  </div>
</div>
<%
	request.removeAttribute("news_view");
	request.removeAttribute("comments_view");
%>
<%@include file="index-elements/index_bottom.html"%>
<%}%>