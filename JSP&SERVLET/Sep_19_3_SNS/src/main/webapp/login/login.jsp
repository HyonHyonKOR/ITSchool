<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class=login-component>
	<form class=login-component__form name=memberloginform action="LoginController" method="post">
		<div class= "login-component__form-blocks">
		<span class="login-component__form-text">id</span>
		<input required class="login-component__form-input"  name="m_id" placeholder=아이디 value="${cookie.lastLoginID.value}"><p>
		</div>
		<div class= "login-component__form-blocks">
		<span class="login-component__form-text">pw</span>
		<input required class="login-component__form-input"  name="m_password" placeholder=비밀번호><p>
		</div>
		<div class="login-component__form-buttons">
		<button type="button" onclick="goToJoinPage();">회원가입</button>
		<button>로그인</button>
		</div>
	</form>
	</div>
</body>
</html>