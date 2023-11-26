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
<script type="text/javascript">
function goPage(pageNo){
 	searchForm.action = '/board/boardList';
	searchForm.pageNo.value = pageNo;
	searchForm.submit();
	 
}

</script>


${id }님, 환영합니다.
<h2>게시판</h2>
<form name="searchForm">
pageNo : <input type="text" name="pageNo" value="${pageDto.cri.pageNo}" >
</form>
<table border="1">
<tr>
	<th>제목</th>
	<th width="40%">내용</th>
	<th>아이디</th>
	<th width="30%">게시날짜</th>
	<th>조회수</th>
</tr>
<c:forEach var="dto" items="${list }">
<tr>
	<td><a href="/boardView?no="${dto.num }>${dto.title }</a></td>
	<td>${dto.content }</td>
	
	<td>${dto.id }</td>
	<td>${dto.postdate }</td>
	<td>${dto.visitcount }</td>
</tr>
</c:forEach>

</table>
<%@ include file="../pageNavi.jsp" %>
</body>
</html>