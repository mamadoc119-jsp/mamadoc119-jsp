<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/noticeDetail.css">
</head>
<body>
<!-- 헤더 -->
<c:if test="${sessionScope.doctorNumber == null && sessionScope.memberNumber == null}">
	<jsp:include page="/include/header.jsp" />
</c:if>
<c:if test="${sessionScope.doctorNumber != null || sessionScope.memberNumber != null}">
	<jsp:include page="/include/headerLogin.jsp" />
</c:if>
    <div style="display: flex;margin-top: 200px;margin-bottom: 170px;justify-content: center;">
        <div style="width: 900px;display: flex;flex-direction: column;">
            <div style="font-size: 45px;font-weight: bolder;margin-bottom: 30px;padding-left: 10px;">공지사항</div>
            <!-- 제목/등록날짜 -->
            <div style="display: flex; justify-content: space-between; border-bottom: 1px solid gray;padding: 10px;">
                <!-- 제목 -->
                <div style="font-size: 17px;font-weight: bold;"><c:out value="${noticeDetail.getNoticeTitle()}"/></div>
                <!-- 등록날짜 -->
                <div style="font-size: 15px;color: gray;"><c:out value="${noticeDetail.getNoticeDate()}"/></div>
            </div>
            <!-- 내용 -->
            <div style="padding: 10px;">
				<c:out value="${noticeDetail.getNoticeContent()}"  escapeXml='false'/>
            </div>
            <!-- 수정/삭제 -->
            <c:if test="${not empty sessionScope.adminNumber}">
			    <!-- 수정/삭제 태그들이 여기에 들어갑니다 -->
			    <div style="display: flex; justify-content: end; margin: 0 10px 10px 10px;">
			        <!-- 수정 -->
			        <form action="noticeUpdate.adno">
			            <input type="hidden" name="noticeNumber" value="${noticeDetail.getNoticeNumber()}"/>
			            <button class="modify-btn">수정</button>
			        </form>
			
			        <!-- 삭제 -->
			        <button class="remove-btn" onclick="location.href='${pageContext.request.contextPath}/admin/adNoticeDelete.adno?noticeNumber=${noticeDetail.getNoticeNumber()}'">삭제</button>
			    </div>
			</c:if>
        </div>
    </div>
<jsp:include page="../include/footer.jsp" />
<script src="${pageContext.request.contextPath}/resources/js/noticeDetail.js"></script>
</body>
</html>