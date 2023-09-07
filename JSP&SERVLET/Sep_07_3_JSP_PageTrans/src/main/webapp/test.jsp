<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>서버 점검 중</h1>
	<%
		//입력페이지(input.html) => 출력페이지(output.jsp)
	    //				  점검중(text.jsp)로 보내자!
	
	    //페이지 이동
	    // 	   수동(사용자가 뭔가 액션을 하면 이동) - 요청
	    //		 -<a></a> : 클릭하면 이동
	    //       -<form> + <button> : 버튼 클릭 or <input>에서 엔터치면 이동
	    //		 -JavaScript(location.href) : 이벤트를 지정할 수 있음
	    //	   자동(사용자의 액션과는 상관없이)
	    //		 - redirect
	    //			 output.jsp의 <body> 부분 제일 위에(자바코드 안에서)
	    //			 response.sendRedirect("test.jsp");
	%>
</body>
</html>