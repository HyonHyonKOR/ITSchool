<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>단위 변환</h1>
	<!--  
		단위변환
		form안에 숫자 입력할 수 있는 input 1개
		select을 활용해서
			cm -> inch
			제곱미터 -> 평
			섭씨 -> 화씨
			mi/h -> km/h
			의 선택지 중 하나를 고르고
		버튼 누르면 => unit.convert로 GET방식 요청
		    <form action="unit.convert">
	 -->
	 <form action="unit.convert">
	  <input type="number" name="beforeNum" />
      <select name="convertUnit">
        <option value="length">cm ➜ inch</option>
        <option value="area">㎡ ➜ 평</option>
        <option value="temparature">°C ➜ °F</option>
        <option value="speed">mi/h ➜ km/h</option>
      </select><p>
      <button>결과 보기</button>
    </form>
</body>
</html>