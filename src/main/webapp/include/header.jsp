<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>헤더(로그아웃)</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
</head>
<body>

<!-- 헤더(로그아웃) -->
<header>
    <div class="main-header-container">
        <div class="main-header-logo">
            <a href="${pageContext.request.contextPath}/index.jsp" class="main-logo-tag">
                <img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="main-header-logo"
                class="main-logo-img">
            </a>
        </div>
        <nav class="main-header-category">
            <ul class="main-header-category-ul">
                <li class="main-header-category-list">
                    <a href="${pageContext.request.contextPath}/recoNutriSupplements/recoNutriSupplementsList.jsp" class="main-category-tag">소아영양제</a>
                </li>
                <li class="main-header-category-list">
                    <a href="${pageContext.request.contextPath}/findHp/findHp.jsp" class="main-category-tag">병원찾기</a>
                </li>
                <li class="main-header-category-list">
                    <a href="" class="main-category-tag">야간진료병원</a>
                </li>
                <li class="main-header-category-list">
                    <a href="${pageContext.request.contextPath}/precaution/precautionaryNoticeList.jsp" class="main-category-tag">정보놀이터</a>
                </li>
                <li class="main-header-category-list">
                    <a href="${pageContext.request.contextPath}/notice/noticeList.jsp" class="main-category-tag">공지사항</a>
                </li>
            </ul>
        </nav>
        <nav class="main-header-member">
            <ul class="main-header-member-ul">
                <li class="main-header-member-list">
                    <a href="${pageContext.request.contextPath}/login/login.jsp" class="main-member-tag">로그인</a>
                </li>
                <li class="main-header-member-list">
                    <a href="${pageContext.request.contextPath}/join/join.jsp" class="main-member-tag">회원가입</a>
                </li>
            </ul>
        </nav>
        <div class="main-hidden-category">
            <ul class="main-hidden-ul">
                <li class="main-hidden-list">
                    <a href="${pageContext.request.contextPath}/precaution/precautionaryNoticeList.jsp" class="main-hidden-tag">예방 알림</a>
                </li>
                <li class="main-hidden-list">
                    <a href="${pageContext.request.contextPath}/counselingCenter/counselingCenterList.jsp" class="main-hidden-tag">상담소</a>
                </li>
            </ul>
            <ul class="main-hidden-ul2">
                <li class="main-hidden-list">
                    <a href="${pageContext.request.contextPath}/login/memberLogin.jsp" class="main-hidden-tag">일반 로그인</a>
                </li>
                <li class="main-hidden-list">
                    <a href="${pageContext.request.contextPath}/login/doctorLogin.jsp" class="main-hidden-tag">의료인 로그인</a>
                </li>
            </ul>
            <ul class="main-hidden-ul3">
                <li class="main-hidden-list">
                    <a href="${pageContext.request.contextPath}/join/memberJoin.jsp" class="main-hidden-tag">회원가입</a>
                </li>
                <li class="main-hidden-list">
                    <a href="join.do" class="main-hidden-tag">의료인가입</a>
                </li>
            </ul>
        </div>
    </div>
</header>

<script defer src="${pageContext.request.contextPath}/resources/js/header.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</body>
</html>