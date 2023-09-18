<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
 	<h1>사과 조회 결과</h1>
 	<form action="AppleInfoController" method="post">
 	지역:<input name="a_location" value="${apple.a_location }" readonly="readonly"><p>
 	색깔:<input name="a_color" value="${apple.a_color }"><p>
 	맛:<input name="a_flavor" value="${apple.a_flavor }"><p>
 	가격:<input name="a_price" value="${apple.a_price }"><p>
 	소개:<textarea name="a_introduce">${apple.a_introduce }</textarea><p>
 	<button>변경</button> 	
 	</form>
 	<button onclick="deleteApple(`${apple.a_location }`);">삭제</button> 
 	<button onclick="history.back();">뒤로 가기</button> 
</div>
</body>
</html>