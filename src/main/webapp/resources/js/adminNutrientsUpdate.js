// 이미지가 생성된 후에 클릭 이벤트 처리기를 추가
let bigImgWrap = $('.big-img-wrap');

// 모든 bigImgWrap 요소에 클릭 이벤트를 주기 위해서 반복문 사용
for (let i = 0; i < bigImgWrap.length; i++) {
    bigImgWrap[i].addEventListener('click', function () {
        this.style.display = 'none';
    });
}

// 이미지가 생성된 후에 클릭 이벤트 처리기를 추가
$(document).on("click", '.post-image', function () {
    let src = $(this).attr('src');
    console.log(src);

    let bigImg = document.querySelector('.big-img');
    bigImg.setAttribute('src', src);

    // 해당 이미지와 관련된 bigImgWrap을 찾아서 표시
    let parentBigImgWrap = document.querySelector('.big-img-wrap'); // 변경된 부분
    parentBigImgWrap.style.display = 'flex';
});