<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>게시판</header>
<nav>
<a href=HomeController>홈</a>
<a href=CalcController>계산</a>
<a href=JSTLCController>JSTL-Core</a>
<a href=JSTLFController>JSTL-Format</a>
</nav>
<main>
<jsp:include page="${contentPage}"/> 
</main>
</body>
</html>