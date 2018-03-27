<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1> application 内置对象</h1>
     <%  
     application.setAttribute("city", "北京");
     application.setAttribute("name", "zhangtao");
     application.setAttribute("password", "123");
     %>
     application获取属性的名字:<%=application.getAttribute("city") %><br>
     <%  
     Enumeration em = application.getAttributeNames();
     while(em.hasMoreElements()){
    	 out.print(em.nextElement()+"&nbsp;&nbsp;");
     }
     %><br>
     版本号<%=application.getServerInfo() %>
</body>
</html>