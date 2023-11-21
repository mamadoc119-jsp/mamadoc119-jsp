function deleteDo(doctorNumber){
	
	let confirmDelete = confirm(doctorNumber+"번 회원정보를 삭제하시겠습니까?");
	console.log("doctorNumber : "+doctorNumber);
	if (confirmDelete){
		$.ajax({
			url:"/mamadoc/adminDoctorDeleteOk.addo",
			type: "GET",
			data:{doctorNumber:doctorNumber},
			success:function(response){
				console.log("doctorNumber : "+doctorNumber);
				alert(doctorNumber+"번 회원 정보 삭제 성공!");
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


function approve(doctorNumber){
	
	let confirmApprove = confirm(doctorNumber+"번 대기회원의 가입을 승인하시겠습니까?");
	console.log("doctorNumber : "+doctorNumber);
	if (confirmApprove){
		$.ajax({
			url:"/mamadoc/adminDoctorApproveOk.addo",
			type: "GET",
			data:{doctorNumber:doctorNumber},
			success:function(response){
				console.log("doctorNumber : "+doctorNumber);
				alert(doctorNumber+"번 대기회원 가입승인 성공!");
				location.reload();
			},
			error:function(){
				alert("오류!");
			}
			
		});
	}else{
		alert("승인을 취소하셨습니다");
	}
};