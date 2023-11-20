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
<c:choose>
       <c:when test="${empty sessionScope}">
           <jsp:include page="../include/header.jsp" />
       </c:when>
       <c:otherwise>
       
           <jsp:include page="../include/headerLogin.jsp" />
       </c:otherwise>
   </c:choose>

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
                <select class="drop-div">
                    <option value="title">제목</option>
                    <option value="writer">작성자</option>
                </select>
            </div>

            
                <input type="text" placeholder="검색어 입력" name="pre-search" size="80px">
           
            <div>
                <button type="button" class="search-button">검색</button>
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
				<c:forEach var = "precaution" items ="${precautionList}">
				<input type = "hidden" value = "${precaution.precautionNumber}"/>
					<a href="${pageContext.request.contextPath}/precaution/precautionDetail.pr?precautionNumber=${precaution.precautionNumber}">
                    <tr>
                        <td class="pre-title-contents">
                        ${precaution.precautionTitle}</td>
                        <td align="center">${precaution.doctorNickname}</td>
                        <td align="center">${precaution.precautionDate}</td>
                    </tr>
                    </a>
                    
                </c:forEach>
          		</c:when> 	
        		</c:choose>
                </tbody>
            </table>
        </div>
        <div class="write-down-div">
            <button class="write-down" type="button" onclick="location.href='./precautionWrite.jsp'">글쓰기</button>
        </div>


          <!--페이징 처리부분-->
          <div class="paging-part">

          </div>

          
        </div>
    </div>
    <!-- footer -->
<jsp:include page="../include/footer.jsp" />
</body>
</html>