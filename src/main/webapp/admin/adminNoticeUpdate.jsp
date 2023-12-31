<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 영양제 정보 등록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminMain.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminHeader.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminNoticeWrite.css"/>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
    
</head>
<body>
    <header class="header">
        <span class="logo">똥강아지</span>
        <div class="header-container">
          <nav class="header-nav">
             <a href="${pageContext.request.contextPath}/adminMain.adme">회원 관리</a>
            <a href="${pageContext.request.contextPath}/admin/adClinicList.adcl">게시글 관리</a>
            <a href="${pageContext.request.contextPath}/adminDoctorApply.addo">신청함 관리</a>
            <a href="${pageContext.request.contextPath}/admin/adminNutrientsWrite.jsp">게시판 등록</a>
          </nav>
        </div>
        <a href="${pageContext.request.contextPath}/adminLogoutOk.ad">Logout</a>
      </header>
<div class="main-container">
    <div class="left-container">
        <div class="left-list "><a href="${pageContext.request.contextPath}/admin/adminNutrientsWrite.jsp">영양제 등록</a></div>
        <div class="left-list check"><a href="${pageContext.request.contextPath}/admin/adminNoticeWrite.jsp">공지사항 등록</a></div>
    </div>
    <div class="right-container">
        <div class="all-container"> 
            <form id="form" action="AdNoticeUpdateOk.adno" method ="post"><!--서버에 보내기 위해 form 태그를 사용함--> 
            	<input type="hidden" name="noticeNumber" value="${noticeDetail.getNoticeNumber()}"/>
                <table><!--테이블 이용 10행, 2열의 표를 만듬-->
                    <tr><!--tr은 하나의 행을 의미함-->
                        <th colspan="2">공지사항 등록</th><!--th 제목의 셀을 의미함, colspan=2는 2칸의 셀은 가로로 병합을 의미-->
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td><input type="text" value="${noticeDetail.getNoticeTitle()}" placeholder="제목을 입력해주세요" id="noticeTitle" name="noticeTitle" required></td><!--td는 하나의 셀을 의미-->
                        <!--input text를 이용해 text를 받을 수 있고 placeholder를 이용해 작성 전 안내문구를 표시할 수 있다-->
                    </tr>
                    <tr>
                        <th>내용</th>
                        <!--textarea를 사용해 긴글을 작성 받게 합니다 / summernote로 바꿀까?-->
                        <td><textarea id="summernote" class="summernote" placeholder="내용을 입력해주세요" name="noticeContent">
                        <c:out value="${noticeDetail.getNoticeContent()}"/>
                        </textarea></td>
                    </tr>
                   
                </table>
                <div class="btn-container">
                <button  class="register-btn" type="submit" value="등록" id="btn"> 등록 </button>
                <!--button을 페이지리로딩과 폼제출을 막아줌 스크립트를 이용하여 입력한 값들을 전송합니다-->
                <!-- submit을 하면 작성했던 글들이 사라지는것을 방지하기 위함 -->
                </div>
            </form>
          </div>
        
    </div>
</div>
<script>
$('#summernote').summernote({
        placeholder: '내용을 입력하세요.',
        tabsize: 2,
        height: 500,
        focus: true,
        disableResizeEditor:true,
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