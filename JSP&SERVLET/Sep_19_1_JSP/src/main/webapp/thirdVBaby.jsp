<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<hr>
	a:${param.a }<br>
	b:${param.b }<br>
	c:${cc }<br>
	d:${sessionScope.d } <br>
	e:${cookie.e.value } <br>
	<hr>
</body>
</html>