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
    //<parameter>
    //html에서 만들어 낸 (a,b)
    //request에 저장
    //String or String[]
    //새로운 파라미터를 추가하는 것은 기존의 방식으로 불가
    //새로운 방식이 필요함

    //<attribute>
    //Java에서 만들어낸 값(c,d,e)
    //request에 저장
    //Object(객체)
    
    //이동
    //    first => second : 사용자가 뭔가 액션을 해서 넘어옴
    //          -request (요청)
    //    Second => Third : 그냥 넘어감
    //	        -redirect : 단순 자동이동 (점검중) 
    //          중간에 요청을 가로챔! 값은 안넘어감
    //			response.sendRedirect("Third.jsp");
    
    //          -forward : 자동이동 (값을 가지고 자동 이동)
    //          RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
    //          rd.forward(request,response);
    
    //          -include : 포함(Second 속에 Third가 포함되는)
    //              위치조절이 안됨(사용 비추)
    //          RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
    //          rd.include(request,response);
    
    request.setCharacterEncoding("UTF-8");
	int a = Integer.parseInt(request.getParameter("a"));
	int b = Integer.parseInt(request.getParameter("b"));
	
	//RequestDispatcher: 클라이언트로 들어온 요청을 원하는 쪽으로 넘기는 기능
	//호출된 페이지에서는 
	
	RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
	
	//setAttribute로 해결
	int c = a+ b;
	request.setAttribute("c", c);
	
	String d="ㅋ";
	request.setAttribute("d", d);
	
	Random e = new Random();
	request.setAttribute("e", e);
	
	rd.include(request, response);
%>

<h1>Second</h1>
<hr>
a: <%= a %> <br>
b: <%= b %> <br>
</body>
</html>