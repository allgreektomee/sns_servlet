<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>include.jsp 실행결과 </h3>
<%@ include file="basic.jsp"%> <!-- 상대경로 설정  -->
<%=java.time.LocalDateTime.now()%>
</body>
</html>
