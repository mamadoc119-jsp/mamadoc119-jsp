function deleteNu(nutrientsNumber){
	
	let confirmDelete = confirm(nutrientsNumber+"번 영양제 게시글을 삭제하시겠습니까?");
	
	if (confirmDelete){
		$.ajax({
			url:"/mamadoc/adminNutrientsDelete.adnu",
			type: "GET",
			data:{nutrientsNumber:nutrientsNumber},
			success:function(response){
				console.log("nutrientsNumber : "+nutrientsNumber);
				alert(nutrientsNumber+"번 글 삭제 성공!");
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