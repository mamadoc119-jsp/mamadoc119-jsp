<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 영양제 정보 등록</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminMain.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminHeader.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminNutrientsWrite.css"/>
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
        <div class="left-list check"><a href="${pageContext.request.contextPath}/adminNutrientsWrite.adnu">영양제 등록</a></div>
        <div class="left-list"><a href="${pageContext.request.contextPath}/admin/adminNoticeWrite.jsp">공지사항 등록</a></div>
    </div>
    <div class="right-container">
        <div class="all-container"> 
            <form id="form" action="${pageContext.request.contextPath}/adminNutrientsWriteOk.adnu" method ="post" enctype="multipart/form-data"><!--서버에 보내기 위해 form 태그를 사용함--> 
                <table><!--테이블 이용 10행, 2열의 표를 만듬-->
                    <tr><!--tr은 하나의 행을 의미함-->
                        <th colspan="2">영양제 등록</th><!--th 제목의 셀을 의미함, colspan=2는 2칸의 셀은 가로로 병합을 의미-->
                    </tr>
                    <tr>
                        <th>영양제명</th>
                        <td><input type="text" placeholder="시설명을 입력해주세요" id="nutrientsTitle" name="nutrientsName" required></td><!--td는 하나의 셀을 의미-->
                        <!--input text를 이용해 text를 받을 수 있고 placeholder를 이용해 작성 전 안내문구를 표시할 수 있다-->
                    </tr>
                    
                    <tr>
                        <th>영양제사진</th>
                        <td><input type="file" id="photo" name="nufile" accept="image/gif, image/jpeg, image/png" required/></td>
                        <!--input file을 이용하여 파일을 업로드하여 사진을 불러올 수 있도록 함-->
                    </tr>
                    
                    <tr>
                        <th>효과</th>
                        <td><input type="text" placeholder="효과를 입력해주세요" id="nutrientsPerf" name="nutrientsEffect" required></td><!--td는 하나의 셀을 의미-->
                        <!--input text를 이용해 text를 받을 수 있고 placeholder를 이용해 작성 전 안내문구를 표시할 수 있다-->
                    </tr>
                    <tr>
                        <th>정보</th>
                        <td><input type="text" placeholder="영양제 정보를 입력해주세요" id="nutrientsInfo" name="nutrientsInfo" required></td><!--td는 하나의 셀을 의미-->
                        <!--input text를 이용해 text를 받을 수 있고 placeholder를 이용해 작성 전 안내문구를 표시할 수 있다-->
                    </tr>
                   
                   
                    <!-- <tr>
                        <th>효과</th>
                        textarea를 사용해 긴글을 작성 받게 합니다
                        <td><textarea id="nutrientsContent" placeholder="내용을 입력해주세요" name="nutrientsContent"></textarea></td>
                    </tr> -->
                   
                </table>
                <div class="btn-container">
                <button type="submit" value="등록" id="btn">등록 </button>
                <!--button을 페이지리로딩과 폼제출을 막아줌 스크립트를 이용하여 입력한 값들을 전송합니다-->
                <!-- submit을 하면 작성했던 글들이 사라지는것을 방지하기 위함 -->
                </div>
            </form>
          </div>
        
    </div>
</div>
</body>
</html>