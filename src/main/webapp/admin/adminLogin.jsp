<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>관리자 로그인</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminLogin.css"/>
</head>
<body>
<div class="login-container">
  <h1 class="login-title">관리자 로그인</h1>
  <form class="login-form" action="${pageContext.request.contextPath}/adminLoginOk.ad">
    <div class="input-group">
      <label for="userId">아이디</label>
      <input type="text" id="userId" name="adminId" required />
    </div>
    <div class="input-group">
      <label for="userPassword">비밀번호</label>
      <input type="password" id="userPassword" name="adminPassword" required />
    </div>
    <button class="login-btn" type="submit">로그인</button>
  </form>
  <div class="signup-redirect">
    <span></span>
  </div>
</div>
<!-- <script th:if="${param.loginError}">
  alert("로그인에 실패하였습니다. \n사용자 아이디와 비밀번호를 다시 확인해주세요.");
</script> -->
</body>
</html>