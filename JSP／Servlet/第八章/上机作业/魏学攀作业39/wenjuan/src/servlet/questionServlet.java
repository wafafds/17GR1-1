package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.question;

public class questionServlet extends HttpServlet{
	public class QuestionServlet extends HttpServlet {
	    public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {        
	        String name = request.getParameter("username");      
	        String city = request.getParameter("city");        
	        String[] languages = request.getParameterValues("language");       
	        question question = new question();
	        question.setUsername(name);
	        question.setCity(city);
	        question.setLanguages(java.util.Arrays.asList(languages));
	       
	        request.setAttribute("question", question);
	        request.getRequestDispatcher("/queSuccess.jsp")
	               .forward(request, response);
	    }

	    public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        request.setCharacterEncoding("UTF-8");
	        this.doGet(request, response);
	    }

	}
}
