<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="boardsList" value="${boardMap.boardsList }" />
<c:set var="totBoards" value="${boardMap.totBoards }" />
<c:set var="section" value="${boardMap.section }" />
<c:set var="pageNum" value="${boardMap.pageNum }" />
<% 
	request.setCharacterEncoding("UTF-8"); 
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>보호동물 등록 게시판</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/jquery/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		function readURL(input) {
			if (input.files && input.files[0]) {							/* 이미지 파일 첨부 시 미리 보기 기능 */
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#preview').attr("src", e.target.result);				/* e.target은 이벤트가 일어난 대상, 즉 input 자신을 가리킴*/
				}															/* result는 첨부파일들이 특수하게 가공된 URL을 출력해 줄것임. */
				reader.readAsDataURL(input.files[0]);
			}
		}
	</script>
	
	<script type="text/javascript">
		function fn_boardForm(isLogOn, articleForm, loginForm) {
			if(isLogOn != '' && isLogOn != 'false') {
				location.href=boardForm;
			}
			else{
				alert("로그인 후 글쓰기가 가능합니다")
				location.href=loginForm+'?action=/board/articleForm.do';
			}
		}
	</script>
	
	<style type="text/css">
		.class1 {text-decoration: none;}
		.class2 {text-align: center; font-size: 30px;}
		.no-line {text-decoration: none;}
		.sel-page {text-decoration: none; color: red;}
	</style>
	<style type="text/css">
		#wrapper {
			
		}
	</style>
</head>
<body>
	<div id="wrapper">
		<form action="${contextPath}/board/searchBoards.do" name="frmSearch">
			<div>
				<input name="searchWord" class="" type="text" onkeyup="keywordSearch()" />
			</div>
			<div><input name="search" class="" type="submit" value="검색"/></div>
		</form>
	</div>

	<table border="0" align="center" width="80%">
		<tr align="center" bgcolor="beige">
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
				
<%-- 				<c:if test="${not empty article.imageFileName && article.imageFileName != 'null' }">
					<td>
						<input type="hidden" name="originalFileName" value="${article.imageFileName }" />
						<img alt="사진" src="${contextPath}/download.do?articleNo=${article.articleNo}&pro_img=${article.imageFileName}" id="preview" width="300"><br/>
					</td>
				</c:if> --%>
			
				<td>${board.pro_date }</td>
				<td>${board.user_id }</td>
				<td><a href="${contextPath}/board/removeBoard.do?pro_noticeNum=${board.pro_noticeNum}">삭제하기</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<div class="class2">
		<c:if test="${totBoards != null }">
			<c:choose>
				<c:when test="${totBoards > 100 }">			<!-- 글 개수가 100 초과인 경우 -->
					<c:forEach var="page" begin="1" end="10" step="1">
						
						<c:if test="${section > 1 && page == 1 }">
							<a class="no-line"  href="${contextPath}/board/listBoards.do?section=${section-1}&pageNum=${(section-1)*10 +1}">&nbsp; pre </a>
						</c:if>
						
						<a class="no-line" href="">${(section-1)*10 +page}</a>			<!-- 실제페이지 숫자표시 -->
						
						<c:if test="${page == 10 }">
							<a class="no-line" href="${contextPath}/board/listBoards.do?section=${section+1}&pageNum=${section*10 +1}">&nbsp; next </a>
						</c:if>						
						
					</c:forEach>
				</c:when>
				
				<c:when test="${totBoards == 100 }">			<!-- 등록된 글 개수가 100개인 경우 -->
					<c:forEach var="page" begin="1" end="10" step="1">
						<a class="no-line" href="#">${page}</a>
					</c:forEach>
				</c:when>
				
				<c:when test="${totBoards < 100 }">			<!-- 글 개수가 100 미만인 경우 -->
					<c:forEach var="page" begin="1" end="${totBoards/10 +1}" step="1">
						<c:choose >
							<c:when test="${page == pageNum}">
								<a class="sel-page" href="${contextPath}/board/listBoards.do?section=${section}&pageNum=${page}">${page}</a>
							</c:when>
							<c:otherwise>
								<a class="no-line" href="${contextPath}/board/listBoards.do?section=${section}&pageNum=${page}">${page}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>				
				</c:when>
				
			</c:choose>
		</c:if>
	</div>
	
	<a class="class1" href="${contextPath}/board/boardForm.do"><p class="class2">등록하기</a>
	
	<a class="class1" href="javascript:fn_boardForm('${isLogOn}', '${contextPath}/board/boardForm.do', '${contextPath}/member/loginForm.do')"><p class="class2">등록하기</a>
	
</body>
</html>