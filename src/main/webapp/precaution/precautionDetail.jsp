<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예방알림</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/precautionDetail.css">
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
    <input type = "hidden" value = "${precaution.precautionNumber}"/>
        <div style="width: 900px;display: flex;flex-direction: column;">
            <div style="font-size: 45px;font-weight: bolder;margin-bottom: 30px;padding-left: 10px;">예방알림</div>
            <!-- 제목/등록날짜 -->
            <div style="display: flex;justify-content: space-between;border-bottom: 1px solid gray;padding: 10px;">
                <!-- 제목 -->
                <div style="font-size: 17px;font-weight: bold;">${precaution.precautionTitle}</div>
                <!-- 등록날짜 -->
                <div style="font-size: 15px;color: gray;">${precaution.precautionDate}</div>
            </div>
            <!-- 내용 -->
            <div style="padding: 10px;">${precaution.precautionContent}</div>
            <!-- 수정/삭제 -->
            <div style="display: flex;justify-content: end;margin: 0 10px 10px 10px;">
            
                <!-- 수정 -->
                <c:if test="${sessionScope.doctorNumber == precaution.doctorNumber}">
                <form action="${pageContext.request.contextPath}/precaution/precautionModify.pr?precautionNumber=${precautionNumber}">
                <input type = "hidden" value = "${precaution.precautionNumber}" name="precautionNumber"/>
                    <button class="modify-btn">수정</button>
                </form>
                </c:if>
                
                <!-- 삭제 -->
                <c:if test="${sessionScope.doctorNumber == precaution.doctorNumber}">
                <form action="${pageContext.request.contextPath}/precaution/precautionDeleteOk.pr?precautionNumber=${precautionNumber}" onsubmit="return removeMsg();">              
                <input type = "hidden" value = "${precaution.precautionNumber}" name="precautionNumber"/>
                    <button class="remove-btn">삭제</button>
                </form>
                </c:if>
            </div>
        </div>
    </div>
<jsp:include page="../include/footer.jsp" />
<script src="${pageContext.request.contextPath}/resources/js/precautionDetail.js"></script>
</body>
</html>