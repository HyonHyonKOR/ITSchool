<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원가입</title>
  </head>
  <body>
    <main class="signup-container">
       <header>
       <h1>어서와 코딩은 처음이지?!</h1>
       </header>
      <form
        action="SignUpController"
        name="signUpForm"
        class="signup-form"
        method="post"
        enctype="multipart/form-data"
        onsubmit="return checkSignUpValid();"
      >
        <div class="signup-form__box">
          <input
            type="text"
            name="m_id"
            maxlength="10"
            placeholder="아이디"
          />
        </div>
          <div class="signup-form__box">
          <input
            type="password"
            name="m_pw"
            maxlength="12"
            placeholder="비밀번호"
          />
         </div>
           <div class="signup-form__box">
          <input
            type="password"
            name="m_pw2"
            maxlength="12"
            placeholder="비밀번호 확인"
          />
        </div>
        <div class="signup-form__box">
          <input
            type="text"
            name="m_name"
            maxlength="10"
            placeholder="이름"
          />
        </div>
        <div class="signup-form__box">
          <input
            type="text"
            name="m_phone"
            maxlength="11"
            placeholder="핸드폰 번호(- 제외)"
          />
        </div>
        <div class="signup-form__box box_select">
          <div>
          <select required name="m_birthYear">
          	<c:forEach var="y" begin="${cy-100 }" end="${cy}" step="1">
			  <option>${y } </option>
			</c:forEach>
          </select>
          <select required name="m_birthMonth">
			<c:forEach var="m" begin="1" end="12">
			  <option>${m } </option>
			</c:forEach>	
          </select> 
          <select required name="m_birthDay">
			<c:forEach var="d" begin="1" end="31">
			  <option>${d } </option>
			</c:forEach>
          </select>                       
          </div>
        </div>
        <div class="signup-form__box box-photo">
          <input name="m_photo" type="file" accept="image/png,image/jpeg,image/gif,image/webp">
           <span id="size">png,jpeg,gif,webp(10mb 이하)</span>
        </div>
       
        <div class="box">
          <button>회원 가입 하기</button>
        </div>
      </form>
    </main>
  </body>
</html>


