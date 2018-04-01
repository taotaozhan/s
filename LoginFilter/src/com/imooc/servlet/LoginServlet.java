package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String username = request.getParameter("username");
		  String  password = request.getParameter("password");
		 System.out.println(username);
		 //通过校验
		 if("admin".equals(username)&&"admin".equals(password)){
			 HttpSession session = request.getSession();
			 session.setAttribute("username", username);
			 response.sendRedirect(request.getContextPath()+"/sucess.jsp");
		 }else {
			//校验失败
				response.sendRedirect(request.getContextPath()+"/fail.jsp");
		}
		
	}

}
