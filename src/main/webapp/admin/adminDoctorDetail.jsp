<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 멘토 신청 상세</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminMain.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminHeader.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminDoctorDetail.css"/>
</head>
<body>
    <header class="header">
        <span class="logo">똥강아지</span>
        <div class="header-container">
         <nav class="header-nav">
             <a href="${pageContext.request.contextPath}/adminMain.adme">회원 관리</a>
            <a href="${pageContext.request.contextPath}/admin/adClinicList.adcl">게시글 관리</a>
            <a href="${pageContext.request.contextPath}/adminDoctorApply.addo">신청함 관리</a>
            <a href="${pageContext.request.contextPath}/admin/adminNutrientsWrite.jsp">게시판 등록</a>
          </nav>
        </div>
        <a href="${pageContext.request.contextPath}/adminLogoutOk.ad">Logout</a>
      </header>
<div class="main-container">
    <div class="left-container">
        <c:choose>
            <c:when test="${doctor.doctorStatus eq 0}">
            	<div class="left-list check"><a href="${pageContext.request.contextPath}/adminDoctorApply.addo">의료인 신청함</a></div>
        	</c:when>
        	<c:otherwise>
        		<div class="left-list check"><a href="${pageContext.request.contextPath}/adminDoctor.addo">의료인 관리</a></div>
        	</c:otherwise>
        </c:choose>
    </div>
    <div class="right-container">
<!--        -->
        <div class="modal">

        </div>
<!--        -->
        <div class="right-title">
            <div class="right-title-sub">의료인 신청</div>
        </div>

        <div class="content-box">
            <div>
                <h3>이름</h3>
                <div class="education">${doctor.doctorName}</div>
            </div>
            <div>
                <h3>이메일</h3>
                <div class="education">${doctor.doctorEmail}</div>
            </div>
            <div>
                <h3>닉네임</h3>
                <div class="education">${doctor.doctorNickname}</div>
            </div>
            <div>
                <h3>근무지 주소</h3>
                <div class="education">${doctor.doctorAddress} ${doctor.doctorDetailAddress} ${doctor.doctorExtraAddress}</div>
            </div>
            <div>
                <h3>면허 번호</h3>
                <div class="education">${doctor.doctorLicense}</div>
            </div>
            <div>
                <h3>전공</h3>
                <div class="education">${doctor.doctorMajor}</div>
            </div>
           
            <div>
                <h3>증빙 자료</h3>
                <div class="file-box">
                    <div className="file" style="margin: 0 3px; cursor:pointer;" onclick="detailFile()">
                    <img src="${pageContext.request.contextPath}/resources/upload/${doctor.dofileUuid}${doctor.dofileType}"
                        width="220px" height="200px"/></div>
                </div>
            </div>
            <c:choose>
            <c:when test="${doctor.doctorStatus eq 0}">
	            <div class="btn-box">
	                <button class="approval-detail-btn"  onclick="approveDoctor('${pageContext.request.contextPath}', ${doctor.doctorNumber})">승 인</button><!--나중에 js파일로 숨길거임-->
	                <button class="refusal-detail-btn"   onclick="rejectDoctor('${pageContext.request.contextPath}', ${doctor.doctorNumber}, ${doctor.doctorStatus})">거 부</button><!--얘도 ㅋ-->
	            </div>
	        </c:when>
	        <c:otherwise>
	        	<div class="btn-box">
	                <button class="refusal-detail-btn"   onclick="rejectDoctor('${pageContext.request.contextPath}', ${doctor.doctorNumber}, ${doctor.doctorStatus})">삭제</button><!--얘도 ㅋ-->
	            </div>
	        </c:otherwise>
            </c:choose>
        </div>
    </div><!--"right-container" 끝-->
</div><!--"main-container" 끝-->
<!-- <input type="hidden" value="의료진 신청번호?의료진 유저번호?" class="apply-num"> -->
<script defer src="${pageContext.request.contextPath}/resources/js/adminDoctorDetail.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>