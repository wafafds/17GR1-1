package com.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.entity.easybuy_news;
import com.easybuy.entity.easybuy_product;
import com.easybuy.service.newsservice;
import com.easybuy.service.productservice;
import com.easybuy.serviceimpl.newsserviceimpl;
import com.easybuy.serviceimpl.productserviceimpl;

public class zsgc extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public zsgc() {
		
		
		
		
		
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void selectnews(HttpServletRequest request, HttpServletResponse response){
		newsservice newsservice = new newsserviceimpl();
		easybuy_news news = new easybuy_news();
	     String opr = request.getParameter("opr");
	     if(opr.equals("select")){
	    	 String id = request.getParameter("id");
	    	 easybuy_news newsById =null;
	    	 try {
				 newsById = newsservice.getNewsById(Integer.parseInt(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	 request.setAttribute("id", newsById);
	     }
	}
public void updateproduct(HttpServletRequest request, HttpServletResponse response){
	productservice productservice = new productserviceimpl();
	
	
	
	
}
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
