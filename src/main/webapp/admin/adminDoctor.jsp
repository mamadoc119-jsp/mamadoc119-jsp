<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <a href="${pageContext.request.contextPath}/adminMain.adme">회원 관리</a>
            <a href="${pageContext.request.contextPath}/admin/adminMC.jsp">게시글 관리</a>
            <a href="${pageContext.request.contextPath}/adminDoctorApply.addo">신청함 관리</a>
            <a href="${pageContext.request.contextPath}/adminNutrientsWrite.adnu">게시판 등록</a>
          </nav>
        </div>
        <a href="${pageContext.request.contextPath}/adminLogoutOk.ad">Logout</a>
      </header>
<div class="main-container">
    <div class="left-container">
        <div class="left-list"><a href="${pageContext.request.contextPath}/adminMain.adme">부모 회원</a></div>
        <div class="left-list check"><a href="${pageContext.request.contextPath}/adminDoctor.addo">의료인 회원</a></div>
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
                            <option value="email">이메일</option>
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
            <c:forEach var="list" items="${doList}" begin="0" end="19" >
            <div class="member-list"> 
                <div class="number">${list.doctorNumber}</div>
                <div class="id">${list.doctorEmail}</div>
                <div class="name">${list.doctorName}</div>
                <div class="birth">${list.doctorNickname}</div>
                <div class="phone">${list.doctorAddress} ${list.doctorDetailAddress} ${list.doctorExtraAddress}</div>
                <div class="sortation">
                    <div>의료진</div> <!--유저 정보 삭제 버튼-->
                </div>
                <div class="sortation">
                    <button class="detail-btn"><a href="${pageContext.request.contextPath}/adminDoctorDetail.addo?doctorNumber=${list.doctorNumber}&doctorStauts=${list.doctorStatus}">상세</a></button>  
                    <button class="remove-btn" onclick="deleteDo(${list.doctorNumber})">삭제</button> <!--유저 정보 삭제 버튼-->
                </div>
            </div>
            </c:forEach>

        </div>
        <!--페이징 처리부분-->
	   	<div style="display: flex;  justify-content: center;">
	   		<table style="font-size:1.3rem">
				<tr align="center" valign="middle">
					<td>
						<c:if test="${nowPage > 1}">
							<a href="${pageContext.request.contextPath}/adminNutrients.adnu?page=${nowPage-1}">&lt;</a>
						</c:if>
						
						<c:forEach var="i" begin="${startPage}" end="${endPage}">
								<c:choose>
									<c:when test="${i eq nowPage}">
										<c:out value="[${i}]"/>&nbsp;
									</c:when>
									<c:otherwise>
										<a href="${pageContext.request.contextPath}/adminNutrients.adnu?page=${i}"><c:out value="${i}"/></a>
									</c:otherwise>
								</c:choose>
						</c:forEach>
						
						<c:if test="${nowPage != realEndPage}">
							<a href="${pageContext.request.contextPath}/adminNutrients.adnu?page=${nowPage+1}">&gt;</a>
						</c:if>
					</td>
				</tr>
			</table>
		 </div>
    </div>
</div>
<script defer src="${pageContext.request.contextPath}/resources/js/adminDoctor.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</body>
</html>