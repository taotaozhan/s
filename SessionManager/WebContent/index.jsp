<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
  在线人数：${userNumber };
   <% 
   ArrayList<org.imooc.entliy.User>  userList =  (ArrayList<org.imooc.entliy.User>)request.getServletContext().getAttribute("userList"); 
   if(userList!=null){
       for(int i = 0 ; i < userList.size() ; i++){
    	   org.imooc.entliy.User user = userList.get(i);
   %>
    IP:<%=user.getIpString() %>,FirstTime:<%=user.getFirstimeString() %>,SessionId:<%=user.getSessionIdString() %> <br/>
    <%}} %>
</body>
</html>