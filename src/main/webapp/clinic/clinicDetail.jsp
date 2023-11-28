<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상담소</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/counselingCenterDetail.css">
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<style>
	@font-face {
    font-family: 'omyu_pretty';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-01@1.0/omyu_pretty.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
	}

	*{
    font-family: 'omyu_pretty';
	}
	</style>
</head>
<body>

			
<!-- 헤더(로그아웃) -->
<c:if test="${sessionScope.doctorNumber == null && sessionScope.memberNumber == null}">
	<jsp:include page="/include/header.jsp" />
</c:if> -
<c:if test="${sessionScope.doctorNumber != null || sessionScope.memberNumber != null}">
	<jsp:include page="/include/headerLogin.jsp" />
</c:if>


	<c:set var="clinicDetail" value="${clinicDetail}"/>

    <div style="display: flex;margin-top: 200px;margin-bottom: 170px;justify-content: center;">
        <div style="width: 900px;display: flex;flex-direction: column;">
			<div style="font-size: 45px;font-weight: bolder;margin-bottom: 30px;padding-left: 10px;">상담소</div>

 
            <!-- 제목/등록날짜 -->
            <div style="display: flex;justify-content: space-between;border-bottom: 1px solid gray;padding: 10px;">
                <!-- 제목 -->
                <div style="font-size: 17px;font-weight: bold;">${clinicDetail.clinicTitle}</div>
                <!-- 등록날짜 -->
                <div style="font-size: 15px;color: gray;">${clinicDetail.clinicDate}</div>
            </div>
            <!-- 내용 -->
            <div style="padding: 10px;">
				${clinicDetail.clinicContent}
            </div>
            
            
            <div style="display: flex;justify-content: end;margin: 0 10px 10px 10px;">
                   <!-- 삭제 -->
             <c:if test="${sessionScope.memberNumber == clinicDetail.memberNumber}">
	              <form action="${pageContext.request.contextPath}/clinic/clinicDeleteOk.cl?clinicNumber=${clinicDetail.getClinicNumber()}" onsubmit="return removeMsg();">
	                   <input type="hidden" name="clinicNumber" value="${clinicDetail.getClinicNumber()}">
	                   <button class="remove-btn">삭제</button>
	              </form>
           		</c:if>
        
            
          
                <!-- 수정 -->  
             <c:if test="${sessionScope.memberNumber == clinicDetail.memberNumber}">
		        <form action="${pageContext.request.contextPath}/clinic/clinicModify.cl?clinicNumber=${clinicDetail.getClinicNumber()}" method="get">
		            <input type="hidden" name="clinicNumber" value="${clinicDetail.getClinicNumber()}">
		            <button class="modify-btn">수정</button>
		        </form>
		    </c:if>
               
            </div>
         
           
            
            
            <!-- 댓글작성/댓글리스트-->
            
            <div style="border-top: 1px solid gray;">
                <div style="margin: 20px 10px 10px 10px;font-size: 17px;font-weight: bold;"></div>
            
              
                <form action="#" method="post" onsubmit="return registReply()">
                    <div style="display: flex;flex-direction: column;border: 1px solid gray;height: 150px;margin-bottom: 10px;">
                        <!-- 로그인된 닉네임 -->
                        <div style="margin-top: 10px;margin-left: 10px;font-size: 15px;font-weight: bold;">댓글</div>
                        <!-- 댓글 작성 창 -->
                        <textarea class="invert"  name="content" placeholder="댓글은 100자까지 작성이 가능합니다."  style="height: 100%;border: none; resize: none;margin: 10px;" maxlength="100" ></textarea>
                        <!-- 댓글 등록 -->
                        <div style="display: flex;justify-content: end;">
                    	    <input id="register" type="button"class="regist-btn"  value="등록"  onclick="comment()"/>
                        </div>
                    </div>
                </form>
                	<form id="replies" class="combined" style="flex-direction:column; margin:0; display:contents; "></form>
            </div>
        </div>
    </div>

<jsp:include page="../include/footer.jsp" />
<script src="${pageContext.request.contextPath}/resources/js/counselingCenterDetail.js"></script>
<script>

