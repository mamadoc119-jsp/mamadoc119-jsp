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
<jsp:include page="../include/header.jsp" />
    <div style="display: flex;margin-top: 200px;margin-bottom: 170px;justify-content: center;">
        <div style="width: 900px;display: flex;flex-direction: column;">
            <div style="font-size: 45px;font-weight: bolder;margin-bottom: 30px;padding-left: 10px;">예방알림</div>
            <!-- 제목/등록날짜 -->
            <div style="display: flex;justify-content: space-between;border-bottom: 1px solid gray;padding: 10px;">
                <!-- 제목 -->
                <div style="font-size: 17px;font-weight: bold;">제목이 들어갑니다.</div>
                <!-- 등록날짜 -->
                <div style="font-size: 15px;color: gray;">2023.11.09</div>
            </div>
            <!-- 내용 -->
            <div style="padding: 10px;">
내용이 들어갑니다.<br>
내용이 들어갑니다.<br>
내용이 들어갑니다.<br>
내용이 들어갑니다.<br>
내용이 들어갑니다.<br>
내용이 들어갑니다.<br>
내용이 들어갑니다.<br>
내용이 들어갑니다.<br>
내용이 들어갑니다.<br>
내용이 들어갑니다.<br>
내용이 들어갑니다.<br>
내용이 들어갑니다.<br>
내용이 들어갑니다.<br>
내용이 들어갑니다.<br>
내용이 들어갑니다.
            </div>
            <!-- 수정/삭제 -->
            <div style="display: flex;justify-content: end;margin: 0 10px 10px 10px;">
                <!-- 수정 -->
                <form action="${pageContext.request.contextPath}/precaution/precautionModify.jsp">
                    <button class="modify-btn">수정</button>
                </form>
                <!-- 삭제 -->
                <form action="${pageContext.request.contextPath}/precaution/precautionaryNoticeList.jsp" onsubmit="return removeMsg();">
                    <button class="remove-btn">삭제</button>
                </form>
            </div>
        </div>
    </div>
<jsp:include page="../include/footer.jsp" />
<script src="${pageContext.request.contextPath}/resources/js/precautionDetail.js"></script>
</body>
</html>