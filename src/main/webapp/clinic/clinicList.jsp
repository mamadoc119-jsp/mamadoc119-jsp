<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상담소 리스트</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/counselingCenterList.css">
</head>
<body>

<!-- 헤더(로그아웃) -->
<c:if test="${sessionScope.doctorNumber == null && sessionScope.memberNumber == null}">
	<jsp:include page="/include/header.jsp" />
</c:if> -
<c:if test="${sessionScope.doctorNumber != null || sessionScope.memberNumber != null}">
	<jsp:include page="/include/headerLogin.jsp" />
</c:if>

		<!-- c:set에서 내용으로 파라미터 값을 넣으면, 문자열로 변환된 후 저장된다. -->
		<!-- c:set value속성에 값을 넣으면, 해당 값의 타입이 그대로 유지된다. -->
		<c:set var="totalCount" value="${totalCount}"/>
		<c:set var="realEndPage" value="${realEndPage}"/>
		<c:set var="startPage" value="${startPage}"/>
		<c:set var="endPage" value="${endPage}"/>
		<c:set var="nowPage" value="${nowPage}"/>
		<c:set var="boardList" value="${clinicList}"/>
		
    <div class="counseling-full-container">
        <!--상담소 타이틀-->
        <div class="counseling-origin-box">
            <div class="counseling-origin-title">
                <div class="counseling-title">상담소</div>
                <div class="counseling-sub-title">상담이 필요하시면 언제든지 글을 써주세요</div>
            </div>

    <form action="" method="get"> <!--form 필요할까... 일단 넣어놨음-->

        <!--제목.작성자로 드롭다운 및 찾기 검색 부분-->
        <div class="counseling-search-full-container">
            <div> <!--드롭다운-->
                <select class="drop-div" name="cate" id="">
                    <option value="title">제목</option>
                    <option value="writer">작성자</option>
                </select>
            </div>

           <!--인풋 검색창-->
                <input type="text" placeholder="검색어 입력" name="keyword" size="80px">
        
            <div>
                <button type="submit" class="search-button">검색</button>
            </div>
        </div>
    </form>

        <!--테이블로 글제목 등등 리스트 부분-->
        <div class="counseling-list-full-container">
            <table>
                <thead style="background-color:#999999;">
                    <tr>
                        <th width="500px" class="title">글제목</th>
                        <th width="200px">작성자</th>
                        <th width="150px">작성일자</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach var="clinic" items="${clinicList}">
                    <tr>
                        <td class="counse-title-contents">
                       
                        	<c:if test="${not empty sessionScope.memberNumber || not empty sessionScope.doctorNumber}">
							    <a href="${pageContext.request.contextPath}/clinic/clinicDetailOk.cl?clinicNumber=${clinic.clinicNumber}">
							        ${clinic.clinicTitle}
							    </a>
							</c:if>
							<c:if test="${empty sessionScope.memberNumber && empty sessionScope.doctorNumber}">
							    <a href="#" onclick="showLoginAlert()">
							        ${clinic.clinicTitle}
							    </a>
							</c:if>              
                        
                        <td align="center">${clinic.memberNickname}</td>
                        <td align="center">${clinic.clinicDate}</td>
                        
                    </tr>
                       </c:forEach>
                </tbody>
           
               
            </table>  
        </div>
        
        	<c:if test="${not empty sessionScope.memberNumber}">
	        <div class="write-down-div">
		       	<button class="write-down"><a href="${pageContext.request.contextPath}/clinic/clinicWrite.jsp">글쓰기</a></button>
	        </div>
 			 </c:if>


            <!--페이징 처리부분-->
    	<div style="display: flex;  justify-content: center;">
    		<table style="font-size:1.3rem">
							<tr align="center" valign="middle">
									<td>
									<c:if test="${nowPage > 1}">
										<a href="${pageContext.request.contextPath}/clinic/clinicListOk.cl?page=${nowPage-1}&cate=${cate}&keyword=${keyword}">&lt;</a>
									</c:if>
									
									<c:forEach var="i" begin="${startPage}" end="${endPage}">
											<c:choose>
												<c:when test="${i eq nowPage}">
													<c:out value="[${i}]"/>&nbsp;
												</c:when>
												<c:otherwise>
													<a href="${pageContext.request.contextPath}/clinic/clinicListOk.cl?page=${i}&cate=${cate}&keyword=${keyword}"><c:out value="${i}"/></a>
												</c:otherwise>
											</c:choose>
									</c:forEach>
									
									<c:if test="${nowPage != realEndPage}">
										<a href="${pageContext.request.contextPath}/clinic/clinicListOk.cl?page=${nowPage+1}&cate=${cate}&keyword=${keyword}">&gt;</a>
									</c:if>
									</td>
								</tr>
							</table>
    </div>



        </div>
    </div>
<!-- footer -->
<jsp:include page="../include/footer.jsp" />

</body>

<script>
function showLoginAlert(){
	alert("로그인이 필요합니다. 로그인 먼저 해주세요");
}
</script>
</html>