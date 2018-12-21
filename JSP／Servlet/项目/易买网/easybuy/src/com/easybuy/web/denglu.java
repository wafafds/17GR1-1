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
import com.easybuy.serviceimpl.userserviceimpl;

public class denglu extends HttpServlet {

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

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String userName = request.getParameter("userName");
		if(userName==null){
			pw.write("<script language='javascript'>alert('�û�����Ϊ��')</script>");
		}
		String password = request.getParameter("password");
		if(password==null){
			pw.write("<script language='javascript'>alert('���벻��Ϊ��')</script>");
		}
		userdao userdao = new userdaoimpl();
		easybuy_user user = userdao.denglu(userName, password);
		if((user.getPassword().equals(password))){
			request.getSession().setAttribute("loginUser", user);
			 pw.write("<script language='javascript'>alert('��½�ɹ�')</script>");
		}else{
			 pw.write("<script language='javascript'>alert('��½ʧ��')</script>");
			 response.sendRedirect("Login.JSP");
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
		PrintWriter pw = response.getWriter();
		easybuy_user  user=(easybuy_user )request.getSession().getAttribute("loginUser");
         request.getSession().removeAttribute("loginUser");
         // ������ﳵ
         request.getSession().removeAttribute("cart");
         request.getSession().removeAttribute("cart2");
         pw.write("<script language='javascript'>alert('ע���ɹ�')</script>");
     response.sendRedirect("Login.JSP");
 }
		
	}


