<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>본인인증</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ckMember.css">
</head>
<body>
	<!-- 헤더(로그아웃) -->
	<c:if test="${sessionScope.doctorNumber == null && sessionScope.memberNumber == null}">
		<jsp:include page="../include/header.jsp" />
	</c:if>
	<c:if test="${sessionScope.doctorNumber != null || sessionScope.memberNumber != null}">
		<jsp:include page="../include/headerLogin.jsp" />
	</c:if>
	
	<!-- 본인 인증 페이지 -->
    <form class="ckMember" action="/mamadoc/checkMemberOk.me" method="post">
        	<div class="ckMember-container">
      
      		<!-- 비밀번호 찾기 제목, 소제목 -->  
            <div class="ckMember-title">
                <h1>본인인증</h1>
                <h5 class="ckMember-subtitle">본인인증을 위해 아래 항목을 입력해주세요.</h5>
            </div>

			<!-- 본인 인증 양식 -->
            <div class="ckMember-email">
            	<h5>이메일*</h5>
                <input type="text" class="input" placeholder="회원가입 시 입력했던 이메일을 입력해주세요." name="memberEmail" required>
            </div>

            <div class="ckMember-code">
            	<h5>이름*</h5>
                <input type="text" class="input" placeholder="회원가입 시 입력했던 이름을 입력해주세요." name="memberName" required>
            </div>

         	<!-- 본인 인증 확인 버튼 -->
            <div class="ckMember-button">
            	<button class="bt-ck">확인</button>
           	</div>

        </div>
    </form>
    
    <!-- footer -->
	<jsp:include page="../include/footer.jsp" />
</body>
</html>