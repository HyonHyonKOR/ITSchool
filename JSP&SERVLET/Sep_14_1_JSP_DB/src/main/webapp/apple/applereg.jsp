<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class>
<h1>사과 입력</h1>
<form action="AppleRegController" name="appleRegForm" method="post" name="insertForm" >
도시 이름: <input required  type="text" name="a_location" max="10"><br />
색깔: <input required type="text" name="a_color" max="10"><br />
맛: <input required type="text" name="a_flavor" max="10"><br />
가격:<input required type="number" name="a_price" maxlength="5"><br />
소개:<textarea required name="a_introduce" maxlength="100"></textarea><br />
<button type="submit">저장</button>
</form>
</div>
</body>
</html>