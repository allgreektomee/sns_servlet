<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:out value="${'Welcome to javaTpoint'}"/>


<c:set var="Income" scope="session" value="${4000*4}"/>
<c:out value="${Income}"/>



<c:catch var ="catchtheException">
   <% int x = 2/0;%>
</c:catch>

<c:if test = "${catchtheException != null}">
   <p>The type of exception is : ${catchtheException} <br />
   There is an exception: ${catchtheException.message}</p>
</c:if>


<c:if test="${income > 8000}">
   <p>My income is: <c:out value="${income}"/><p>
</c:if>


<c:choose>
    <c:when test="${income <= 1000}">
       Income is not good.
    </c:when>
    <c:when test="${income > 10000}">
        Income is very good.
    </c:when>
    <c:otherwise>
       Income is undetermined...
    </c:otherwise>
</c:choose>



<c:forEach var="j" begin="1" end="3">
   Item <c:out value="${j}"/><p>
</c:forEach>



<c:forTokens items="Rahul-Nakul-Rajesh" delims="-" var="name">
   <c:out value="${name}"/><p>
</c:forTokens>



<c:url value="userTest2.jsp" var="url">

  <c:param name="name" value="하하" />

  <c:param name="age" value="36" />
  
  <c:param name="address" value="address test" />

</c:url>

<a href="${url}"> 페이지</a>


<%-- <c:redirect url="https://naver.com"/> --%>

<c:url value="userTest.jsp"/>


<c:set var="String" value="Hello world"/>

</body>
</html>