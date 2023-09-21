<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="kr">
  <head>
    <link rel="stylesheet" href="css/style.css" />
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script type="text/javascript" src="js/Go.js"></script>
    <script type="text/javascript" src="js/ValidCheck.js"></script>
    <script type="text/javascript" src="js/UpdateValidCheck.js"></script>
    <title>정보 수정</title>
  </head>
  <body>
    <div class="menu">
      <span>회원정보 수정</span>
    </div>
    <header>
      <h1>어서오세요!</h1>
    </header>
    <main>
      <form
        name="update"
        class="update-form"
        action="UpdateController"
        method="post"
        enctype="multipart/form-data"
        onsubmit="return checkUpdateValid();"
      >
        <div class="join-form__box">
          <span>아이디</span><br />
          <input
            name="m_id"
            maxlength="20"
            readonly="readonly"
            value="${sessionScope.member.m_id }"
          />
        </div>
          <div class="join-form__box">
          <span>비밀번호</span><br />
          <input
            required
            type="password"
            name="m_password"
            maxlength="20"
            placeholder="문자,숫자,특수문자 포함(6~20자)"
            value="${sessionScope.member.m_password }"
          />
         </div>
           <div class="join-form__box">
          <span>비밀번호 확인</span><br />
          <input
          	required
            type="password"
            name="m_password2"
            maxlength="20"
            placeholder="같은 비밀번호를 입력해주세요"
            value="${sessionScope.member.m_password }"
          />
        </div>
        <div class="join-form__box">
          <span>이름</span><br />
          <input
          	required
            name="m_name"
            maxlength="20"
            placeholder="한글 및 영어(2~20자)"
            value="${sessionScope.member.m_name}" 
          />
        </div>
        <div class="join-form__box">
          <span>핸드폰 번호</span><br />
          <input
          	required
            name="m_phonenum"
            maxlength="11"
            placeholder="-없이 입력(01012345678)"
            value="${sessionScope.member.m_phonenum}" 
          />
        </div> 
        <div class="join-form__box-select">
          <span>생년월일</span><br />
          <div>
          <select required name="m_birthYear">
          	<option>
          		<fmt:formatDate
          		value="${sessionScope.member.m_birthday }"
          		pattern="yyyy"
          		/>
          	</option>
          	<c:forEach var="y" begin="${cy-100 }" end="${cy}" step="1">
			  <option>${y } </option>
			</c:forEach>
          </select>년
          <select required name="m_birthMonth">
          	<option>
          		<fmt:formatDate
          		value="${sessionScope.member.m_birthday }"
          		pattern="M"
          		/>
            </option>
			<c:forEach var="m" begin="1" end="12">
			  <option>${m } </option>
			</c:forEach>	
          </select>월 
          <select required name="m_birthDay">
          	<option>
          		<fmt:formatDate
          		value="${sessionScope.member.m_birthday }"
          		pattern="d"
          		/>
            </option>
			<c:forEach var="d" begin="1" end="31">
			  <option>${d } </option>
			</c:forEach>
          </select>일                       
          </div>
        </div>
        <div class="box">
          <span>사진</span><br />
          <img src="img/${sessionScope.member.m_photo }" id="memberUpdatePhoto"/><br />
          <input name="m_photo" type="file" accept=".jpg" /><br />
          <span id="size">10mb 이하의 jpg 파일만 가능합니다.</span>
        </div>
        <div class="box">
          <button>정보 수정 하기</button>
         <button type="button" onclick="">탈퇴 하기</button>
      </div>
      </form>  
    </main>
    ${r }
  </body>
</html>