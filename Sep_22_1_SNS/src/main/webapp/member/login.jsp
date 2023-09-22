<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
   <form action="LoginController"
         name="loginForm"
         class="login-form-container"
	     method="post"
	     onsubmit="return checkloginValid();"
	      >
	<div class ="login-input-container">
    <label 
    class="login-label"
    for="loginid">     
    <i class="fa-regular fa-user"></i>    
    </label>
 	    <input 
 	    type="text"
 	    id="loginid"
 	    name="m_id"
 	    maxlength="10"
 	    >  	  
	</div>	
	<div class ="login-input-container">
   <label
   class="login-label"
   for="loginpassword">
   <i class="fa-solid fa-lock"></i>
   </label>   
		<input 
		type="password"
		name="m_pw" 
		id="loginpassword"
		maxlength="12">
	</div>
	<div class="btns-set">
	<button type="button" onclick="goSignUp();">회원가입</button>
	<button>로그인</button>
	</div>        	  
   </form>
</body>
</html>