<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
  <div class="welcome-container">
   	<div class="welcome__column">
 	  <div class="welcome__column-photo">
 	  	<img src="img/${sessionScope.loginMember.m_photo }">
 	  </div>
 	  <div class="welcome__column-text">
 	  	<span>${sessionScope.loginMember.m_name }님</span>
 	  	<span >${sessionScope.loginMember.m_id }</span>
 	  </div>
   	</div>
   	<div class="welcome__column">
   		<span class="welcome__column-message">
   		  ${sessionScope.loginMember.m_name }님 환영합니다.
   		</span>
   	</div>
	<div class="btns-set welcome-btns">
	<button type="button" onclick="goMemberInfo();">회원정보</button>
	<button type="button" onclick="goLogout();">로그아웃</button>
	</div> 
  </div>	       	  
</body>
</html>