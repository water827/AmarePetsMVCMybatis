<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>검색결과</title>
	<style type="text/css">
		.class1 {text-decoration: none;}
		.class2 {text-align: center; font-size: 30px;}
		.no-line {text-decoration: none;}
		.sel-page {text-decoration: none; color: red;}
	</style>
</head>
<body>
	<hgroup>
		<h1>게시판 검색 결과</h1>
	</hgroup>

	<table border="0" align="center" width="80%">
		<tr align="center" bgcolor="beige">
			<td><b>글번호</b></td>
			<td><b>공고번호</b></td>
			<td><b>품종</b></td>
			<td><b>성별</b></td>
			<td><b>나이</b></td>
			<td><b>발견장소</b></td>
			<td><b>발견일자</b></td>
			<td><b>특징</b></td>
			<td><b>중성화</b></td>
			<td><b>등록번호</b></td>	
			<td><b>상태</b></td>
			<td><b>보호소</b></td>
			<td><b>사진</b></td>
			<td><b>등록일</b></td>
			<td><b>아이디</b></td>
			<td><b>삭제</b></td>
		</tr>
		
	
		<c:forEach var="board" items="${boardsList }" varStatus="boardNum">
			<tr align="center">
				<td>${board.pro_boardNum }</td>
				<td>${board.pro_noticeNum }</td>
				<td>${board.pro_kind }</td>
				<td>${board.pro_gender }</td>
				<td>${board.pro_age }</td>
				<td>${board.pro_place }</td>
				<td>${board.pro_findDate }</td>
				<td>${board.pro_character }</td>
				<td>${board.pro_neutering }</td>
				<td>${board.pro_registNum }</td>
				<td>${board.pro_state }</td>
				<td>${board.pro_shelter }</td>
				
				<td>${board.pro_img }</td>
			
				<td>${board.pro_date }</td>
				<td>${board.user_id }</td>
				<td><a href="${contextPath}/board/removeBoard.do?pro_noticeNum=${board.pro_noticeNum}">삭제하기</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>