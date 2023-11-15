<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상담소 리스트</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/counselingCenterList.css">
</head>
<body>
    <div class="counseling-full-container">
        <!--상담소 타이틀-->
        <div class="counseling-origin-box">
            <div class="counseling-origin-title">
                <div class="counseling-title">상담소</div>
                <div class="counseling-sub-title">상담이 필요하시면 언제든지 글을 써주세요</div>
            </div>

    <form action="" onsubmit="serchCheck()"> <!--form 필요할까... 일단 넣어놨음-->

        <!--제목.작성자로 드롭다운 및 찾기 검색 부분-->
        <div class="counseling-search-full-container">
            <div> <!--드롭다운-->
                <select class="drop-div">
                    <option value="title">제목</option>
                    <option value="writer">작성자</option>
                </select>
            </div>

           <!--인풋 검색창-->
                <input type="text" placeholder="검색어 입력" name="coun-search" size="80px">
        
            <div>
                <button type="submit" class="search-button">검색</button>
            </div>
        </div>
    </form>

        <!--테이블로 글제목 등등 리스트 부분-->
        <div class="counseling-list-full-container">
            <table>
                <thead style="background-color:#999999;">
                    <tr>
                        <th width="500px" class="title">글제목</th>
                        <th width="200px">작성자</th>
                        <th width="150px">작성일자</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="counse-title-contents"><a href="">밥을 너무 안먹어요</a></td>
                        <td align="center">윤이엄마</td>
                        <td align="center">2023.07.12</td>
                    </tr>
                    <!--아래는 반복되는 부분, 백단시 삭제하세요-->
                    <tr>
                        <td class="counse-title-contents"><a href=""> 어떻게 하나요.</a></td>
                        <td align="center">맘마미아</td>
                        <td align="center">2023.07.10</td>
                    </tr>
                    <tr>
                        <td class="counse-title-contents"><a href="">애기가 갑자기 열이 납니다.</a></td>
                        <td align="center">초보엄마</td>
                        <td align="center">2023.06.13</td>
                    </tr>
                    <tr>
                        <td class="counse-title-contents"><a href="">다리가 아프다는데 검사 받아야하나요</a></td>
                        <td align="center">다둥이엄마</td>
                        <td align="center">2023.05.22</td>
                    </tr>
                    <tr>
                        <td class="counse-title-contents"><a href="">밥을 너무 안먹어요</a></td>
                        <td align="center">윤이엄마</td>
                        <td align="center">2023.07.12</td>
                    </tr>
                    <!--여기까지는 반복되는 부분, 백단시 삭제하세요-->
                </tbody>
               
            </table>  
        </div>
        <div class="write-down-div">
            <button class="write-down">글쓰기</button>
        </div>


            <!--페이징 처리부분-->
            <div class="paging-part">
               
            </div>

        </div>
    </div>
</body>


</script>
</html>