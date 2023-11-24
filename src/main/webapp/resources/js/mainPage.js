//배너 슬라이드
let $slideLists = $('.main-banner-list');
let $slideImgs = $('.main-banner-img');

let slideWidth = 1440;
let currentIdx = 0;
let slideCnt = $slideImgs.length;
let $currentIdxDisplay = $(".main-banner-currentIdx"); // 현재 인덱스를 출력할 요소 선택
let $slideCntDisplay = $(".main-banner-slideCnt"); // 슬라이드 개수를 출력할 요소 선택
let line = $(".main-banner-line");

$currentIdxDisplay.text(currentIdx + 1);
$slideCntDisplay.text(slideCnt);


// 초기 값 설정 후 출력
function checkCnt(){
    $currentIdxDisplay.text(currentIdx + 1); // 인덱스는 0부터 시작하지만 표시는 1부터
    $slideCntDisplay.text(slideCnt);
}



function checkEnd(){
    if(currentIdx < 0){
        $('.arrow-prev').css('cursor','block');
        currentIdx=2;
        $currentIdxDisplay.text(slideCnt);
        $slideLists.css('left', -(currentIdx * slideWidth));
    }else{
        $('.arrow-prev').css('display','block');
    }

    if(currentIdx > slideCnt-1){
        $('.arrow-next').css('cursor','block');
        currentIdx=0;
        $slideLists.css('left', 0);
    }else{
        $('.arrow-next').css('display','block');
    }
}

//배너 슬라이드 버튼이동
$('.arrow-next').on('click', function() {
    currentIdx++;
    console.log('currentIdx : ' + currentIdx);
    $slideLists.css('left', -(currentIdx * slideWidth));
    $slideLists.css('transition', '0.5s ease');
    checkEnd();
    checkCnt();
    lineMove();
});


$('.arrow-prev').on('click', function() {  
    currentIdx--;
    console.log('currentIdx : ' + currentIdx);
    $slideLists.css('left', -(currentIdx * slideWidth));
    $slideLists.css('transition', '0.5s ease');
    checkCnt();
    checkEnd();
    lineMove();
});

//배너 슬라이드 자동이동
function slideInterval() {
    $slideLists.css('transition', '0.5s ease');
    currentIdx++;
    currentIdx = currentIdx === slideCnt ? 0 : currentIdx;
    $slideLists.css('left', -(currentIdx * slideWidth));
    checkCnt();
    checkEnd();
    lineMove();
}
// 3초마다 슬라이드 이동
setInterval(slideInterval, 3000); // 3000ms = 3초

// 메인배너 슬라이드 노란선 이동
function lineMove() {
    line.css('width', (currentIdx + 1) * 50);
}




//추천 영영제 배너
let slideNuLists = $('.main-nu-bannerList');
let slideNuWidth = 1300;
let currentNuIdx = 0;
let slideNuCnt = 3;
let button1 = $('.main-num-button1');
let button2 = $('.main-num-button2');
let button3 = $('.main-num-button3');

function checNukEnd() {
    if (currentNuIdx < 0) {
        slideNuLists.css('left', -(currentNuIdx * slideNuWidth));
    }

    if (currentNuIdx > slideNuCnt - 1) {
        slideNuLists.css('left', 0);
    }
}

function checkButton(){
    if (currentNuIdx == 0){
        button1.css('background-color', '#f9bb00');
        button2.css('background-color', '#dad9d9');
        button3.css('background-color', '#dad9d9');
    }
    else if (currentNuIdx == 1){
        button2.css('background-color', '#f9bb00');
        button1.css('background-color', '#dad9d9');
        button3.css('background-color', '#dad9d9');
    }
    else {
        button3.css('background-color', '#f9bb00');
        button1.css('background-color', '#dad9d9');
        button2.css('background-color', '#dad9d9');
    }
}

button1.on('click', function(){
    currentNuIdx=0;
    slideNuLists.css('left', -(currentNuIdx * slideNuWidth));
    button1.css('background-color', '#f9bb00');
    button2.css('background-color', '#dad9d9');
    button3.css('background-color', '#dad9d9');
});

button2.on('click', function(){
    currentNuIdx=1;
    slideNuLists.css('left', -(currentNuIdx * slideNuWidth));
    button2.css('background-color', '#f9bb00');
    button1.css('background-color', '#dad9d9');
    button3.css('background-color', '#dad9d9');
});

button3.on('click', function(){
    currentNuIdx=2;
    slideNuLists.css('left',-(currentNuIdx * slideNuWidth));
    button3.css('background-color', '#f9bb00');
    button1.css('background-color', '#dad9d9');
    button2.css('background-color', '#dad9d9');
});


function slideNuInterval() {
    currentNuIdx++;
    console.log("slideNuCnt : "+slideNuCnt);
    console.log("currentNuIdx : "+currentNuIdx);
    currentNuIdx = currentNuIdx === slideNuCnt ? 0 : currentNuIdx;
    slideNuLists.css('left', -(currentNuIdx * slideNuWidth));
    checkButton();
    checNukEnd();
   
}

setInterval(slideNuInterval, 5000);

function findHp(event) {
    event.preventDefault();

    // mainPage.html에서 입력한 값을 가져와서 findHp.html의 URL에 추가
    var keyword = document.getElementById('keyword').value;
    var newUrl = "./findHp/findHp.jsp?keyword=" + encodeURIComponent(keyword) + "#";
    
    // 현재 페이지의 URL에 새로운 URL을 추가하여 이동
    window.location.href = newUrl;
    
    
}