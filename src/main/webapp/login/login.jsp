<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>
	<!-- 헤더(로그아웃) -->
	<jsp:include page="../include/header.jsp" />
	
	<!-- 로그인 페이지 -->
    <form class="login">
	    <div class="login-container">
			<!-- 로그인 제목 -->
		    <h1 class="login-title">로그인</h1>
			<div style="display: flex; justify-content: space-between;">
				<!-- 일반 회원 가입 -->
				<div class="login-img">
			        <a href="/mamadoc/login.me"><img class="member-img" src="${pageContext.request.contextPath}/resources/img/member.png" alt="member"></a>
			        <a href="/mamadoc/login.me"><span class="member">일반 회원 로그인</span></a>
			    </div>
			    <!-- 의료인 회원 가입 -->
			    <div class="login-text">
			        <a href="/mamadoc/login.do"><img class="doctor-img" src="${pageContext.request.contextPath}/resources/img/doctor.png" alt="doctor"></a>
			        <a href="/mamadoc/login.do"><span class="doctor">의료인 로그인</span></a>
			    </div>
			</div>
	    </div>
	</form>

	<!-- footer -->
	<jsp:include page="../include/footer.jsp" />

</body>
</html>