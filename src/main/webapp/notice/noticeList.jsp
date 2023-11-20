<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>notice list</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/noticeList.css">
</head>
<body>
<jsp:include page="../include/header.jsp" />

    <div class="notice-full-container">
        <!--예방알림 타이틀-->
        <div class="notice-origin-box">
            <div class="notice-origin-title">
                <div class="notice-title">공지사항</div>
        </div>

        <!--테이블로 글제목 등등 리스트 부분-->
        <div class="notice-list-full-container">
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
                   <c:when test="${not empty adNoticeList}">
	                   	<c:forEach var="adNotice" items="${adNoticeList}" varStatus="status">
	                    <tr>
	                        <td class="title-contents"><a href="${pageContext.request.contextPath}/notice/noticeDetail.adno?noticeNumber=${adNotice.noticeNumber}"><c:out value="${adNotice.noticeTitle}"/></a></td>
	                        <td align="center">관리자</td>
	                        <td align="center"><c:out value="${adNotice.noticeDate}"/></td>
	                    </tr>
	                    </c:forEach>
                    </c:when>
                 </c:choose>
                </tbody>
            </table>
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