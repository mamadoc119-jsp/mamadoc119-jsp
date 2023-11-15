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
    <form class="login">
    <div class="login-container">

    <h1 class="login-title">로그인</h1>

    <div class="login-img">
        <a href="${pageContext.request.contextPath}/login/memberLogin.jsp"><img class="member-img" src="${pageContext.request.contextPath}/resources/img/member.png" alt="member"></a>
        <a href="${pageContext.request.contextPath}/login/doctorLogin.jsp"><img class="doctor-img" src="${pageContext.request.contextPath}/resources/img/doctor.png" alt="doctor"></a>
    </div>

    <div class="login-text">
        <a href="${pageContext.request.contextPath}/login/memberLogin.jsp"><span class="member">일반 회원 로그인</span></a>
        <a href="${pageContext.request.contextPath}/login/doctorLogin.jsp"><span class="doctor">의료인 로그인</span></a>
    </div>
    </div>
</form>


</body>
</html>