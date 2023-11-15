function registMsg(){
    var title = document.getElementById('title').value;
    var content = document.getElementById('summernote').value;
    if(title == ""){
        alert('제목을 입력해주세요.');
        return false;
    }else if(content == ""){
        alert('내용을 입력해주세요.');
        return false;
    }else{
        alert('등록되었습니다.');
    }
}