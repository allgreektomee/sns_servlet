<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="calc" class="test.a.Calculator" />
<jsp:setProperty name="calc" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useBean test JSP</title>
</head>
<body>
	<h2>계산 결과-useBean test JSP</h2>
	<hr>
	<jsp:getProperty name="calc" property="number1"/>
	<jsp:getProperty name="calc" property="op"/>
	<jsp:getProperty name="calc" property="number2"/>
	
	결과: ${calc.getResultNumber()}<!-- el 표현 -->
	
</body>
</html>