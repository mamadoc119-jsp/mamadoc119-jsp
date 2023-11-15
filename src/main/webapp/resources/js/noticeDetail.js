// 글 삭제 알림
function removeMsg(){
    if(confirm('정말 삭제하시겠습니까?')){
        alert('삭제되었습니다.');
    }else{
        return false
    };
}