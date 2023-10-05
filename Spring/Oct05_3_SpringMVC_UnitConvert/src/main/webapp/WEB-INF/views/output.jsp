<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1 class=${param.convertUnit }>단위 변환</h1>
	
	<!-- 
		h1태그에 변환결과라는 글자를 표현
		
		변환전 숫자값 변환전 단위 -> 변환후 숫자값 변환후 단위를 출력

		+ h1태그의 글자의 색을 
		    길이 : 빨간색
		    넓이  : 초록색
		    온도  : 파란색
		    속도 : 핑크색으로 바꿔서 출력
	 -->
	
	
    ${cr.beforeNum } ${cr.beforeUnit} -> ${cr.convertedNum }${cr.convertedUnit}
	 
</body>
</html>