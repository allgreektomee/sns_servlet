<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<H3>
	1. JSP 주석
	<!-- 주석 --> : HTML 주석: 화면에서는 안보이고 소스 보기에는 보임 
	<%-- 주석 --%>  : JSP 주석: 화면과 소스 보기에서 보이지 않음
</H3>

<!-- 선언  -->
<%!
	String[] members = { "테스트1", "테스트2", "테스트3", "테스트4" };
	int num1 = 10;

	int calc(int num2) {
		return num1 + num2;
	}
%>
<!--참조  -->
<h3>
	2. calc(10) 메서드 실행 결과:
	<%=calc(10)%>  
</h3>

</body>
</html>