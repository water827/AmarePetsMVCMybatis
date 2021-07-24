<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	request.setCharacterEncoding("UTF-8");
%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사이드 메뉴</title>
	<style type="text/css">
		.no-underline {
			text-decoration: none;
		}
	</style>
</head>
<body>
	<h1>유실유기동물</h1>
	<h1>
		<a href="${contextPath}/board/listBoards.do" class="no-underline">보호 동물</a><br/><br/>
		<a href="#" class="no-underline">실종 신고</a><br/><br/>
		<a href="#" class="no-underline">임시보호 요청</a><br/><br/>
	</h1>
</body>
</html>














