package com.imooc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.dbcp.pool.impl.GenericKeyedObjectPool.Config;

public class LoginFilter implements Filter{
   
	private FilterConfig config;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	 config = filterConfig;
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		String noLoginPaths = config.getInitParameter("noLoginPaths");
		

		
		String charset = config.getInitParameter("charset");
		if(charset==null){
			charset = "UTF-8";
		}
		request.setCharacterEncoding(charset);
		
		if(noLoginPaths!=null){
			String[] strArray = noLoginPaths.split(";");
			for (int i = 0; i < strArray.length; i++) {
				
				if(strArray[i]==null || "".equals(strArray[i]))continue;
				
				if(req.getRequestURI().indexOf(strArray[i])!=-1 ){
					chain.doFilter(request, response);
					return;
				}
			}
			
		}
		
		
//	 if(req.getRequestURI().indexOf("login.jsp")!=-1||req.getRequestURI().indexOf("LoginServlet")!=-1){
//		 chain.doFilter(request,response);
//		 return;
//	 }
		
		if(session.getAttribute("username")!=null){
			chain.doFilter(request,response);
		}else{
			resp.sendRedirect("login.jsp");
		}
	}

//	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
