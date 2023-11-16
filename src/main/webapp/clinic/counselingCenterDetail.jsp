<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상담소</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/counselingCenterDetail.css">
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../include/header.jsp" />
    <div style="display: flex;margin-top: 200px;margin-bottom: 170px;justify-content: center;">
        <div style="width: 900px;display: flex;flex-direction: column;">
			<div style="font-size: 45px;font-weight: bolder;margin-bottom: 30px;padding-left: 10px;">상담소</div>
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
                <form action="${pageContext.request.contextPath}/clinic/counselingCenterModify.jsp">
                    <button class="modify-btn">수정</button>
                </form>
                <!-- 삭제 -->
                <form action="" onsubmit="return removeMsg();">
                    <button class="remove-btn">삭제</button>
                </form>
            </div>
            <!-- 댓글작성/댓글리스트 -->
            <div style="border-top: 1px solid gray;">
                <div style="margin: 20px 10px 10px 10px;font-size: 17px;font-weight: bold;">댓글쓰기</div>
                <!-- 로그인 안하면 보이기(고민중) -->
                <!-- 로그인 하면 보이기 -->
                <form action="" onsubmit="return registReply()">
                    <div style="display: flex;flex-direction: column;border: 1px solid gray;height: 150px;margin-bottom: 10px;">
                        <!-- 로그인된 닉네임 -->
                        <div style="margin-top: 10px;margin-left: 10px;font-size: 15px;font-weight: bold;">로그인닉네임</div>
                        <!-- 댓글 작성 창 -->
                        <textarea style="height: 100%;border: none;resize: none;margin: 10px;"></textarea>
                        <!-- 댓글 등록 -->
                        <div style="display: flex;justify-content: end;">
                            <button class="regist-btn">등록</button>
                        </div>
                    </div>
                </form>
                <!-- 댓글반복시작 -->
                <div style="border-bottom: 1px solid gray;padding: 10px;position: relative;">
                    <div style="display: flex;justify-content: space-between;">
                        <div style="display: flex;align-items: center;font-size: 15px;font-weight: bold;">댓글닉네임</div>
                        <!-- 해당 댓글 pk를 id에 넣기 -->
                        <input type="button" value="댓글" class="toggle" id="11">
                        <div style="position: absolute;display: flex;flex-direction: column;right: 10px;top: 38px;">
                            <input type="button" value="수정" class="reply" id="10">
                            <form action="${pageContext.request.contextPath}/clinic/counselingCenterList.jsp" onsubmit="return removeReply();">
                                <!-- 댓글 pk -->
                                <input type="hidden" value="1">
                                <button class="remove" id="10">삭제</button>
                            </form>
                        </div>
                    </div>
                    <!-- form으로 바꿀 div -->
                    <div class="form">
                        <!-- 수정 누르면 textarea -->
                        <div style="padding: 10px 0;" id="modify-reply">안녕하세요</div>
                        <div style="display: flex;justify-content: space-between;">
                            <div style="display: flex;align-items: center;font-size: 15px;color: gray;">방금 전</div>
                        </div>
                    </div>
                </div>
                <!-- 댓글반복끝 -->
            </div>
        </div>
    </div>
<jsp:include page="../include/footer.jsp" />
<script src="${pageContext.request.contextPath}/resources/js/counselingCenterDetail.js"></script>
</body>
</html>