<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 변경</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/changePw.css">
</head>
<body>
    <form class="changePw" action="${pageContext.request.contextPath}/login/login.jsp">
    <div class="changePw-container">
    
        <div class="changePw-title">
            <h1>비밀번호 변경</h1>
            <h5 class="changePw-subtitle">비밀번호 변경을 위해 아래 항목을 입력해주세요.</h5>
        </div>

        <div class="changePw-newPw"><h5>변경 할 비밀번호*</h5>
            <input type="password" class="newPw" placeholder=" 변경 할 비밀번호를 입력해주세요." required>
        </div>

        <div class="changePw-ckPw"><h5>변경 할 비밀번호 재입력*</h5>
            <input type="password" class="ckPw" placeholder=" 변경 할 비밀번호를 다시 한번 입력해주세요." required>
        </div>
        <div class="changePw-button"><button class="bt-pw">확인</button></div>

    </div>
    </form>   

</body>
</html>