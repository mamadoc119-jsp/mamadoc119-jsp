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