<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>의료인 회원 정보 수정</title>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/doctorInfo.css">
    <script defer src="${pageContext.request.contextPath}/resources/js/doctorInfo.js"></script>
</head>
<body>
	<!-- 헤더(로그아웃) -->
	<c:if test="${sessionScope.doctorNumber == null && sessionScope.memberNumber == null}">
		<jsp:include page="../include/header.jsp" />
	</c:if>
	<c:if test="${sessionScope.doctorNumber != null || sessionScope.memberNumber != null}">
		<jsp:include page="../include/headerLogin.jsp" />
	</c:if>

	<!-- 의료인 회원 정보 수정 -->
    <form class="join" action="modifyInformOk.do" method="post">
    	<div class="join-container">

			<!-- 의료인 회원 정보 수정 제목, 소제목 -->
    		<h1 class="join-title">의료인 회원 정보 수정</h1>
    		<h5 class="join-subtitle">*표시는 수정 가능한 항목입니다.</h5>

			<!-- 회원 정보 수정 양식 -->
    		<div class="join-name">
    			<h5>성명</h5>
        		<input type="text" class="join-name" id="bt-non" value="${inform.doctorName}" readonly>
        	</div>

	    	<div class="join-email">
	    		<h5>이메일</h5>
	        	<input type="email" class="join-email" id="bt-non" value="${inform.doctorEmail}" readonly>
	        </div>
	
	    	<div class="join-nickname">
	    		<h5>닉네임*</h5>
	        	<input type="text" class="join-nickname" class="bt" placeholder=" 닉네임 입력" value="${inform.doctorNickname}" name="doctorNickname" required>
	        	<button type="button" class="bt-certification" onclick="alert('사용가능한 닉네임입니다.');">인증하기</button>
	        </div>
	
	        <div class="join-zipcode">
	        	<h5>근무지 주소*</h5>
	            <input type="text" class="join-zipcode" class="bt" id="sample6_postcode" placeholder=" 우편번호(주소찾기로 검색해주세요.)" value="${inform.doctorPostCode}" name="doctorPostCode" readonly>
	            <button class="bt-findzipcode" onclick="sample6_execDaumPostcode()">주소찾기</button>
	        </div>
	        <input type="text" class="join-address" id="sample6_address" id="bt-non" placeholder=" 주소찾기로 검색해주세요." value="${inform.doctorAddress}" name="doctorAddress" readonly>
	        <input type="text" class="join-addr-extra" id="sample6_extraAddress" placeholder=" 참고항목" value="${inform.doctorExtraAddress}" name="doctorExtraAddress" readonly>
	        <input type="text" class="join-address-detail" id="sample6_detailAddress" id="bt-non" placeholder=" 상세주소를 입력해주세요." value="${inform.doctorDetailAddress}" name="doctorDetailAddress">
	        <br>
	
	    	<div class="join-major">
	    		<h5>전공</h5>
	        	<input type="text" class="join-major" id="bt-non" value="${inform.doctorMajor}" readonly>
	        </div>
	
			<!-- 회원 정보 수정 완료 버튼 -->
	        <div class="join-button">
	        	<button class="bt-join">확인</button>
	        </div>
	
			<!-- 비밀번호 찾기 및 회원 탈퇴 -->
	        <span class="change-pw">
	        	<a href="${pageContext.request.contextPath}/password/ckMember.jsp" class="change-pw-tag">비밀번호 찾기</a>
	        </span>
	        <span class="withdrawal">
	        	<a href="quitOk.do" class="withdrawal-tag">회원 탈퇴</a>
	        </span>
	    </div>
	</form>

	<!-- footer -->
	<jsp:include page="../include/footer.jsp" />

</body>
</html>