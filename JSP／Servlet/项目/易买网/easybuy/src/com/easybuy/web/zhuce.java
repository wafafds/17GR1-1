package com.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.dao.userdao;
import com.easybuy.daoimpl.userdaoimpl;
import com.easybuy.entity.easybuy_user;
import com.easybuy.service.userservice;
import com.easybuy.serviceimpl.userserviceimpl;

public class zhuce extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 PrintWriter pw=response.getWriter();
		 easybuy_user user = new easybuy_user();
		 userservice userservice = new userserviceimpl();
			
		  user.setLoglnName(request.getParameter("loginName"));
          user.setUserName(request.getParameter("userName"));
          user.setPassword((request.getParameter("password")));
          user.setIdentityCode(request.getParameter("identityCode"));
          user.setEmail(request.getParameter("email"));
          user.setMoblle(request.getParameter("moblle"));
          String loglnName = request.getParameter("loglnName");
          if (loglnName.equals(user.getLoglnName())) {
        	  pw.write("<script language='javascript'>alert('用户已存在')</script>");
          }
   	   String moblle = request.getParameter("moblle");
   	   if(moblle.equals(user.getMoblle())){
   		 pw.write("<script language='javascript'>alert('手机号已存在')</script>");
   	   }
   	 String identityCode = request.getParameter("identityCode");
 	   if(identityCode.equals(user.getIdentityCode())){
 		 pw.write("<script language='javascript'>alert('身份证号已存在')</script>");
 	   }
 	  String email = request.getParameter("email");
	   if(email.equals(user.getEmail())){
		 pw.write("<script language='javascript'>alert('邮箱格式不正确')</script>");
	   }
	   String password = request.getParameter("password");
	   if(email.equals(user.getEmail())){
		 pw.write("<script language='javascript'>alert('密码格式不正确')</script>");
	   }
	   String mima = request.getParameter("mima");
	   if(password!=mima){
		 pw.write("<script language='javascript'>alert('密码输入错误，请重新输入')</script>");
	   }
	   if(!userservice.add(user)){
		   pw.write("<script language='javascript'>alert('注册成功')</script>");
       request.getSession().setAttribute("user", user);
   	   }else{
   		  pw.write("<script language='javascript'>alert('注册失败')</script>");
          response.sendRedirect("Regist.JSP");
   	   }
	}
		
		

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
