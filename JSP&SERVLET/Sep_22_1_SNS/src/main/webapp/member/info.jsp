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
    <main class="update-container">
      <form
        action="MemberInfoController"
        name="signUpForm"
        class="update-form"
        method="post"
        enctype="multipart/form-data"
        onsubmit="return checkUpdateValid();"
      > 
      	<header class="update-header">
      	<img src="img/${sessionScope.loginMember.m_photo }">
      	<span>${sessionScope.loginMember.m_name}님의 회원정보</span>
      	</header>   
        <div class="update-form__box">
          <input
            type="text"
            name="m_id"
            maxlength="10"
            value="${sessionScope.loginMember.m_id}"
            readonly="readonly"
          />
        </div>
          <div class="update-form__box">
          <input
            type="password"
            name="m_pw"
            maxlength="12"
            placeholder="비밀번호"
            value="${sessionScope.loginMember.m_pw}"
          />
         </div>
           <div class="update-form__box">
          <input
            type="password"
            name="m_pw2"
            maxlength="12"
            placeholder="비밀번호 확인"
            value="${sessionScope.loginMember.m_pw}"
          />
        </div>
        <div class="update-form__box">
          <input
            type="text"
            name="m_name"
            maxlength="10"
            placeholder="이름"
            value="${sessionScope.loginMember.m_name}"
          />
        </div>
        <div class="update-form__box">
          <input
            type="text"
            name="m_phone"
            maxlength="11"
            placeholder="핸드폰 번호(- 제외)"
            value="${sessionScope.loginMember.m_phone}"
          />
        </div>
        <div class="update-form__box box_select">
          <div>
          <select name="m_birthYear">
          	<option>
			 <fmt:formatDate value="${sessionScope.loginMember.m_birthday }" pattern="yyyy"/>
			</option>
          	<c:forEach var="y" begin="${cy-100 }" end="${cy}" step="1">
			  <option>${y } </option>
			</c:forEach>
          </select>
          <select name="m_birthMonth">
            <option>
			 <fmt:formatDate value="${sessionScope.loginMember.m_birthday }" pattern="M"/>
			</option>
			<c:forEach var="m" begin="1" end="12">
			  <option>${m } </option>
			</c:forEach>	
          </select> 
          <select name="m_birthDay">
            <option>
			 <fmt:formatDate value="${sessionScope.loginMember.m_birthday }" pattern="d"/>
			</option>
			<c:forEach var="d" begin="1" end="31">
			  <option>${d } </option>
			</c:forEach>
          </select>                       
          </div>
        </div> 
        <div class="update-form__box box-photo">
          <input name="m_photo" type="file" accept="image/png,image/jpeg,image/gif,image/webp">
           <span id="size">png,jpeg,gif,webp(10mb 이하)</span>
        </div>
        <div class="box">
          <button>회원정보 수정</button>
          <button type="button" onclick="goDeletePage();">회원 탈퇴</button>
        </div>
      </form>
    </main>
  </body>
</html>