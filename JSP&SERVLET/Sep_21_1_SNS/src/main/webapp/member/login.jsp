<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
   <form name="form"
         class="login-form-container"
	      action="LoginController" 
	      method="post"
	      onsubmit="return checkLoginValid();"
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
 		required
 	    maxlength="20"
 	    >  	  
	</div>	
	<div class ="login-input-container">
   <label
   class="login-label"
   for="loginpassword">
   <i class="fa-solid fa-lock"></i>
   </label>   
		<input 
		required
		type="password" 
		id="loginpassword"
		maxlength="20">
	</div>
	<div class="btns-set">
	<button type="button" onclick="join();">회원가입</button>
	<button>로그인</button>
	</div>        	  
   </form>
   <script src="https://kit.fontawesome.com/459e14b80c.js" crossorigin="anonymous"></script>
</body>
</html>