<%@page import="com.hyon.db.manager.HyonDBManager"%>
<%@page import="java.sql.Connection"%>
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
		//기존: DriverManager.getConnection()을 실행하는 순간
		// 관련된 모든 작업을 해서 Connection()
	
		//커넥션풀: 미리 Connection객체 x 100개 만들어놓고
		// 클라이언트가 요청하면 => 만들어둔거 하나 주면 됨 => 빠름
	
		//설정 - context.xml
		//Servers - context.xml(이쪽은 건들지 말것 )
		//   저걸 건들면... 워크스페이스 안에 있는 모~~~든 프로젝트에 다 영향!!
		//   프로젝트가 다르다 ? => DB서버가 다를 확률 있음!!!
		
		//우리가 만든 context.xml을 각 프로젝트의 META-INF 폴더에 넣자!
	
		String result = "DB 연결 실패!!!";
		
		Connection con = null;
		try{
			con = HyonDBManager.connect("hyonPool");
			result ="DB 연결 성공~~~";
		}catch(Exception e){
			e.printStackTrace();
		}
		HyonDBManager.close(con, null, null);
	%>
	<h1 class=main-text><%=result %><i class="fa-solid fa-music fa-bounce"></i></h1>
</body>
</html>