<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="login-success">
   	<div class="login-success__column">
 	  <div class="login-success__column-photo">
 	  	<img src="img/${sessionScope.member.m_photo }">
 	  </div>
 	  <div class="login-success__column-text">
 	  	<span>${sessionScope.member.m_name }님</span>
 	  	<span>${sessionScope.member.m_id }</span>
 	  </div>
   	</div>
   	<div class="login-success__column">
   		<span class="login-success__column-welcome">
   		  ${sessionScope.member.m_name }님 환영합니다.
   		</span>
   	</div>
   	<div class="login-success__column">
   		<form class= "login-success__btns" name="lsform">
   			<button>정보수정</button>
   			<button>로그아웃</button>
   		</form>
   	</div>   
   </div>
</body>
</html>