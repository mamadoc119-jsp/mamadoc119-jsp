// 비밀번호 작성시
$('#pw').keyup(function(){
	// 비밀번호 수정시 비밀번호 확인 초기화
	$('.pwck-yes').css('display', 'none');
	$('.pwck-no').css('display', 'none');
	// 비밀번호 정규식
	var reg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d@$!%*#?&]{8,}$/;
	var pw = $('#pw').val();
	if(reg.test(pw)){
		$('.pw-no').css('display', 'none');
		$('.pw-yes').css('display', 'block');
	}else{
		$('.pw-yes').css('display', 'none');
		$('.pw-no').css('display', 'block');
	}
});

// 비밀번호 확인
$('#check-pw').keyup(function(){
	var pw = $('#pw').val();
	var checkPw = $('#check-pw').val();
	if(pw == checkPw){
		if(!pw){
			$('.pwck-no').css('display', 'none');
			$('.pwck-yes').css('display', 'none');
		}else{
			$('.pwck-no').css('display', 'none');
			$('.pwck-yes').css('display', 'block');
		}
	}else{
		$('.pwck-yes').css('display', 'none');
		$('.pwck-no').css('display', 'block');
	}
});

// 비밀번호 수정 가능 여부
$('#form').submit(function(){
	if($('.pw-yes').css('display') != 'block'){
		alert('비밀번호를 입력해주세요.');
		return false;
	}
	if($('.pwck-yes').css('display') != 'block'){
		alert('비밀번호를 확인해주세요.');
		return false;
	}
	alert('비밀번호가 변경되었습니다.');
});