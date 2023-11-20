<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>의료인 로그인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/doctorLogin.css">
</head>
<body>
	<!-- 헤더(로그아웃) -->
	<jsp:include page="../include/header.jsp" />
	
	<!-- 의료인 로그인 페이지 -->
    <form class="login">
   		<div class="login-container">
    
   		 <!-- 의료인 로그인 제목 -->
    	<div class="login-title">
    	<div class="doctor-login"><h1 class="doctor-login">의료인 로그인</h1></div>
    	</div>

		<!-- 의료인 로그인 양식 -->
    	<div class="login-email"><h5>이메일</h5>
        	<input type="email" class="input" placeholder=" 이메일" required></div>

    	<div class="login-pw"><h5>비밀번호</h5>
        	<input type="password" class="input" placeholder=" 비밀번호" required></div><br>

		<!-- 로그인 및 회원가입 -->
   	 	<div><button class="bt-login" type="button" onclick ="location.href ='${pageContext.request.contextPath}/index.jsp'">로그인</button></div>
    	<div><button class="bt-join" type="button" onclick ="location.href ='${pageContext.request.contextPath}/join/join.jsp'">회원가입</button></div>

		<!-- 네이버 로그인 -->
    	<div class="line"><hr class="first-line"><h5 class="line-text">또는</h5><hr class="second-line"></div>
    	<div class="join-button"><button type="button" class="bt-naver">네이버 아이디로 로그인</button></div>
    
    	<!-- 비밀번호 찾기 -->
    	<span class="change-pw"><a href="${pageContext.request.contextPath}/password/ckMember.jsp" class="change-pw-tag">비밀번호 찾기</a></span>
   	 	<span class="change-pw-text"><a a href="${pageContext.request.contextPath}/password/ckMember.jsp">비밀번호를 잊어버리셨나요?</a></span>
    	</div>
	</form>

	<!-- footer -->
	<jsp:include page="../include/footer.jsp" />

</body>
</html>