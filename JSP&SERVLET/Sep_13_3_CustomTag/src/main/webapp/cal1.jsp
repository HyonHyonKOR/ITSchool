<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="CalcController" name="calcForm" onsubmit="return calcCheck()" >
     <h1>사칙 연산</h1>
     x: <input name="x" > 
     y: <input name="y" >
     <button>계산</button>
  </form>
</body>
</html>


<!--onsubmit="return calcCheck()"  --> 