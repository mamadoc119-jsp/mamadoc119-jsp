<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 영양제 정보 수정</title>
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
            <a href="${pageContext.request.contextPath}/admin/adminMC.jsp">게시글 관리</a>
            <a href="${pageContext.request.contextPath}/adminDoctorApply.addo">신청함 관리</a>
            <a href="${pageContext.request.contextPath}/adminNutrientsWrite.adnu">게시판 등록</a>
          </nav>
        </div>
        <a href="${pageContext.request.contextPath}/adminLogoutOk.ad">Logout</a>
      </header>
<div class="main-container">
    <div class="left-container">
        <div class="left-list check"><a href="${pageContext.request.contextPath}/adminNutrients.adnu">영양제 관리</a></div>
    </div>
    <div class="right-container">
        <div class="all-container"> 
            <form id="form" action="${pageContext.request.contextPath}/adminNutrientsUpdateOk.adnu?nutrientsNumber=${nu.nutrientsNumber}" method ="post" enctype="multipart/form-data"><!--서버에 보내기 위해 form 태그를 사용함-->
                <table><!--테이블 이용 10행, 2열의 표를 만듬-->
                    <tr><!--tr은 하나의 행을 의미함-->
                        <th colspan="2">영양제 정보 수정</th><!--th 제목의 셀을 의미함, colspan=2는 2칸의 셀은 가로로 병합을 의미-->
                    </tr>
                    <tr>
                        <th>영양제명</th>
                        <td><input type="text" placeholder="영양제명을 입력해주세요" id="nutrientsTitle" 
                        name="nutrientsName" value="${nu.nutrientsName}" required></td><!--td는 하나의 셀을 의미-->
                        <!--input text를 이용해 text를 받을 수 있고 placeholder를 이용해 작성 전 안내문구를 표시할 수 있다-->
                    </tr>
                    
                    <tr>
                        <th>영양제사진</th>
                        <td><input type="file" id="photo" name="nufile" accept="image/gif, image/jpeg, image/png"/></td>
                        <!--input file을 이용하여 파일을 업로드하여 사진을 불러올 수 있도록 함-->
                    </tr>
                    
                    <tr>
                        <th>효과</th>
                        <td><input type="text" placeholder="효과를 입력해주세요" id="nutrientsPerf" 
                        name="nutrientsEffect" value="${nu.nutrientsEffect}" required></td><!--td는 하나의 셀을 의미-->
                        <!--input text를 이용해 text를 받을 수 있고 placeholder를 이용해 작성 전 안내문구를 표시할 수 있다-->
                    </tr>
                    <tr>
                        <th>정보</th>
                        <td><input type="text" placeholder="영양제 정보를 입력해주세요" id="nutrientsInfo" 
                        name="nutrientsInfo" value="${nu.nutrientsInfo}" required>
                        <input type="hidden" name="nutrientsNumber" class="nu_number" value="${nu.nutrientsNumber}">
                        </td><!--td는 하나의 셀을 의미-->
                        <!--input text를 이용해 text를 받을 수 있고 placeholder를 이용해 작성 전 안내문구를 표시할 수 있다-->
                    </tr>
                </table>
                <div class="nu_img">
                <h3>첨부 이미지</h3>
	                <div class="post-images">
                    <!-- 이미지 예시 -->
                  		<img src="${pageContext.request.contextPath}/resources/upload/${img.nufileUuid}${img.nufileType}" data-number=${img.nufileNumber} class="post-image" />
                    <!-- /이미지 예시 -->
                </div>
            	</div>
            	
            	<div class="big-img-wrap">
	                <div class="big-img-box">
	                    <img src="" alt="" class="big-img">
	                </div>
            	</div>
                
                <div class="btn-container">
                <button type="submit" value="수정" id="btn"> 수정 </button>
                <!--button을 페이지리로딩과 폼제출을 막아줌 스크립트를 이용하여 입력한 값들을 전송합니다-->
                <!-- submit을 하면 작성했던 글들이 사라지는것을 방지하기 위함 -->
                </div>
            </form>
          </div>
        
    </div>
</div>
<script defer src="${pageContext.request.contextPath}/resources/js/adminNutrientsUpdate.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</body>
</html>