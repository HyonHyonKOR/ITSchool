<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/Go.js"></script>
<script type="text/javascript" src="js/ValidCheck.js"></script>
<script type="text/javascript" src="js/MemberValidCheck.js"></script>
<title>홈페이지</title>
</head>
<body>
  <div class="grid-container">
	<header class="grid-header">
		<h1 class="index-header__title">제리캣과 함께하는 CRUD2</h1>
	</header>
	<nav class="grid-nav"></nav>
	<main class="grid-main">
		 <jsp:include page="${cp}"></jsp:include>
	</main>
	<aside class="grid-aside">
		<div class="login-container">
		  <jsp:include page="${lp}"></jsp:include> 
		</div>
	</aside>
 </div>	
 ${r }  
</body>
</html>