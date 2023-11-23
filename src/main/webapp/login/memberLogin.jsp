<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>일반 회원 로그인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/memberLogin.css">
</head>
<body>
	<!-- 헤더(로그아웃) -->
	<jsp:include page="../include/header.jsp" />
	
	<!-- 일반 회원 로그인 페이지 -->
    <form class="login" action="/mamadoc/loginOk.me" method="post">
    	<div class="login-container">
    
    		<!-- 일반 회원 로그인 제목 -->
    		<div class="login-title">
    			<div class="member-login">
	    			<h1 class="member-login">회원 로그인</h1>
	    		</div>
	    	</div>
				<!-- 일반 회원 로그인 양식 -->
	    		<div class="login-email">
	    			<h5>이메일</h5>
	        		<input type="email" class="input" placeholder=" 이메일" name="memberEmail" required>
	        	</div>
	
	    		<div class="login-pw">
	    			<h5>비밀번호</h5>
	        		<input type="password" class="input" placeholder=" 비밀번호" name="memberPassword" required>
	        	</div>
	        	<br>
	
				<!-- 로그인 및 회원가입 -->
	    		<div>
	    			<button class="bt-login">로그인</button>
	    		</div>
    		<div>
    			<button class="bt-join" type="button" onclick ="location.href ='join.me'">회원가입</button>
    		</div>

		    <!-- 비밀번호 찾기 -->
		    <span class="change-pw-text">
		    	<a href="/mamadoc/checkMember.me" class="change-pw">비밀번호를 잊어버리셨나요?</a>
		    </span>
		</div>
	</form>

	<!-- footer -->
	<jsp:include page="../include/footer.jsp" />

</body>
</html>