<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>notice list</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/noticeList.css">
</head>
<body>
    <div class="notice-full-container">
        <!--예방알림 타이틀-->
        <div class="notice-origin-box">
            <div class="notice-origin-title">
                <div class="notice-title">공지사항</div>
        </div>

        <!--테이블로 글제목 등등 리스트 부분-->
        <div class="notice-list-full-container">
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
                        <td class="title-contents"><a href="">2023년 12월 31일 서버 점검 예정입니다.</a></td>
                        <td align="center">관리자</td>
                        <td align="center">2023.11.10</td>
                    </tr>
                    <!--아래는 반복되는 부분, 백단시 삭제하세요-->
                    <tr>
                        <td class="title-contents">새로운 영양제 추천이 올라왔습니다.</td>
                        <td align="center">관리자</td>
                        <td align="center">2023.10.25</td>
                    </tr>
                    <tr>
                        <td class="title-contents">새로운 영양제 추천이 올라왔습니다.</td>
                        <td align="center">관리자</td>
                        <td align="center">2023.10.25</td>
                    </tr>
                    <tr>
                        <td class="title-contents">새로운 영양제 추천이 올라왔습니다.</td>
                        <td align="center">관리자</td>
                        <td align="center">2023.10.25</td>
                    </tr>
                    <tr>
                        <td class="title-contents">새로운 영양제 추천이 올라왔습니다.</td>
                        <td align="center">관리자</td>
                        <td align="center">2023.10.25</td>
                    </tr>
                    <!--여기까지는 반복되는 부분, 백단시 삭제하세요-->
                </tbody>
            </table>
        </div>


        <!--페이징 처리부분-->
        <div class="paging-part">

        </div>

        </div>
    </div>
</body>
</html>