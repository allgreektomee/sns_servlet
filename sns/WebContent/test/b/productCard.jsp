<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
    box-sizing: border-box;
  }
  body {
    background-color:#eee;
    font-size:16px;
  }
  
  
  .card {
    background-color:#fff;
    box-shadow:0px 1px 5px #222;
  }
  .card > header {
    font-size:1.5rem;
    padding:0.5rem;
  }
  .card > p {
    padding:0.5rem;
    line-height:1.6em;
  }
  img {
    max-width:100%;
  }

  #wrapper{
    display:grid;
    
    /* 열 또는 행의 개수를 미리 지정하지 않고 설정된 너비가 허용하는 한 최대한 셀을 그린다 */
    grid-template-columns:repeat(auto-fit, minmax(320px, 1fr));
    grid-gap:1rem;
  }
</style>
</head>
<body>
  <div id="wrapper">
    
	
	<c:forEach var="p" varStatus="i" items="${products}">
		<div class="card">
      		<header>
        		<h3>${i.count} ${p.name}</h3>
      		</header>
	      	<figure>
	      		<a href="/pcontrol?action=info&id=${p.id}">
	      			<img src="https://via.placeholder.com/600x600">
	      		</a>
	        	
	      	</figure>
	      <p>${p.price}</p>
	    </div>
	</c:forEach>
           
  </div>
</body>
</html>