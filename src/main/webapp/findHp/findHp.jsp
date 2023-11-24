<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>병원 찾기</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/findHp.css">
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f49922a8774592c118e15c56666d5011&libraries=services"></script>
    
</head>
<!-- 헤더(로그아웃) -->
<!-- 헤더 -->
<c:choose>
       <c:when test="${empty sessionScope}">
           <jsp:include page="../include/header.jsp" />
       </c:when>
       <c:otherwise>
       
           <jsp:include page="../include/headerLogin.jsp" />
       </c:otherwise>
   </c:choose>

<body>
    <!-- 카카오맵 api -->
    <main>
        <div class="map_wrap">	
        
            <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
        
            <div id="menu_wrap" class="bg_white">
                <div class="option">
                    <div>
                        <form onsubmit="searchPlaces(); return false;">
                            <input type="text" class="findHp-input" value="노원" id="keyword" size="15"
                            placeholder="지역명을 입력해주세요"> 
                            <button type="submit" class="findHp-input-button">
                                <img src="${pageContext.request.contextPath}/resources/img/search2.png" alt="findHp-search-img" class="findHp-search-img">
                            </button>
                        </form>
                    </div>
                </div>
                <hr>
                <ul id="placesList"></ul>
                <div id="pagination"></div>
            </div>
        </div>
    
    </main>
<!-- footer -->
<jsp:include page="../include/footer.jsp" />
<script defer src="${pageContext.request.contextPath}/resources/js/findHp.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</body>
</html>