<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>notice list</title>
	<style>
		*{
    margin: 0;
    padding: 0;
	 font-family: 'omyu_pretty';
	 font-size:18px;
	}
	@font-face {
    font-family: 'omyu_pretty';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-01@1.0/omyu_pretty.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
	}


.notice-full-container{
    margin-top: 200px;
}

.notice-origin-box{
    margin: 0 auto;
    width: 1200px;
  
}

a{
	text-decoration:none;
	color:black;
}
.notice-title{
    font-weight: bolder;
    font-size: 45px;
    margin-bottom: 5px;
}

.notice-origin-title{
    margin-left: 140PX;
    width: 910px;
    text-align: center;
}

.notice-list-full-container{
    display: flex;
    justify-content: center;
    margin-top: 45px;
}

th, td{
height: 50px;
}

.title-contents{
padding-left: 10px;
}

.write-down-div{
display: flex;
justify-content: right;
margin-right: 180px;
margin-top: 10px;

}

.write-down{
    background-color: #f9bb00;
    border-radius: 5px;
    cursor: pointer;
    outline: none;
    width: 70px;
    border: 0px;
    height: 38px;
}

a{
    text-decoration: none;
    color: black;
}


/*페이징처리 위치 참고*/
.paging-part{
    border: 1px solid black;
    width: 500px;
    height: 50px;
    margin: 0 auto;
}
		
	</style>
</head>
<body>
<!-- 헤더 -->
<!-- 헤더 -->   
<c:if test="${sessionScope.doctorNumber == null && sessionScope.memberNumber == null}">
	<jsp:include page="/include/header.jsp" />
</c:if>
<c:if test="${sessionScope.doctorNumber != null || sessionScope.memberNumber != null}">
	<jsp:include page="/include/headerLogin.jsp" />
</c:if>

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
                 <c:choose>
                   <c:when test="${not empty adNoticeList}">
	                   	<c:forEach var="adNotice" items="${adNoticeList}" varStatus="status">
                <tbody>
	                    <tr>
	                        <td class="title-contents"><a href="${pageContext.request.contextPath}/notice/noticeDetail.adno?noticeNumber=${adNotice.noticeNumber}"><c:out value="${adNotice.noticeTitle}"/></a></td>
	                        <td align="center">관리자</td>
	                        <td align="center"><c:out value="${adNotice.noticeDate}"/></td>
	                    </tr>
                </tbody>
                 </c:forEach>
                    </c:when>
                 </c:choose>
            </table>
        </div>


        <!--페이징 처리부분-->
	   	<div style="display: flex;  justify-content: center;">
	   		<table style="font-size:1.3rem">
				<tr align="center" valign="middle">
					<td>
						<c:if test="${nowPage > 1}">
							<a href="${pageContext.request.contextPath}/notice/noticeList.adno?page=${nowPage-1}">&lt;</a>
						</c:if>
						
						<c:forEach var="i" begin="${startPage}" end="${endPage}">
								<c:choose>
									<c:when test="${i eq nowPage}">
										<c:out value="[${i}]"/>&nbsp;
									</c:when>
									<c:otherwise>
										<a href="${pageContext.request.contextPath}/notice/noticeList.adno?page=${i}"><c:out value="${i}"/></a>
									</c:otherwise>
								</c:choose>
						</c:forEach>
						
						<c:if test="${nowPage != realEndPage}">
							<a href="${pageContext.request.contextPath}/notice/noticeList.adno?page=${nowPage+1}">&gt;</a>
						</c:if>
					</td>
				</tr>
			</table>
		 </div>


        </div>
    </div>
    <!-- footer -->
<jsp:include page="../include/footer.jsp" />
</body>
</html>