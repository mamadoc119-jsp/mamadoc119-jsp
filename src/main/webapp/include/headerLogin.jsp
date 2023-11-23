<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>헤더(로그인)</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/headerLogin.css">
</head>
<body>

<!-- 헤더(로그인) -->
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
                    <a href="${pageContext.request.contextPath}/nutrientsList.adnu" class="main-category-tag">소아영양제</a>
                </li>
                <li class="main-header-category-list">
                    <a href="${pageContext.request.contextPath}/findHp/findHp.jsp" class="main-category-tag">병원찾기</a>
                </li>
                <li class="main-header-category-list">
                    <a href="" class="main-category-tag">야간진료병원</a>
                </li>
                <li class="main-header-category-list">
                    <a href="${pageContext.request.contextPath}/precaution/precautionListOk.pr" class="main-category-tag">정보놀이터</a>
                </li>
                <li class="main-header-category-list">
                    <a href="${pageContext.request.contextPath}/noticeList.adno" class="main-category-tag">공지사항</a>
                </li>
            </ul>
        </nav>
        <nav class="main-header-member">
            <ul class="main-header-member-ul">
                <li class="main-header-member-list">
                	<c:if test="${sessionScope.doctorNumber != null}">
                    	<a href="/mamadoc/informOk.do" class="main-member-tag">마이페이지</a>
                    </c:if>
                    <c:if test="${sessionScope.memberNumber != null}">
                    	<a href="/mamadoc/informOk.me" class="main-member-tag">마이페이지</a>
                    </c:if>
                </li>
                <li class="main-header-member-list">
                	<c:if test="${sessionScope.doctorNumber != null}">
                    	<a href="/mamadoc/logoutOk.do" class="main-member-tag">로그아웃</a>
                    </c:if>
                    <c:if test="${sessionScope.memberNumber != null}">
                    	<a href="/mamadoc/logoutOk.me" class="main-member-tag">로그아웃</a>
                    </c:if>
                </li>
            </ul>
        </nav>
        <div class="main-hidden-category">
            <ul class="main-hidden-ul">
                <li class="main-hidden-list">
                    <a href="${pageContext.request.contextPath}/precaution/precautionListOk.pr" class="main-hidden-tag">예방 알림</a>
                </li>
                <li class="main-hidden-list">
                    <a href="${pageContext.request.contextPath}/clinic/clinicListOk.cl" class="main-hidden-tag">상담소</a>
                </li>
            </ul>
        </div>
    </div>
</header>

<script defer src="${pageContext.request.contextPath}/resources/js/headerLogin.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</body>
</html>