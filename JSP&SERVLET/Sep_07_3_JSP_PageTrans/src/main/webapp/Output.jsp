<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.StringTokenizer"%>
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
	response.sendRedirect("test.jsp");
	request.setCharacterEncoding("UTF-8");
	String data = request.getParameter("data");
	
    String arr[] = data.split(",");
    
	int splitResult = 0;  
	for(String d : arr){
		try{
			splitResult += Integer.parseInt(d);
		}catch(Exception e){
			
		}
	}
	
	StringTokenizer st = new StringTokenizer(data,",");
	int tokenizerResult = 0;
	
	while(st.hasMoreTokens()){
		try{
			tokenizerResult += Integer.parseInt(st.nextToken());
		}catch(Exception e){
			
		}
	}
	
	%>
	
	<h1>split의 결과는 <%=splitResult%> 입니다.</h1>
	<h1>StringTokenizer의 결과는 <%=tokenizerResult%> 입니다.</h1>
</body>
</html>