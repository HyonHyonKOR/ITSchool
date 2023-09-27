<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="fruit" items="${fruitsxml }">
		${fruit.f_name} - ${fruit.f_price} <br>
	</c:forEach>
	<br>
	<c:forEach var="fruit" items="${fruitsjson }">
		${fruit.f_name} - ${fruit.f_price} <br>
	</c:forEach>
</body>
</html>