<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 멘토 유저관리</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminMain.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminHeader.css"/>
</head>
<body>
    <header class="header">
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
        <div class="left-list"><a href="${pageContext.request.contextPath}/admin/adminMain.jsp">부모 회원</a></div>
        <div class="left-list check"><a href="${pageContext.request.contextPath}/admin/adminDoctor.jsp">의료인 회원</a></div>
    </div>
    <div class="right-container">
        <div class="right-title">
            <div class="right-title-sub">의료인 회원</div>
            <div>
                <form action="" method="get">
                    <fieldset class="field">
                        <legend>회원 검색</legend>
                        <select name="cate" id="">
                            <option value="name">이름</option>
                            <option value="nickname">닉네임</option>
                        </select>
                        <input type="text" name="keyword">
                        <button class="search-btn">검색</button>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="member-container">
            <!-- 구분점 -->
            <div class="member-list thead"> <!--클래스 이름 안맞는거 무시-->
                <div class="number">번호</div>
                <div class="id">이메일</div>
                <div class="name">이름</div>
                <div class="birth">닉네임</div>
                <div class="phone">근무지 주소</div>
                <div class="sortation">구분</div>
                <div class="sortation"></div>
            </div>
            <!-- 데이터가 들어오는 부분 -->
            <div class="member-list"> 
                <div class="number">유저번호</div>
                <div class="id">이메일</div>
                <div class="name">유저 이름</div>
                <div class="birth">닉네임</div>
                <div class="phone">근무지 주소</div>
                <div class="sortation">
                    <div>의료진</div> <!--유저 정보 삭제 버튼-->
                </div>
                <div class="sortation">
                    <button class="detail-btn"><a href="${pageContext.request.contextPath}/admin/adminDoctorDetail.jsp">보기</a></button> <!--상세 버튼 클릭하면 증빙자료를 볼 수 있어야 되는데 어떻게 처리해야댈지 상의해야함-->
                    <button type="button" class="remove-btn">삭제</button> <!--유저 정보 삭제 버튼-->
                </div>
                
            </div>

        </div>
    </div>
</div>
</body>
</html>