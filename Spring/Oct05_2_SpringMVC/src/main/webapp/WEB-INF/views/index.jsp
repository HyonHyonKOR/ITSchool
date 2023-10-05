<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/index.css">
<script type="text/javascript" src="resources/js/index.js"></script>
</head>
<body>
   View(V) -
   	  JSP : .html or .jsp
   	  Spring : .jsp
   	  Spring Boot : .html
   	  
   	  Spring 내에서 쓰는 자원파일들 (css, js, 그림, ...)
   	     webapp- resources / ... (경로)
  <hr>
  <form action="calculate.do" method="post">  
   <input type="text" name="n"><p>
   <input type="text" name="x"><p>
   <input type="text" name="y"><p>
   <button>보내기</button>
  </form>
  <hr>
  <c:if test="${r != null }"> 계산 결과 "${r }"  </c:if>
</body>
</html>