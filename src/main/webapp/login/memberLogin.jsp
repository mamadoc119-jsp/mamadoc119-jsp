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
    <form class="login">
    <div class="login-container">
    
    <div class="login-title">
    <div class="member-login"><h1 class="member-login">회원 로그인</h1></div>
    </div>

    <div class="login-email"><h5>이메일</h5>
        <input type="email" class="login-email" placeholder=" 이메일" required></div>

    <div class="login-pw"><h5>비밀번호</h5>
        <input type="password" class="login-pw" placeholder=" 비밀번호" required></div><br>


    <div><button class="bt-login" onclick ="location.href ='${pageContext.request.contextPath}/login/login.jsp'">로그인</button></div>
    <div><button class="bt-join" onclick ="location.href ='${pageContext.request.contextPath}/join/join.jsp'">회원가입</button></div>

    <div class="line"><hr class="first-line"><h5>또는</h5><hr class="second-line"></div>
    <div class="join-button"><button class="bt-naver">네이버 아이디로 로그인</button></div>
        <span class="change-pw"><a href="${pageContext.request.contextPath}/password/ckMember.html" class="change-pw-tag">비밀번호 찾기</a></span>
        <span class="withdrawal"><a href="${pageContext.request.contextPath}/index.jsp">회원 탈퇴</a></span>
    </div>
</form>

        

    

</body>
</html>