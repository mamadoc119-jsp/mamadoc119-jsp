function deleteDo(noticeNumber){
	
	let confirmDelete = confirm(noticeNumber+"번 게시물을 삭제하시겠습니까?");
	console.log("noticeNumber : "+noticeNumber);
	if (confirmDelete){
		$.ajax({
			url:"/mamadoc/admin/adNoticeDelete.adno",
			type: "GET",
			data:{noticeNumber:noticeNumber},
			success:function(request){
				console.log("noticeNumber : "+noticeNumber);
				alert(noticeNumber+"번 게시물이 삭제 되었습니다.");
				location.reload();
			},
			error:function(){
				alert("오류!");
				
			}
			
		});
	}else{
		alert("삭제를 취소하셨습니다");
	}
};