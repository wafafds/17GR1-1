package com.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.entity.easybuy_news;
import com.easybuy.service.newsservice;
import com.easybuy.serviceimpl.newsserviceimpl;

public class newsservlte extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public newsservlte() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String opr = request.getParameter("opr");
		newsservice newsservice = new newsserviceimpl();
		if(opr.equals("insert")){
			
		}else if(opr.equals("update")){
			
			
		}else if(opr.equals("select")){
			String q = request.getParameter("id");
			int id = Integer.parseInt(q);
			easybuy_news newsById =null;
			try {
				 newsById = newsservice.getNewsById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("selectid", newsById);
			
		}else if(opr.equals("delete")){
			String q = request.getParameter("id");
			int id = Integer.parseInt(q);
			try {
				newsservice.deletenewsById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("Index.jsp");
			
		}
		
	}

	
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
