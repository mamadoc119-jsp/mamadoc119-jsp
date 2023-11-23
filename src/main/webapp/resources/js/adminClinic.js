function deleteDo(clinicNumber){
	
	let confirmDelete = confirm(clinicNumber+"번 게시물을 삭제하시겠습니까?");
	console.log("clinicNumber : "+clinicNumber);
	if (confirmDelete){
		$.ajax({
			url:"/mamadoc/admin/adClinicDelete.adcl",
			type: "GET",
			data:{clinicNumber:clinicNumber},
			success:function(request){
				console.log("clinicNumber : "+clinicNumber);
				alert(clinicNumber+"번 게시물이 삭제 되었습니다.");
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