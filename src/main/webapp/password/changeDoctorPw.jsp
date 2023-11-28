<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 변경</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/changePw.css">
    <script defer src="${pageContext.request.contextPath}/resources/js/changePw.js"></script>
</head>
<body>
	<!-- 헤더(로그아웃) -->
	<c:if test="${sessionScope.doctorNumber == null && sessionScope.memberNumber == null}">
		<jsp:include page="../include/header.jsp" />
	</c:if>
	<c:if test="${sessionScope.doctorNumber != null || sessionScope.memberNumber != null}">
		<jsp:include page="../include/headerLogin.jsp" />
	</c:if>
	
	<!-- 회원정보 없음 -->
	<c:if test="${doctorNumber == 0 && sessionScope.doctorNumber == null}">
		<form>
			<div class="wrong-container">
				<div class="changePw-title">
					<h1>잘못된 회원정보입니다</h1>
					<h5 class="changePw-subtitle">올바른 회원정보를 입력해주세요.</h5>
				</div>
				<div style="display: flex;justify-content: space-between;">
					<a onclick="history.back()" style="cursor: pointer;" class="back">뒤로가기</a>
					<a href="/mamadoc/join.do" style="text-decoration: none;color: black" class="go-join">회원가입</a>
				</div>
			</div>
		</form>
	</c:if>
	<!-- 회원정보 있음 -->
	<c:if test="${doctorNumber != 0 || sessionScope.doctorNumber != null}">
	    <form class="changePw" action="/mamadoc/modifyPwOk.do" id="form" method="post">
	    	<c:if test="${doctorNumber != 0}">
		    	<input type="hidden" value="${doctorNumber}" name="doctorNumber">
		    </c:if>
	    	<div class="changePw-container">
	    
		    	<!-- 비밀번호 찾기 제목, 소제목 -->
		        <div class="changePw-title">
		            <h1>비밀번호 변경</h1>
		            <h5 class="changePw-subtitle">비밀번호 변경을 위해 아래 항목을 입력해주세요.</h5>
		        </div>
		
				<!-- 비밀번호 찾기 양식 -->
		        <div class="changePw-newPw">
		        	<div style="display: flex;justify-content: space-between;">
			        	<h5>변경 할 비밀번호*</h5>
			        	<h5 class="pw-no">8자리 이상 영문 대소문자 포함</h5>
	    				<h5 class="pw-yes">사용가능한 비밀번호입니다</h5>
	    			</div>
		            <input type="password" class="input" id="pw" placeholder="변경 할 비밀번호를 입력해주세요." name="doctorPassword" required>
		        </div>
		
		        <div class="changePw-ckPw">
		        	<div style="display: flex;justify-content: space-between;">
		        		<h5>변경 할 비밀번호 재입력*</h5>
		        		<h5 class="pw-no" style="color: red;display: none;">비밀번호가 일치하지 않습니다</h5>
		    			<h5 class="pw-yes" style="color: blue;display: none;">비밀번호가 일치합니다</h5>
		        	</div>
		            <input type="password" class="input" id="check-pw" placeholder="변경 할 비밀번호를 다시 한번 입력해주세요." required>
		        </div>
		        
		     	<!-- 비밀번호 찾기 확인 버튼 -->
		        <div class="changePw-button">
		        	<button class="bt-pw">확인</button>
		        </div>
	
	    	</div>
	    </form>
    </c:if>

	<!-- footer -->
	<jsp:include page="../include/footer.jsp" />
	
</body>
</html>