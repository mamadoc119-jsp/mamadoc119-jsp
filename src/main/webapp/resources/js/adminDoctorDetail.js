/*가입승인 거부 및 회원정보 삭제*/
function rejectDoctor(contextPath, doctorNumber, doctorStatus) {
		
		let confirmDelete = confirm(doctorNumber+"번 회원정보를 삭제하시겠습니까?");
		
		if (confirmDelete){
			 var url = contextPath + "/adminDoctorDelete.addo?doctorNumber=" + doctorNumber + "&doctorStatus=" + doctorStatus;
        	 location.href = url;
		}else{
			alert("삭제를 취소하셨습니다");
		}
       
    }

/*의료인 가입승인*/
function approveDoctor(contextPath, doctorNumber) {
		
		let confirmApprove = confirm(doctorNumber+"번 대기회원의 가입을 승인하시겠습니까?");
		
		if (confirmApprove){
			 var url = contextPath + "/adminDoctorApprove.addo?doctorNumber=" + doctorNumber;
        	 location.href = url;
		}else{
			alert("승인을 취소하셨습니다");
		}
       
    }


function detailFile(){
    let clickedImage = $(event.target);
    let fileName = clickedImage.attr('src');
    let fileNumber = clickedImage.data('number');

    $('.modal').html(`
        <span class="close">&times;</span>
        <img src="../resources/img/backImg2.png" data-number="" width="60%" height="650px" style="margin-left: 300px; margin-top:50px; "/>`);
    $('.modal').css('display', 'block');
};

// 모달 닫기
$('.right-container').on('click', '.close', function() {
    $('.modal').css('display', 'none');
});

$('.back-btn').on('click', function (){
    window.history.back();
});

