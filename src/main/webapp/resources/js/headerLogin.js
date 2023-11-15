// 헤더 숨김 리스트
let scrollList = document.querySelectorAll(".main-header-category-list")
let category = document.querySelector(".main-hidden-category")
let hiddenAll = document.querySelectorAll(".main-header-category-list") + document.querySelector(".main-hidden-category")
let member = document.querySelector(".main-header-member")

for(let i=0; i<scrollList.length; i++){
    scrollList[i].addEventListener('mouseover', () => {
        category.style.display = 'flex';
    });
    category.addEventListener('mouseover', () => {
        category.style.display = 'flex';
    });
    member.addEventListener('mouseover', () => {
        category.style.display = 'flex';
    });
    
    category.addEventListener('mouseout', () => {
        category.style.display = 'none';
    });
}