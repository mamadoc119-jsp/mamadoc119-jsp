<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예방알림</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/precautionModify.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
    <div style="display: flex;margin-top: 200px;margin-bottom: 170px;justify-content: center;">
        <div style="width: 900px;display: flex;flex-direction: column;">
			<div style="font-size: 45px;font-weight: bolder;margin-bottom: 30px;padding-left: 10px;">예방알림</div>
            <form action="${pageContext.request.contextPath}/precaution/precautionModifyOk.pr" onsubmit="return modifyMsg();">
                <!-- 제목/등록날짜 -->
                <div style="display: flex;">
                    <!-- 제목 -->
                    <input type="text" class="title" id="title" placeholder="제목을 입력하세요." name="precautionTitle" readonly>
                    ${precaution.precautionTitle}</input>
                </div>
                <!-- 내용 -->
                <textarea id="summernote" class="summernote" name="precautionContent">${precaution.precautionContent}</textarea>
                <!-- 이전/수정 -->
                <div style="display: flex;justify-content: space-between;margin-top: 10px;">
                    <!-- 이전 -->
                    <input type="button" class="previous-btn" onclick="history.back()" value="이전">
                    <!-- 수정 -->
                    <button class="modify-btn">수정</button>
                </div>
            </form>
        </div>
    </div>
<script src="${pageContext.request.contextPath}/resources/js/precautionModify.js"></script>
<script>
    $('#summernote').summernote({
        placeholder: '내용을 입력하세요.',
        tabsize: 2,
        height: 500,
        focus: true,
        disableResizeEditor: true,
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline', 'clear']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture', 'video']],
            ['view', ['fullscreen', 'codeview', 'help']]
        ]
    });
</script>
</body>
</html>