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
<%
   //파라미터 읽기 String->Integer->Int
   int a = Integer.parseInt(request.getParameter("a"));
   int b = Integer.parseInt(request.getParameter("b"));

   //어트리뷰트 읽기
   Object ccc= request.getAttribute("c");
   Integer cc = (Integer)ccc;
   int c = cc.intValue();
   
   String d = (String) request.getAttribute("d");
   Random e = (Random) request.getAttribute("e");
%>

	<h1>Third</h1>
	a : <%=a %> <br>
	b : <%=b %> <br>
	c : <%=c %> <br>
	d : <%=d %> <br>
	e : <%=e.nextInt(100)+1 %> <br>
</body>
</html>