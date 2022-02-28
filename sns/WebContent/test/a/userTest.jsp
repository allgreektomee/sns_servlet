<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="User" class="test.a.User" scope="request"/> 

<!--  -->

<jsp:setProperty name="User" property="name" value="park"/> 
<jsp:setProperty name="User" property="age" value="36"/> 
<jsp:setProperty name="User" property="address" value="seoul"/>  

<%--

<jsp:setProperty name="User" property="name" param="pname"/> 
<jsp:setProperty name="User" property="age" param="page"/> 
<jsp:setProperty name="User" property="address" param="padd" />  

--%>


<!--
<jsp:setProperty name="User" property="*" />   
  -->
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	
</head>
<body>

	이름 : <jsp:getProperty name="User" property="name"/><br> 
	나이 : <jsp:getProperty name="User" property="age"/><br> 
	주소 : <jsp:getProperty name="User" property="address"/><br> 


</body>
</html>