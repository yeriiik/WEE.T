<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>클래스 등록 페이지1</title>
 
    <link href="https://webfontworld.github.io/SCoreDream/SCoreDream.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/63eb3bc178.js" crossorigin="anonymous"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
    
    <link href="css/weet_class_reg2_6.css" rel="stylesheet" />
    <link href="js/weet_class_reg2.js" rel="stylesheet" />

    <script src="js/loadHTML.js"></script>

    <!-- favicon -->
   <link rel="shortcut icon" href="ico/favicon.ico" type="image/x-icon">
   <link rel="icon" href="ico/favicon.ico" type="image/x-icon">
</head>

<body>
    <div  w3-include-html="weet_header_login.html"></div>
    <script>includeHTML();</script>

    <!-- ==================CONTENTS==================== -->
    <div class="contents">
        <h3>클래스 등록</h3>

        <div class="cont_bar">
            <div class="txt">
                <div class="c1">
                    <li>클래스 등록하기</li>
                    <li>></li>
                    <li>클래스 기본정보</li>
                    <li>></li>
                    <li>스케줄 및 부가정보</li>
                    <li>></li>
                    <li>커리큘럼</li>
                    <li>></li>
                    <li>헬스장정보</li>
                    <li>></li>
                    <li>등록완료</li>
                </div>
            </div>
            <div class="bar">
                <progress value="100" max="100"></progress>
            </div>       
        </div>

        <div class="ct">
            <p>정상적으로 <span>등록신청</span> 되었습니다.</p>
            <button a type="button" class="btn btn-primary" onclick="status.href='weet_reg2_2.html'">클래스 등록 현황 확인하기</button>
        </div>

    </div>
    


    <!-- ==================FOOTER==================== -->
      
    <footer class="footer">
        <div class="underline"></div>
        <img src="img/weet_logo_bw.png" alt="">
        <!-- <p>맞춤형 PT 예약&관리 플랫폼</p> -->

        <div class="notice_service">
            <button type="button" name="btnNotice" onclick="location.href='공지사항 주소';">공지사항</button>
            <button type="button" name="btnService" onclick="location.href='weet_FAQ.html';">고객센터</button>
            <br>
            <ul class="time">
                <li>운영시간 : 평일10시~18시 (주말, 공휴일 제외)</li>
                <li> 점심시간 : 12시 30분~14시</li>
            </ul>
        </div>
        <div class="underline2"></div>
        <div class="terms">
            <a href="이용약관페이지" target="_self">이용약관</a>
            <a href="개인정보처리방침페이지" target="_self">개인정보처리방침</a>
        </div>
        <div class="underline2"></div>
        <div class="address">
            <p>대표: 조은별 | 서울특별시 강남구 테헤란로14길 6 남도빌딩 2F | Tel : 1234-5678<br>
                사업자 등록번호 : 123-45-67892 | 통신판매업신고 : 2222-서울강남-1111호
            </p>
        </div>
    </footer>
</body>

</html>
<!--ddd  -->