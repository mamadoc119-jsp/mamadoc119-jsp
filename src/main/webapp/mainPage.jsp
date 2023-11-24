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
    <c:choose>
            <c:when test = "${not empty nuList}">
            <c:forEach var = "nuList" items ="${nuList}" begin="0" end="11">
            <input type = "hidden" value = "${nuList.nutrientsNumber}"/>

        <h1 class="main-nu-title">추천 소아영양제</h1>
        <h2 class="main-nu-subtitle">똥강아지에서 추천하는 소아영양제를 만나보세요.</h2>
        <div class="main-nu-banner">
            <div class="main-nu-group">
                <div class="main-nu-bannerList">
                    <div class="main-nu-list">
                        <a class="main-nu-tag">
                            <img src="${pageContext.request.contextPath}/resources/upload/${nulist.nufileUuid}${nulist.nufileType}" class="kindSuppImg">
                            <div class="main-nu-name" name="nutrientsName">${nuList.nutrientsName}</div>
                            <div class="main-nu-info" name="nutrientsInfo">${nuList.nutrientsInfo}</div>
                            <div class="main-nu-effect" name="nutrientsEffect">${nuList.nutrientsEffect}</div>
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
        
        </c:forEach>
        </c:when>    
      </c:choose>
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
            <c:when test = "${not empty prList}">
            <c:forEach var = "prList" items ="${prList}" begin="0" end="2">
            <input type = "hidden" value = "${prList.precautionNumber}"/>

                <a href="${pageContext.request.contextPath}/precaution/precautionDetailOk.pr?precautionNumber=${prList.precautionNumber}" class="main-pc-detail">
                    <div class="main-detail-title" name="precautionTitle">${prList.precautionTitle}</div>
                    <div class="main-detail-nick" name="precautionNickname">${prList.doctorNickname}</div>
                    <div class="main-detail-date" name="precautionDate">${prList.precautionDate}</div>
                </a>
                </c:forEach>
                </c:when>    
              </c:choose>
            </div>
        </div>
        <div class="main-pc-cate">
            <div class="main-pc-title">
                <div class="main-pc-name">상담소</div>
                <a href="${pageContext.request.contextPath}/clinic/clinicListOk.cl" class="main-pc-all">
                    <div class="main-show-text">전체보기</div>
                    <img src="${pageContext.request.contextPath}/resources/img/more.png" alt="main-pc-more" class="main-all-img">
                </a>
            </div>
            
            <!-- 상담소 최신 3개글 -->
            <div class="main-pc-group">
            <c:choose>
            <c:when test = "${not empty clList}">
            <c:forEach var = "clList" items ="${clList}" begin="0" end="2">
            <input type = "hidden" value = "${clList.clinicNumber}"/>

                <a href="${pageContext.request.contextPath}/clinic/clinicDetailOk.cl?clinicNumber=${clList.clinicNumber}" class="main-pc-detail">
                    <div class="main-detail-title" name="clinicTitle">${clList.clinicTitle}</div>
                    <div class="main-detail-nick" name="memberNickname">${clList.memberNickname}</div>
                    <div class="main-detail-date" name="clinicDate">${clList.clinicDate}</div>
                </a>
                </c:forEach>
                </c:when>    
              </c:choose>
                
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