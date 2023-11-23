function deleteDo(precautionNumber){
	
	let confirmDelete = confirm(precautionNumber+"번 게시물을 삭제하시겠습니까?");
	console.log("precautionNumber : "+precautionNumber);
	if (confirmDelete){
		$.ajax({
			url:"/mamadoc/admin/adPrDelete.adpr",
			type: "GET",
			data:{precautionNumber:precautionNumber},
			success:function(request){
				console.log("precautionNumber : "+precautionNumber);
				alert(precautionNumber+"번 게시물이 삭제 되었습니다.");
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