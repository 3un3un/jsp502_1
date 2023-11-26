<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
window.onload = function(){
	
	let loginBtn = document.querySelector('#loginBtn');
	loginBtn.addEventListener('click', function(){
		console.log('로그인 클릭');
		loginForm.action='/login/loginProcess';
		//loginForm.method='post';
		loginForm.submit();
	});
}

</script>


<form name="loginForm" method="post">
아이디 <input type="text" name="id"><br>
비밀번호 <input type="password" name="pw"><br>
<button id="loginBtn">로그인</button>



</form>
</body>
</html>