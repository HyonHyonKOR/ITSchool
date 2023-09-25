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
<c:if test="${sessionScope.loginMember!=null}">
 <form action="BoardWriteController" name="boardForm" 
		onsubmit="return checkBoardValid();">
		<input name="token" type="hidden" value="${generatedToken }">
	<textarea class="writeArea" placeholder="내용을 입력해주세요" name="b_text" autofocus="autofocus"
	autocomplete="off" maxlength="200" ></textarea>
		<button>작성</button>
	</form>
	</c:if>	
	<c:if test="${pageNo!=1 }">
		<a href="BoardPageController?p=${pageNo-1}">
			<i class="fa-solid fa-arrow-left-long"></i>
		</a>
	</c:if>
	<c:if test="${pageNo!=pageCount}">
		<a href="BoardPageController?p=${pageNo+1}">
			<i class="fa-solid fa-arrow-right-long"></i>
		</a>
	</c:if>
	
	
	<c:forEach var="board" items="${boards }">
		<table class="boardContentTbl">
			<tr>
				<td class="boardPhoto" rowspan="3" valign="top" align="center">
					<img src="img/${board.m_photo }">
				</td>
				<td class="boardWriter">${board.b_writer }</td>
			</tr>
			<tr>
				<td class="boardWhen" align="right">
					<fmt:formatDate value="${board.b_when }" 
					type="both" dateStyle="long" timeStyle="short"/>
				</td>
			</tr>
			<tr>
				<td class="boardText">${board.b_text }</td>
			</tr>
			<c:if test="${board.b_writer == sessionScope.loginMember.m_id }">
				<tr>
					<td colspan="2" align="right" class="boardBtn">
						<button onclick="boardUpdate(${board.b_no});">수정</button>
						<button onclick="goDelete(${board.b_no});">삭제</button>
					</td>
				</tr>
			</c:if>
		</table>
	</c:forEach>
</body>
</html>