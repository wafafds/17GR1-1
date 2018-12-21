package com.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.entity.easybuy_product;
import com.easybuy.service.productservice;
import com.easybuy.serviceimpl.productserviceimpl;

public class productservlte extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public productservlte() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
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

		response.setContentType("text/html");
		String orl = request.getParameter("orl");
		productservice productservice= new productserviceimpl();
		if(orl.equals("select")){
			List<easybuy_product> list = productservice.selectproduct();
			request.setAttribute("list", list);
			
		}else if(orl.equals("update")){
			easybuy_product product = new easybuy_product();
			Integer updateproduct =null;
			try {
				 updateproduct = productservice.updateproduct(product);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String id = request.getParameter("id");
			int i = Integer.parseInt(id);
			product.setId(i);
			product.setName(request.getParameter("name"));
			product.setDescription(request.getParameter("description"));
   		    String price1 = request.getParameter("price");
		    int price = Integer.parseInt(price1);
			product.setPrice(price);
			String stock1 = request.getParameter("stock");
			int stock = Integer.parseInt(stock1);
			product.setStock(stock);
			String categoryLevelq = request.getParameter("categoryLevel1");
			int categoryLevel1 = Integer.parseInt(categoryLevelq);
			product.setStock(categoryLevel1);
			String categoryLevel2q = request.getParameter("categoryLevel2");
			int categoryLevel2 = Integer.parseInt(categoryLevel2q);
			product.setStock(categoryLevel2);
			product.setCategoryLevel3(request.getParameter("categoryLevel3"));
			request.setAttribute("updatelist", updateproduct);
		}else if(orl.equals("delete")){
			String q = request.getParameter("id");
			int id= Integer.parseInt(q);
			Integer productsericeById = null;
			try {
				 productsericeById = productservice.deleteProductsericeById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("Index,jsp");
		}else if(orl.equals("insert")){
			easybuy_product product = null;
			Integer addproduct = null;
			try {
				 addproduct = productservice.addproduct(product);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
