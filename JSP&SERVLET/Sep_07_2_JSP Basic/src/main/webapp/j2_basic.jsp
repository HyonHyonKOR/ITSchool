<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		랜덤한 숫자 (1~100 사이 정수)를 넣었을 때 , 짝인지 홀인지 알려주는 기능
		뽑은 숫자와 홀짝 여부를 웹페이지에 출력
	 --%>
	 <%
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("number"));
		String result ="";
		
		if(num%2==1) result = "홀수";
		else result = "짝수";
	 %>
	 <h1 align="center"> 홀짝 판별 </h1>
	<div align="center">
		<span>입력하신 숫자 <%=num%>은 <%=result %>입니다. </span>
	</div>
	 
	 
	 
</body>
</html>