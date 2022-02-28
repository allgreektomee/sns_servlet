<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ page import="test.a.User" %>
	
<%                                                                                            
     User user = new User(); 
     user.setName(request.getParameter("name")); 
     user.setAge(Long.valueOf(request.getParameter("age"))); 
     user.setAddress(request.getParameter("address")); 
     
     out.println("<h3>request.getParameter </h3> <hr>");

     out.println("name out : " + user.getName() + " <br>");

     out.println("age out: " + user.getAge() + " <br>");

     out.println("add out : " + user.getAddress() + " <br><br>");
%>
	
	

     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	
</head>
<body>

   	<hr>
	name : <%= user.getName() %>  <br>
	age : <%= user.getAge() %>   <br>
	add : <%= user.getAddress() %>  <br>


</body>
</html>