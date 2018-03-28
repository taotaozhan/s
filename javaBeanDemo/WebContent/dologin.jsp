<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
   <jsp:useBean id="myUser"   class="org.lanqiao.Users" scope="page"></jsp:useBean>
   <jsp:setProperty property="*" name="myUser"/>
   <h1>Property 元素</h1>
      <%=myUser.getUsername() %><br>
      <%=myUser.getPassword() %><br>
</body>
</html>