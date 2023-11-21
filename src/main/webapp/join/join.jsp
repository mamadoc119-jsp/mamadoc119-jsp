<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/join.css">
</head>
<body>
	<!-- 헤더(로그아웃) -->
	<jsp:include page="../include/header.jsp" />
	
	<!-- 회원가입 페이지 -->
    <form class="join">
    <div class="join-container">

	<!-- 회원가입 제목 -->
    <h1 class="join-title">회원가입</h1>

	<!-- 회원 가입 이미지 -->
    <div class="join-img">
        <a href="/mamadoc/join.me"><img class="member-img" src="${pageContext.request.contextPath}/resources/img/member.png" alt="member"></a>
        <a href="/mamadoc/join.do"><img class="doctor-img" src="${pageContext.request.contextPath}/resources/img/doctor.png" alt="doctor"></a>
    </div>

	<!-- 회원 가입 텍스트 -->
    <div class="join-text">
        <a href="/mamadoc/join.me"><span class="member">일반 회원가입</span></a>
        <a href="/mamadoc/join.do"><span class="doctor">의료인 회원가입</span></a>
    </div>
    </div>
</form>

	<!-- footer -->
	<jsp:include page="../include/footer.jsp" />

</body>
</html>