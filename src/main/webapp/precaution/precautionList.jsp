<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>precautionary notice list</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/precautionaryNoticeList.css">
</head>
<body>
<!-- 헤더 -->   
<c:if test="${sessionScope.doctorNumber == null && sessionScope.memberNumber == null}">
	<jsp:include page="/include/header.jsp" />
</c:if>
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


    <div class="precautionary-full-container">
        <!--예방알림 타이틀-->
        <div class="precautionary-origin-box">
            <div class="precautionary-origin-title">
                <div class="precautionary-title">예방 알림</div>
                <div class="precautionary-sub-title">최근에 유행하는 질병입니다. 조심조심!!</div>
        </div>

    <form> <!--form 필요할까... 일단 넣어놨음-->

        <!--제목.작성자로 드롭다운 및 찾기 검색 부분-->
        <div class="precautionary-search-full-container">
            <div> <!--드롭다운-->
                <select class="drop-div" name="cate">
                    <option value="title">제목</option>
                    <option value="writer">작성자</option>
                </select>
            </div>

            
                <input type="text" placeholder="검색어 입력" name="keyword" size="80px">
           
            <div>
                <button type="submit" class="search-button">검색</button>
            </div>
        </div>
    </form>

        <!--테이블로 글제목 등등 리스트 부분-->
        <div class="precautionary-list-full-container">
        
            <table>
                <thead style="background-color:#999999;">
                    <tr>
                        <th width="500px" class="title">글제목</th>
                        <th width="200px">작성자</th>
                        <th width="150px">작성일자</th>
                    </tr>
                </thead>
                
                
                <tbody>
                <c:choose>
				<c:when test = "${not empty precautionList}">
				<c:forEach var = "precaution" items ="${precautionList}" begin="0" end="10">
				<input type = "hidden" value = "${precaution.precautionNumber}"/>
					
                    <tr>
                        <td class="pre-title-contents"><a href="${pageContext.request.contextPath}/precaution/precautionDetailOk.pr?precautionNumber=${precaution.precautionNumber}">${precaution.precautionTitle}</a></td>
                        <td align="center">${precaution.doctorNickname}</td>
                        <td align="center">${precaution.precautionDate}</td>
                    </tr>
                    
                </c:forEach>
          		</c:when> 	
        		</c:choose>
                </tbody>
            </table>
        </div>
        
        <div class="write-down-div">
  		  <c:if test="${sessionScope.doctorNumber != null && sessionScope.doctorStatus == 1}">
        	<button class="write-down" type="button" onclick="location.href='./precautionWrite.pr'">글쓰기</button>
    	  </c:if>
		</div>


          <div style="display: flex;  justify-content: center;">
	   		<table style="font-size:1.3rem">
				<tr align="center" valign="middle">
					<td>
						<c:if test="${nowPage > 1}">
							<a href="${pageContext.request.contextPath}/precaution/precautionListOk.pr?page=${nowPage-1}&cate=${cate}&keyword=${keyword}">&lt;</a>
						</c:if>
						
						<c:forEach var="i" begin="${startPage}" end="${endPage}">
								<c:choose>
									<c:when test="${i eq nowPage}">
										<c:out value="[${i}]"/>&nbsp;
									</c:when>
									<c:otherwise>
										<a href="${pageContext.request.contextPath}/precaution/precautionListOk.pr?page=${i}&cate=${cate}&keyword=${keyword}"><c:out value="${i}"/></a>
									</c:otherwise>
								</c:choose>
						</c:forEach>
						
						<c:if test="${nowPage != realEndPage}">
							<a href="${pageContext.request.contextPath}/precaution/precautionListOk.pr?page=${nowPage+1}&cate=${cate}&keyword=${keyword}">&gt;</a>
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
</html>