<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="test.reg">
        과목명 : <input name="t_title"> <p>
       <select name="t_y">
         <c:forEach var="y" begin="2023" end="2033">
           <option>${y }</option>
          </c:forEach>    
       </select>
       
       <select name="t_m">
        <c:forEach var="m" begin="1" end="12">  
           <option>${m }</option>
        </c:forEach>         
       </select>
      
       <select name="t_d">
        <c:forEach var="d" begin="1" end="31"> 
           <option>${d }</option>
        </c:forEach>              
       </select>
       <button>전송</button>
    </form>
    <hr>
    <c:forEach var="t" items="${tests }"> 
       ${t.t_title } -
       <fmt:formatDate value="${t.t_when }" type="date" dateStyle="long"/><p>
    </c:forEach>
    ${r }
</body>
</html>