// 전체선택 체크
$('#check-all').on('click', function(){
	if($(this).is(':checked')){
		$('#check-use').prop('checked', true);
		$('#check-info').prop('checked', true);
	}else{
		$('#check-use').prop('checked', false);
		$('#check-info').prop('checked', false);
	}
});

// 이용약관 체크
$('#check-use').on('click', function(){
	if($(this).is(':checked')){
		if($('#check-info').is(':checked')){
			$('#check-all').prop('checked', true);
		}
	}else{
		$('#check-all').prop('checked', false);
	}
});

// 개인정보 체크
$('#check-info').on('click', function(){
	if($(this).is(':checked')){
		if($('#check-use').is(':checked')){
			$('#check-all').prop('checked', true);
		}
	}else{
		$('#check-all').prop('checked', false);
	}
});

// 주소 API 
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}

// 이메일 중복검사
$('#emailBtn').on('click', function(){
	var email = $('#memberEmail').val();
	console.log(email);
	
	if(!email){
		return false;
	}
	
	$.ajax({
		url: '/mamadoc/checkEmailOk.do',
		data: {doctorEmail: email},
		dataType: 'json',
		success: function(data){
			console.log(data.count);
			var exist = data.count;
			if(exist > 0){
				$('.email-no').css('display', 'block');
				$('.email-yes').css('display', 'none');
				alert('중복된 이메일입니다.');
			}else{
				$('.email-yes').css('display', 'block');
				$('.email-no').css('display', 'none');
				alert('사용가능한 이메일입니다.');
			}
		}
	});
});

// 이메일 수정시 중복검사와 이메일 인증 초기화
$('#memberEmail').keyup(function(){
	$('.email-yes').css('display', 'none');
	$('.email-no').css('display', 'none');
	/*$('.code-yes').css('display', 'none');
	$('.code-no').css('display', 'none');*/
});

// 닉네임 중복검사
$('#nickNameBtn').on('click', function(){
	var nickname = $('#check-nickname').val();
	console.log(nickname);
	
	if(!nickname){
		return false;
	}
	
	$.ajax({
		url: '/mamadoc/checkNicknameOk.me',
		data: {memberNickname: nickname},
		dataType: 'json',
		success: function(data){
			console.log(data.count);
			var exist = data.count;
			if(exist > 0){
				$('.nick-no').css('display', 'block');
				$('.nick-yes').css('display', 'none');
				alert('중복된 닉네임입니다.');
			}else{
				$('.nick-yes').css('display', 'block');
				$('.nick-no').css('display', 'none');
				alert('사용가능한 닉네임입니다.');
			}
		}
	});
});

// 닉네임 수정시 중복검사 초기화
$('#check-nickname').keyup(function(){
	$('.nick-yes').css('display', 'none');
	$('.nick-no').css('display', 'none');
});

// 비밀번호 확인
$('#check-pw').keyup(function(){
	var pw = $('#pw').val();
	var checkPw = $('#check-pw').val();
	if(pw == checkPw){
		$('.pw-no').css('display', 'none');
		$('.pw-yes').css('display', 'block');
	}else{
		$('.pw-yes').css('display', 'none');
		$('.pw-no').css('display', 'block');
	}
});

// 비밀번호 수정시 비밀번호 확인 초기화
$('#pw').keyup(function(){
	$('.pw-yes').css('display', 'none');
	$('.pw-no').css('display', 'none');
});

// 회원가입 가능 여부
$('#form').submit(function(){
	if($('.email-yes').css('display') != 'block'){
		alert('이메일 중복을 확인해주세요.');
		return false;
	}
	if($('.nick-yes').css('display') != 'block'){
		alert('닉네임 중복을 확인해주세요.');
		return false;
	}
	if($('.pw-yes').css('display') != 'block'){
		alert('비밀번호를 확인해주세요.');
		return false;
	}
	if($('#sample6_postcode').val() == ''){
		alert('주소를 입력해주세요.');
		return false;
	}
	if($('#check-use').is(':checked') == false){
		alert('이용약관에 동의해주세요.');
		return false;
	}
	if($('#check-info').is(':checked') == false){
		alert('개인정보 이용 및 취급에 동의해주세요.');
		return false;
	}
	alert('회원가입이 완료되었습니다.');
});