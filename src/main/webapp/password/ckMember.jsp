<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>본인인증</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ckMember.css">
</head>
<body>
    <form class="ckMember" action="${pageContext.request.contextPath}/password/changePw.jsp">
        <div class="ckMember-container">
        
            <div class="ckMember-title">
                <h1>본인인증</h1>
                <h5 class="ckMember-subtitle">본인인증을 위해 아래 항목을 입력해주세요.</h5>
            </div>

            <div class="ckMember-email"><h5>인증 받으실 E-Mail*</h5>
                <input type="text" class="ck-email" placeholder=" 회원가입 시 입력했던 이메일을 입력해주세요." required>
                <button class="bt-sendcode">인증코드 발송</button></div>

            <div class="ckMember-code"><h5>인증코드 입력*</h5>
                <input type="text" class="ck-code" placeholder=" 인증코드를 입력해주세요." required>
                <button class="bt-code">인증하기</button></div>

                
            <div class="ckMember-button"><button class="bt-ck">확인</button></div>

        </div>
    </form>
</body>
</html>