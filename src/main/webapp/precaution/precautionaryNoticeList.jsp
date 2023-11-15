<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>precautionary notice list</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/precautionaryNoticeList.css">
</head>
<body>
    <div class="precautionary-full-container">
        <!--예방알림 타이틀-->
        <div class="precautionary-origin-box">
            <div class="precautionary-origin-title">
                <div class="precautionary-title">예방 알림</div>
                <div class="precautionary-sub-title">최근에 유행하는 질병입니다. 조심조심!!</div>
        </div>

    <form> <!--form 필요할까... 일단 넣어놨음-->

        <!--제목.작성자로 드롭다운 및 찾기 검색 부분-->
        <div class="precautionary-search-full-container">
            <div> <!--드롭다운-->
                <select class="drop-div">
                    <option value="title">제목</option>
                    <option value="writer">작성자</option>
                </select>
            </div>

            
                <input type="text" placeholder="검색어 입력" name="pre-search" size="80px">
           
            <div>
                <button type="button" class="search-button">검색</button>
            </div>
        </div>
    </form>

        <!--테이블로 글제목 등등 리스트 부분-->
        <div class="precautionary-list-full-container">
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
                        <td class="pre-title-contents"><a href="">인플로엔자 유행주의보 발령</a></td>
                        <td align="center">나는의사</td>
                        <td align="center">2023.09.15</td>
                    </tr>
                    <!--아래는 반복되는 부분, 백단시 삭제하세요-->
                    <tr>
                    
                        <td class="pre-title-contents">23-24절기 어린이 인플루엔자 국가예방접종 지원</td>
                        <td align="center">관리자</td>
                        <td align="center">2023.09.10</td>
                    </tr>
                    <tr>
                      
                    </tr>
                    <tr>
                     
                        <td class="pre-title-contents">23-24절기 임산부 인플루엔자 국가예방접종 지원</td>
                        <td align="center">경기도의사</td>
                        <td align="center">2023.08.20</td>
                    </tr>
                    <tr>
                    
                        <td class="pre-title-contents">23-24절기 임산부 인플루엔자 국가예방접종 지원</td>
                        <td align="center">관리자</td>
                        <td align="center">2023.08.20</td>
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
</html>