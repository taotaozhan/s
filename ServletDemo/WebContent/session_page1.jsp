<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@page import="java.util.*,java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
  <h1>session对象</h1>
  <hr>
  <%
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
  Date d = new Date(session.getCreationTime());
  session.setAttribute("username", "admin"); 
  session.setAttribute("password", "123456");
  session.setAttribute("age", 20);
   out.print(d);
  %>
</body>
</html>