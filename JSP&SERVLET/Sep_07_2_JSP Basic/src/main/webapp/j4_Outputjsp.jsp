<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body{
height:100vh;
display:flex;
flex-direction:column;
justify-content: center;
align-content:center;
}

</style>
<body>
	 <%
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		int result = 
		Integer.parseInt(request.getParameter("x"))+		
		Integer.parseInt(request.getParameter("y"));
	 %>
	 <h1 align="center">
		입력하신 결과는 <%=name%> , <%=result %>입니다. 
	</h1>
</body>
</html>