// 글 삭제 알림
function removeMsg(){
    if(confirm('정말 삭제하시겠습니까?')){
        alert('삭제되었습니다.');
    }else{
        return false
    };
}

// 댓글 등록
function registReply(){}

// 댓글 삭제
function removeReply(){
    if(confirm('정말 삭제하시겠습니까?')){
        alert('삭제되었습니다.');
    }else{
        return false
    };
}

$(function(){
    // 토글
    $(".toggle").on('click', function(e){
        console.log(e.target.id);
        toggleBtns(e);
    });

    // 댓글 수정 버튼
    $(".reply").on('click', function(e){
        console.log(e.target.id);
        modifyReplyBtn(e);
        $(this).css('display', 'none');
        console.log(this.nextElementSibling.lastElementChild);
        $(this.nextElementSibling.lastElementChild).css('display', 'none');
    });
});

function toggleBtns(e){
    var toggleId = e.target.id;
    var toggleBtn = document.getElementById(toggleId);
    var modify = toggleBtn.nextElementSibling.firstElementChild;
    var remove = toggleBtn.nextElementSibling.lastElementChild.lastElementChild;
    var modifyBtn = toggleBtn.parentElement.nextElementSibling.lastElementChild.lastElementChild;
    console.log(modify);
    console.log(remove);
    console.log(modifyBtn);
    console.log($(modifyBtn).prop('tagName'));
    
    if($(modifyBtn).prop('tagName') == 'BUTTON'){
        if($(remove).css('display') == 'none'){
            $(remove).css('display', 'block');
        }else{
            $(remove).css('display', 'none');
        }
    }else{
        if($(modify).css('display') == 'none'){
            $(modify).css('display', 'block');
            $(remove).css('display', 'block');
        }else{
            $(modify).css('display', 'none');
            $(remove).css('display', 'none');
        }
    }
}

function modifyReplyBtn(e){
    var areaId = e.target.id;
    var areaBtn = document.getElementById(areaId);
    var area = areaBtn.parentElement.parentElement.nextElementSibling.firstElementChild;
    console.log(area);
    $(area).contents().unwrap().wrap("<textarea class='reply-textarea'></textarea>");

    var btnId = e.target.id;
    var btnBtn = document.getElementById(btnId);
    var btn = btnBtn.parentElement.parentElement.nextElementSibling.lastElementChild.firstElementChild;
    console.log(btn);
    $(btn).after("<button class='reply-modify-btn'>수정</button>");

    var modifyId = e.target.id;
    var modifyBtn = document.getElementById(modifyId);
    var modify = modifyBtn.parentElement.parentElement.nextElementSibling;
    console.log(modify);
    $(modify).contents().unwrap().wrapAll("<form action='${pageContext.request.contextPath}/counselingCenter/counselingCenterDetail.jsp' class='reply-form'></form>");
}