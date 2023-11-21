<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
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
	        <div class="left-list"><a href="${pageContext.request.contextPath}/admin/adClinicList.adcl">상담소 관리</a></div>
	        <div class="left-list"><a href="${pageContext.request.contextPath}/admin/adPrList.adpr">예방상담 관리</a></div>
	        <div class="left-list check"><a href="${pageContext.request.contextPath}/adminNutrients.adnu">영양제 관리</a></div>
	        <div class="left-list"><a href="${pageContext.request.contextPath}/admin/adNoticeList.adno">공지사항 관리</a></div>
	    </div>
    <div class="right-container">
        <div class="right-title">
            <div class="right-title-sub">영양제 관리</div>
            <div>
                <form action="" method="get">
                    <fieldset class="field">
                        <legend>게시글 검색</legend>
                        <select name="cate" id="">
                            <option value="name">영양제명</option>
                            <option value="effect">효과</option>
                        </select>
                        <input type="text" name="keyword">
                        <button class="search-btn">검색</button>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="member-container">
            <div class="member-list thead"> <!--클래스 이름 안맞는거 무시-->
                <div class="number">번호</div>
                <div class="id">영양제명</div>
                <div class="info">영양제 정보</div>
                <div class="info">영양제 효과</div>
                <div class="date">작성일자</div>
                <div class="sortation"></div>
            </div>
            <!-- 데이터가 들어오는 영역 -->
            <c:forEach var="list" items="${nuList}" begin="0" end="9" >
            <div class="member-list">
                <div class="number" name="nutrientsNumber">${list.nutrientsNumber}</div>
                <div class="id">${list.nutrientsName}</div>
                <div class="info">${list.nutrientsInfo}</div>
                <div class="info">${list.nutrientsEffect}</div>
                <div class="date">${list.nutrientsDate}</div>
                <div class="sortation">
                    <button class="modify-btn" onclick="location.href='${pageContext.request.contextPath}/adminNutrientsUpdate.adnu?nutrientsNumber=${list.nutrientsNumber}'">수정</button>
                    <button class="remove-btn" onclick="deleteNu(${list.nutrientsNumber})">삭제</button>
                </div>
            </div>
            </c:forEach>
            <!-- 데이터가 끝나는 영역-->

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
<script defer src="${pageContext.request.contextPath}/resources/js/adminNutrients.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</body>
</html>