<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/ValidCheck.js"></script>
<script type="text/javascript" src="js/LoginValidCheck.js"></script>
<script type="text/javascript" src="js/Go.js"></script>
<title>홈페이지</title>
</head>
<body>
<div class="index-container">
<header class="index-header">
</header>
<nav class="index-nav">
<ul>
<li>1</li>
</ul>
</nav>
<main class="index-main">
<jsp:include page="${cp }"></jsp:include>
</main>
<aside class="index-aside">
 <div class="login-screen">
 <jsp:include page="${lp}"></jsp:include>
 </div>
</aside>
</div>
${r }
</body>
</html>