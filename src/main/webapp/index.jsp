<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인페이지(로그아웃)</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mainPage.css">
    
</head>
<body>

<!-- 헤더(로그아웃) -->
<c:if test="${sessionScope.doctorNumber == null && sessionScope.memberNumber == null}">
	<jsp:include page="include/header.jsp" />
</c:if>
<c:if test="${sessionScope.doctorNumber != null || sessionScope.memberNumber != null}">
	<jsp:include page="include/headerLogin.jsp" />
</c:if>
<main>
    <!-- 베너 영역(3개) -->
    <section class="main-section-banner">
        <div class="main-banner-group">
            <div class="main-banner-list">
                <img src="${pageContext.request.contextPath}/resources/img/banner1.png" alt="main-banner-img1" class="main-banner-img">
            </div>
            <div class="main-banner-list">
                <img src="${pageContext.request.contextPath}/resources/img/banner2.png" alt="main-banner-img2" class="main-banner-img">
            </div>
            <div class="main-banner-list">
                <img src="${pageContext.request.contextPath}/resources/img/banner3.png" alt="main-banner-img3" class="main-banner-img">
            </div>
        </div>
        <div class="main-banner-arrow">
            <div class="main-arrow-group">
                <img src="${pageContext.request.contextPath}/resources/img/prevArrow.png" alt="prev-arrow" class="arrow-prev">
                <img src="${pageContext.request.contextPath}/resources/img/nextArrow.png" alt="next-arrow" class="arrow-next">
                <div class="main-banner-currentIdx"></div>
                <div class="banner-line">
                    <div class="main-banner-total"></div>
                    <span class="main-banner-line"></span>
                </div>
                <div class="main-banner-slideCnt"></div>
            </div>

        </div>
    </section>

    <!-- 영양제 추천(4개씩, 배너) -->
    <section class="main-nu-section">
        <h1 class="main-nu-title">추천 소아영양제</h1>
        <h2 class="main-nu-subtitle">똥강아지에서 추천하는 소아영양제를 만나보세요.</h2>
        <div class="main-nu-banner">
            <div class="main-nu-group">
                <div class="main-nu-bannerList">
                    <div class="main-nu-list">
                        <a class="main-nu-tag">
                            <img src="${pageContext.request.contextPath}/resources/img/nu1.png" alt="main-num-img1" class="main-nu-img">
                            <div class="main-nu-name">키가 쑥쑥~</div>
                            <div class="main-nu-info">정보 : 키가 쑥쑥 이가 탄탄</div>
                            <div class="main-nu-effect">효과 : 눈, 코, 입</div>
                        </a>
                    </div>
                    <div class="main-nu-list">
                        <a class="main-nu-tag">
                            <img src="${pageContext.request.contextPath}/resources/img/nu2.png" alt="main-num-img1" class="main-nu-img">
                            <div class="main-nu-name">키가 쑥쑥~</div>
                            <div class="main-nu-info">정보 : 키가 쑥쑥 이가 탄탄</div>
                            <div class="main-nu-effect">효과 : 눈, 코, 입</div>
                        </a>
                    </div>
                    <div class="main-nu-list">
                        <a class="main-nu-tag">
                            <img src="${pageContext.request.contextPath}/resources/img/nu3.png" alt="main-num-img1" class="main-nu-img">
                            <div class="main-nu-name">키가 쑥쑥~</div>
                            <div class="main-nu-info">정보 : 키가 쑥쑥 이가 탄탄</div>
                            <div class="main-nu-effect">효과 : 눈, 코, 입</div>
                        </a>
                    </div>
                    <div class="main-nu-list">
                        <a class="main-nu-tag">
                            <img src="${pageContext.request.contextPath}/resources/img/nu4.png" alt="main-num-img1" class="main-nu-img">
                            <div class="main-nu-name">키가 쑥쑥~</div>
                            <div class="main-nu-info">정보 : 키가 쑥쑥 이가 탄탄</div>
                            <div class="main-nu-effect">효과 : 눈, 코, 입</div>
                        </a>
                    </div>
                </div>
                <div class="main-nu-bannerList">
                    <div class="main-nu-list">
                        <a class="main-nu-tag">
                            <img src="${pageContext.request.contextPath}/resources/img/nu5.png" alt="main-num-img1" class="main-nu-img">
                            <div class="main-nu-name">키가 쑥쑥~</div>
                            <div class="main-nu-info">정보 : 키가 쑥쑥 이가 탄탄</div>
                            <div class="main-nu-effect">효과 : 눈, 코, 입</div>
                        </a>
                    </div>
                    <div class="main-nu-list">
                        <a class="main-nu-tag">
                            <img src="${pageContext.request.contextPath}/resources/img/nu6.png" alt="main-num-img1" class="main-nu-img">
                            <div class="main-nu-name">키가 쑥쑥~</div>
                            <div class="main-nu-info">정보 : 키가 쑥쑥 이가 탄탄</div>
                            <div class="main-nu-effect">효과 : 눈, 코, 입</div>
                        </a>
                    </div>
                    <div class="main-nu-list">
                        <a class="main-nu-tag">
                            <img src="${pageContext.request.contextPath}/resources/img/nu1.png" alt="main-num-img1" class="main-nu-img">
                            <div class="main-nu-name">키가 쑥쑥~</div>
                            <div class="main-nu-info">정보 : 키가 쑥쑥 이가 탄탄</div>
                            <div class="main-nu-effect">효과 : 눈, 코, 입</div>
                        </a>
                    </div>
                    <div class="main-nu-list">
                        <a class="main-nu-tag">
                            <img src="${pageContext.request.contextPath}/resources/img/nu2.png" alt="main-num-img1" class="main-nu-img">
                            <div class="main-nu-name">키가 쑥쑥~</div>
                            <div class="main-nu-info">정보 : 키가 쑥쑥 이가 탄탄원</div>
                            <div class="main-nu-effect">효과 : 눈, 코, 입</div>
                        </a>
                    </div>
                </div>

                <div class="main-nu-bannerList">
                    <div class="main-nu-list">
                        <a class="main-nu-tag">
                            <img src="${pageContext.request.contextPath}/resources/img/nu3.png" alt="main-num-img1" class="main-nu-img">
                            <div class="main-nu-name">키가 쑥쑥~</div>
                            <div class="main-nu-info">정보 : 키가 쑥쑥 이가 탄탄원</div>
                            <div class="main-nu-effect">효과 : 눈, 코, 입</div>
                        </a>
                    </div>
                    <div class="main-nu-list">
                        <a class="main-nu-tag">
                            <img src="${pageContext.request.contextPath}/resources/img/nu4.png" alt="main-num-img1" class="main-nu-img">
                            <div class="main-nu-name">키가 쑥쑥~</div>
                            <div class="main-nu-info">정보 : 키가 쑥쑥 이가 탄탄</div>
                            <div class="main-nu-effect">효과 : 눈, 코, 입</div>
                        </a>
                    </div>
                    <div class="main-nu-list">
                        <a class="main-nu-tag">
                            <img src="${pageContext.request.contextPath}/resources/img/nu5.png" alt="main-num-img1" class="main-nu-img">
                            <div class="main-nu-name">키가 쑥쑥~</div>
                            <div class="main-nu-info">정보 : 키가 쑥쑥 이가 탄탄</div>
                            <div class="main-nu-effect">효과 : 눈, 코, 입</div>
                        </a>
                    </div>
                    <div class="main-nu-list">
                        <a class="main-nu-tag">
                            <img src="${pageContext.request.contextPath}/resources/img/nu6.png" alt="main-num-img1" class="main-nu-img">
                            <div class="main-nu-name">키가 쑥쑥~</div>
                            <div class="main-nu-info">정보 : 키가 쑥쑥 이가 탄탄</div>
                            <div class="main-nu-effect">효과 : 눈, 코, 입</div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="main-nu-button">
            <span class="main-num-button1"></span>
            <span class="main-num-button2"></span>
            <span class="main-num-button3"></span>
        </div>
    </section>

    <!-- 병원찾기 -->
    <section class="main-section-map">
        <h2 class="main-map-title">병원 찾기</h2>
        <div class="main-map-group">
            <form class="main-map-form" onsubmit="findHp(event);">
                <input type="text" class="main-map-search" id="keyword" placeholder="지역명을 검색해 주세요">
                <img src="${pageContext.request.contextPath}/resources/img/map.png" alt="" class="main-map-img">
                <button class="main-search-button" type="submit">
                    <img src="${pageContext.request.contextPath}/resources/img/search.png" class="main-search-img" alt="main-search-img">
                </button>
            </form>
        </div>
    </section>

    <!-- 예방알람, 상담소 최신 글 3개씩 -->
    <section class="main-pr-cl">
        <div class="main-pc-cate">
            <div class="main-pc-title">
                <div class="main-pc-name">예방알림</div>
                <a href="${pageContext.request.contextPath}/precaution/precautionListOk.pr" class="main-pc-all">
                    <div class="main-show-text">전체보기</div>
                    <img src="${pageContext.request.contextPath}/resources/img/more.png" alt="main-pc-more" class="main-all-img">
                </a>
            </div>
            <!-- 예방알림 최신 3개글 -->
            <div class="main-pc-group">
            <c:choose>
				<c:when test = "${not empty precautionList}">
				<c:forEach var = "precaution" items ="${precautionList}" begin="0" end="4">
				<input type = "hidden" value = "${precaution.precautionNumber}"/>

                <a href="${pageContext.request.contextPath}/precaution/precautionDetaikOk.pr?precautionNumber=${precautionNumber}" class="main-pc-detail">
                    <div class="main-detail-title" name="precautionTitle">${precaution.precautionTitle}</div>
                    <div class="main-detail-nick" name="precautionNickname">${precaution.doctorNickname}</div>
                    <div class="main-detail-date" name="precautionDate">${precaution.precautionDate}</div>
                </a>
                </c:forEach>
          		</c:when> 	
        		</c:choose>
            </div>
        </div>
        <div class="main-pc-cate">
            <div class="main-pc-title">
                <div class="main-pc-name">상담소</div>
                <a href="${pageContext.request.contextPath}/clinic/clinicListOk.cl?clinicNumber=${clinicNumber}" class="main-pc-all">
                    <div class="main-show-text">전체보기</div>
                    <img src="${pageContext.request.contextPath}/resources/img/more.png" alt="main-pc-more" class="main-all-img">
                </a>
            </div>
            <!-- 상담소 최신 3개글 -->
            <div class="main-pc-group">
                <a href="${pageContext.request.contextPath}/clinic/clinic.jsp" class="main-pc-detail">
                    <div class="main-detail-title">
                        상담소글 제목 ㅎㅎ
                    </div>
                    <div class="main-detail-nick">예은na</div>
                    <div class="main-detail-date">2023.11.10</div>
                </a>
            </div>
        </div>
    </section>
</main>

<!-- footer -->
<jsp:include page="include/footer.jsp" />
<script defer src="${pageContext.request.contextPath}/resources/js/mainPage.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</body>
</html>