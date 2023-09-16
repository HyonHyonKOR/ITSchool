<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="table">
	 <table>
      <thead>
      <tr>
        <a href="AppleRegController">등록</a>
        </tr>
        <tr>
          <th>지역</th>
          <th>가격</th>
	    </tr>
	    <tbody>
		<c:forEach var="apple" begin="0" end="4" items="${apples }">
			<tr>
			   <td>
			      ${apple.a_location}
			   </td>
			   <td>
			      <fmt:formatNumber type="currency" value="${apple.a_price }" />
			   </td>
			</tr>
		</c:forEach>
	    </tbody>
	 </table>
	  <div class=apple-page__pagenum>
	          <c:forEach var="p" begin="1" end="${pn}">
	      		 <a href="ApplePageController?page=${p }">${p }</a>
	          </c:forEach>	       
	 </div>
	 </div>
</body>
</html>