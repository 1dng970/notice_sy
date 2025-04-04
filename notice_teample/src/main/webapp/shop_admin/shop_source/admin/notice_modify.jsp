<%@page import="notice.m_noticeview"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 수정</title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css">
    <link rel="stylesheet" type="text/css" href="./css/login.css?v=10">
    <link rel="stylesheet" type="text/css" href="./css/main.css?v=10">
    <link rel="stylesheet" type="text/css" href="./css/notice.css?v=10">
</head>
<body>

<%@include file='./nt_top.jsp'%>

<main class="maincss">
<section>
    <p>공지사항 수정 페이지</p>
    <form action="notice_update.do" method="post" enctype="multipart/form-data">
        <!-- 게시글 번호 (hidden) -->
        <input type="hidden" name="nidx" value="">

        <div class="write_view">
            <ul>
                <li>공지사항 제목</li>
                <li><input type="text" name="title" value="" required></li>
            </ul>
            <ul>
                <li>글쓴이</li>
                <li><input type="text" name="writer" value="" readonly></li>
            </ul>
            <ul>
                <li>첨부파일</li>
                <li>
                    <input type="file" name="file">
           
                        <p>현재 파일: </p>
            
                        <p>첨부된 파일 없음</p>
              
                </li>
            </ul>
            <ul class="ul_height">
                <li>공지내용</li>
                <li><textarea name="content" class="notice_input3"></textarea></li>
            </ul>
        </div>

        <div class="board_btn">
            <button type="submit" class="border_add">저장하기</button>
            <button type="button" class="border_del" onclick="history.back()">취소</button>
        </div>
    </form>
</section>
</main>

<footer class="main_copyright">
    <%@include file='nt_footer.jsp'%>
</footer>

</body>
</html>
