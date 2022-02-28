<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
int number1 = Integer.parseInt(request.getParameter("number1"));
int number2 = Integer.parseInt(request.getParameter("number2"));

long result = 0;

switch(request.getParameter("op")) {
	case "+": 
		result = number1+number2;
		break;
	case "-": 
		result = number1-number2;
		break;
	case "/": result = number1/number2;
		break;
	case "*": result = number1*number2;
		break;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기 JSP</title>
</head>
<body>
	<h2>계산 결과-JSP</h2>
	<hr>
	결과: <%=result %>
</body>
</html>