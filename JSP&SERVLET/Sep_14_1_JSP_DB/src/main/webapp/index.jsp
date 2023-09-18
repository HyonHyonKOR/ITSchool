<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/go.js"></script>
</head>
<body>
<a href="HomeController">
	<header>
	<h2>제리캣과 공부하는 CRUD😸</h2>
	</header>
	</a>
	<main>	
	  <jsp:include page="${cp}"></jsp:include>
	</main>
	<nav>
		<div><a href="AppleController">APPLE</a></div>
		<div><a href="#">BANANA</a></div>
		<div><a href="#">COCONUT</a></div>
		<div><a href="DBCController">DB CONNECT</a></div>	
	</nav>
	<script src="https://kit.fontawesome.com/459e14b80c.js" crossorigin="anonymous"></script>
</body>
</html>