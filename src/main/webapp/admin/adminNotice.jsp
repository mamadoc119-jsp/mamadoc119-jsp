<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 수업계획</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminMain.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminHeader.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminMC.css"/>
</head>
<body>
    <header class="header" th:fragment="adminHeader">
        <span class="logo">똥강아지</span>
        <div class="header-container">
          <nav class="header-nav">
             <a href="${pageContext.request.contextPath}/admin/adminMain.jsp">회원 관리</a>
            <a href="${pageContext.request.contextPath}/admin/adminMC.jsp">게시글 관리</a>
            <a href="${pageContext.request.contextPath}/admin/adminDoctorApply.jsp">신청함 관리</a>
            <a href="${pageContext.request.contextPath}/admin/adminNutrientsWrite.jsp">게시판 등록</a>
          </nav>
        </div>
        <a href="/admin/logout">Logout</a>
      </header>
<div class="main-container">
       <div class="left-container">
        <div class="left-list"><a href="${pageContext.request.contextPath}/admin/adminMC.jsp">상담소 관리</a></div>
        <div class="left-list"><a href="${pageContext.request.contextPath}/admin/adminPrevention.jsp">예방상담 관리</a></div>
        <div class="left-list"><a href="${pageContext.request.contextPath}/admin/adminNutrients.jsp">영양제 관리</a></div>
        <div class="left-list check"><a href="${pageContext.request.contextPath}/admin/adminNotice.jsp">공지사항 관리</a></div>
    </div>
    <div class="right-container">
        <div class="right-title">
            <div class="right-title-sub">공지사항 관리</div>
            <div>
                <form action="" method="get">
                    <fieldset class="field">
                        <legend>게시글 검색</legend>
                        <select name="cate" id="">
                            <option value="title">제목</option>
                        </select>
                        <input type="text" name="keyword">
                        <button class="search-btn">검색</button>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="member-container">
            <div class="member-list thead">
                <div class="number">번호</div>
                <div class="id">제목</div>
                <div class="title">내용</div>
                <div class="date">작성일자</div>
                <div class="sortation"></div>
            </div>
            <!-- 데이터가 들어오는 영역 -->
            <div class="member-list">
                <div class="number">공지사항 번호</div>
                <div class="id">제목</div>
                <div class="title">내용</div>
                <div class="date">작성일자</div>
                <div class="sortation">
                    <a href="#"><button class="show-btn">보기</button></a><!--상세버튼 클릭 시 해당 게시물의 상세페이지로 이동-->
                    <button class="remove-btn">삭제</button>
                </div>
            </div>
            <!-- 데이터가 끝나는 영역-->
            
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script th:src="@{/js/admin/adminClass.js}"></script>
</body>
</html>