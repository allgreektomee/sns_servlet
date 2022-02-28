<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ page import="java.util.*" %>
<%@ page import="test.a.Calculator" %>

</head>
<body>

<h3>EL 표현식 리터럴 표현식 </h3>
<ul>
	<li> 문자열 : ${"test"} </li>
	<li>문자열 : ${'test'}</li>
	<li>정수 : ${20}</li>
	<li>부동소수점 : ${3.14}</li>
	<li>Boolean : ${true}</li>
	<li>null : ${null}</li>

</ul>
<br>

<h3>EL 표현식 데이터 출력</h3>

<%
    pageContext.setAttribute("scores", new int[]{90, 80, 70, 100});
%>
scores = ${scores[2]}
<br>

<h3>List</h3>
<%
    List<String> list = new LinkedList<>();
    list.add("가나");
    list.add("다라");
    list.add("마바");
 
    pageContext.setAttribute("list", list);
%>
<ul>
	<li> ${list[1]} </li>
</ul>
<br>

<h3>Map</h3>
<%
    Map<String, String> map = new HashMap<>();
    map.put("1", "a");
    map.put("2", "b");
    map.put("3", "c");
    pageContext.setAttribute("map", map);
%>

<ul>
	<li> ${map["1"]} </li>
</ul>

<br>
<h3>자바 객체 초기화 및 출력</h3>
<%
    pageContext.setAttribute("cal",new Calculator(1, 2, "*") );
%>
<ul>
	<li> ${cal.getNumber1()} , ${cal.getNumber2()}</li>
</ul>
<br>

<h3>EL 표현식의 연산자</h3>
<ul>
	<li> 10+20 = ${10+20} </li>
	<li> 10-2 = ${10-20} </li>
	<li> 10*20 = ${10*20} </li>
	<li> 10/20 = ${10/20}  </li>
	<li> 10 div 2 = ${10 div 2} </li>
	<li> 10 % 20 = ${10 % 20} </li>
	<li> 10 mod 20 = ${10 mod 20} </li>
</ul>
<br>

<h3>EL 표현식의 연산자</h3>
<ul>
	<li>and ${true && false} </li>
	<li>   ${true and false} </li>
	<li>or ${false || true} </li>
	<li>   ${false or true} </li>
	<li>not ${not true} </li>
	<li>   ${!true} </li>
	
</ul>
<br>

</body>
</html>