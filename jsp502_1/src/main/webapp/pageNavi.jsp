<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩 CSS -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">


</head>
<body>
<br>
<!-- 
페이지 블럭을 출력하는 방법
	1. 요청 컨트롤러에서(BoardListController) pageDto를 request영역에 저장
	2. PageNavi.jsp를 include하기
		- 리스트 페이지의 페이지 블럭을 출력하고 싶은 위치에
	3. searchForm을 생성한다.-> board.jsp에 있음 
		pageNo 요소가 있어야 함
 -->
<!-- 페이지 네비게이션 -->
<nav aria-label="...">
  <ul class="pagination">
  	<!-- 앞으로 가기 버튼 disabled : 비활성화 -->
    <li class="page-item ${pageDto.pre? '' : 'disabled'}">
      <a class="page-link" onclick="goPage(${pageDto.startNum-1 })">Previous</a>
    </li>
    <!-- 앞으로 가기 버튼 끝 -->
    

	    <c:forEach begin="${pageDto.startNum }" end="${pageDto.endNum }" var="i">
	    <li class="page-item">
	    <!-- href="..."링크로 이동할 경우, 검색어가 유지되지 않는다. -->
	    <!-- 검색어를 유지하기 위해 searchForm을 전송하도록 goPage함수를 생성했다. -->
	    <!-- 링크를 함수호출로 변경 onClick이벤트가 발생하면 goPage() 함수를 호출한다.
	    	함수의 파라메터로 페이지번호를 넣어줘야 한다.
	    	
	    -->
	    	<a class="page-link ${pageDto.cri.pageNo eq i ? 'active' : ''}" onclick="goPage(${i })">${i }</a>
	    </li>
	    </c:forEach>
    

        
    <!-- 뒤로가기 버튼 시작 -->
    <li class="page-item ${pageDto.next? '' : 'disabled'}">
      <a class="page-link" onclick="goPage(${pageDto.endNum+1 })">Next</a>
    </li>
    <!-- 뒤로가기 버튼 시작 끝 -->
  </ul>
</nav>


<!-- 부트스트랩 JS -->
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>