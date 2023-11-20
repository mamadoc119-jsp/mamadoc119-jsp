function deleteMe(memberNumber){
	
	let confirmDelete = confirm(memberNumber+"번 회원정보를 삭제하시겠습니까?");
	console.log("memberNumber : "+memberNumber);
	if (confirmDelete){
		$.ajax({
			url:"/mamadoc/adminMemberDeleteOk.adme",
			type: "GET",
			data:{memberNumber:memberNumber},
			success:function(response){
				console.log("memberNumber : "+memberNumber);
				alert(memberNumber+"번 회원 정보 삭제 성공!");
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