<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="apple-reg">
<h1>사과 입력</h1>
<form action="AppleRegController" class="appleRegForm" name="appleRegForm" method="post" name="insertForm" >
<input required  placeholder="도시 이름을 입력해주세요" type="text" name="a_location" max="10"><br />
<input placeholder="사과색 입력해주세요" required type="text" name="a_color" max="10"><br />
<input placeholder="사과맛을 입력해주세요" required type="text" name="a_flavor" max="10"><br />
<input placeholder="사과의 가격을 입력해주세요" required type="text" name="a_price" maxlength="5"><br />
<textarea placeholder="사과의 소개를 입력해주세요" required name="a_introduce" maxlength="100"></textarea><br />
<button type="submit">저장</button>
</form>
</div>
</body>
</html>