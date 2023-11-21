<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	        <div class="left-list"><a href="${pageContext.request.contextPath}/adminNutrients.adnu">영양제 관리</a></div>
	        <div class="left-list check"><a href="${pageContext.request.contextPath}/admin/adNoticeList.adno">공지사항 관리</a></div>
	    </div>
    <div class="right-container">
        <div class="right-title">
            <div class="right-title-sub">공지사항 관리</div>
            <div>
                <form action="" method="get">
                    <fieldset class="field">
                        <legend>게시글 검색</legend>
                        <select name="cate" id="">
                            <option value="name">제목</option>
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
            <c:choose>
                   <c:when test="${not empty adNoticeList}">
                   	<c:forEach var="adNotice" items="${adNoticeList}" varStatus="status">
            <div class="member-list">
                <div class="number"><c:out value="${adNotice.noticeNumber}"/></div>
                <div class="id"><c:out value="${adNotice.noticeTitle}"/></div>
                <div class="title"><c:out value="${adNotice.noticeContent}"/></div>
                <div class="date"><c:out value="${adNotice.noticeDate}"/></div>
                <div class="sortation">
                    <button class="show-btn" onclick="location.href='${pageContext.request.contextPath}/notice/noticeDetail.adno?noticeNumber=${adNotice.noticeNumber}'">보기</button><!--상세버튼 클릭 시 해당 게시물의 상세페이지로 이동-->
                    <button class="remove-btn" onclick="location.href='${pageContext.request.contextPath}/admin/adNoticeDelete.adno?noticeNumber=${adNotice.noticeNumber}'">삭제</button>
                </div>
            </div>
            	</c:forEach>
            	</c:when>
            </c:choose>
            <!-- 데이터가 끝나는 영역-->
        </div>
                <!--페이징 처리부분-->
    	<div style="display: flex;  justify-content: center;">
    		<table style="font-size:1.3rem">
				<tr align="center" valign="middle">
					<td>
						<c:if test="${nowPage > 1}">
							<a href="${pageContext.request.contextPath}/admin/adNoticeList.adno?page=${nowPage-1}">&lt;</a>
						</c:if>
						
						<c:forEach var="i" begin="${startPage}" end="${endPage}">
								<c:choose>
									<c:when test="${i eq nowPage}">
										<c:out value="[${i}]"/>&nbsp;
									</c:when>
									<c:otherwise>
										<a href="${pageContext.request.contextPath}/admin/adNoticeList.adno?page=${i}"><c:out value="${i}"/></a>
									</c:otherwise>
								</c:choose>
						</c:forEach>
						
						<c:if test="${nowPage != realEndPage}">
							<a href="${pageContext.request.contextPath}/admin/adNoticeList.adno?page=${nowPage+1}">&gt;</a>
						</c:if>
					</td>
				</tr>
			</table>
   		 </div>
    </div>
</div>
</body>
</html>