/*문서가 준비되면 댓글 리스트를 보여준다*/
$(document).ready(function() {
    getList();
});

/*경로설정*/
let pageContext = "${pageContext.request.contextPath}";
let clinicNumber = "${clinicDetail.getClinicNumber()}";

function getList() {
    $.ajax({
        url: pageContext + "/clinic/ClinicConmmentListOk.cl?clinicNumber=" + clinicNumber,
        type: "get",
        dataType: "json",
        success: showList 
        /*성공하면 리스트를 보여준다*/
    });
}


/*댓글 리스트*/
let commentList;

function showList(comments){
	commentList = comments;
	let text ="";
	if(comments != null && comments.length !=0 ){
		$.each(comments, function(index, comment){
			text += "<div id ='comment'>";
		    text += "<p class='writer'>" + (comment.memberNickname || comment.doctorNickname) + "</p>";
			text += "<div class='content' id='" + (index + 1) +"' style='width:100%'><pre>" + comment.commentContent + "</pre></div>"
			
			if("${sessionScope.doctorNumber}" == comment.doctorNumber){
				
				text += "<input type='button' id='ready" + (index + 1) + "' class='modify-btn' onclick=readyToUpdate(" + (index + 1) + ") value='수정'>";
				text += "<input type='button' id='ok" + (index + 1) + "' class='regist-btn' style='display:none'  onclick=update(" + (index + 1) + "," + comment.commentNumber + ") value='수정완료'>";
				text += "<input type='button' id='remove" + (index + 1) + "' class='remove-btn' onclick=deleteReply(" + comment.commentNumber + ") value='삭제'>";
			}else if("${sessionScope.memberNumber}" == comment.memberNumber) {
				text += "<input type='button' id='ready" + (index + 1) + "' class='modify-btn' onclick=readyToUpdate(" + (index + 1) + ") value='수정'>";
				text += "<input type='button' id='ok" + (index + 1) + "' class='regist-btn' style='display:none'  onclick=update(" + (index + 1) + "," + comment.commentNumber + ") value='수정완료'>";
				text += "<input type='button' id='remove" + (index + 1) + "' class='remove-btn' onclick=deleteReply(" + comment.commentNumber + ") value='삭제'>";
			}
			text += "</div><hr>";
		});
		
	}else{
		text = "<p>댓글이 없습니다.</p>";
	}
	
	$("#replies").html(text);
}


/*댓글 작성*/ 
function comment(){
	let commentContent = $("textarea[name='content']").val();
	
	$.ajax({
		url: pageContext + "/clinic/CommentWriteOk.cl",
		type :"post",
		data: {"clinicNumber": clinicNumber, "commentContent" : commentContent},
		success: function(){
			$("textarea[name='content']").val("");
			getList();
		}
		
	});
}


let check =false;
/*댓글 수정하기*/

function readyToUpdate(index){
	let div = $("#" + index);
	let modifyReady = $("#ready" + index);
	let modifyOk = $("#ok" + index);
	let remove = $("#remove" + index);
	
	if(!check){
		div.replaceWith("<textarea name='commentContent' id='" + index + "' class='invert' style='border-radius:0; resize:none;'>" + div.text() + "</textarea>");	
		modifyReady.hide();
		modifyOk.show();
		check = true;
	}else {
		alert("수정중인 댓글이 있습니다.");
	}
	
}


//수정 완료
function update(index, commentNumber){
	let commentContent = $("textarea#" + index).val();
	let json = new Object();
	
	json.commentNumber = commentNumber;
	json.commentContent = commentContent;
	
	//댓글수정중에 빈칸이 입력되면
	if(commentContent.trim()===""){
		alert("내용을 입력해주세요");
		return;
	}
	
	$.ajax({
		url: pageContext + "/clinic/CommentModifyOk.cl",
		type: "post",
		data: json,
		success: function(){
			check = false;
			getList();
		}
	});
}


//삭제
function deleteReply(commentNumber){
	$.ajax({
		url: pageContext + "/clinic/CommentDeleteOk.cl",
		type: "post",
		data: {"commentNumber": commentNumber},
		success: function(){
			getList();
			}
		});
	}



</script>
</body>
</html>