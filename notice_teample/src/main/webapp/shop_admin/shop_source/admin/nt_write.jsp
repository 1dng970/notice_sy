<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 등록 페이지</title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css">
    <link rel="stylesheet" type="text/css" href="./css/login.css?v=10">
    <link rel="stylesheet" type="text/css" href="./css/main.css?v=10">
    <link rel="stylesheet" type="text/css" href="./css/notice.css?v=10">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
</head>      
<main class="maincss">
<section>
    <p>공지사항 등록페이지</p>
<form id="frm" method="post" action="./notice_writeok.do" enctype="multipart/form-data"> 
<div class="write_view">
<ul>
    <li>공지사항 여부</li>
    <li>
        <label class="label_notice"><em class="cbox"><input type="checkbox"  name="is_notice" id="is_notice" value="Y"></em> 공지 출력</label> ※ 공지출력을 체크할 시 해당 글 내용은 최상단에 노출 되어 집니다.
    </li>
</ul>
<ul>
    <li>공지사항 제목</li>
    <li>
        <input type="text" name="subject" class="notice_input1"> ※ 최대 150자까지 입력이 가능
    </li>
</ul>
<ul>
    <li>글쓴이</li>
    <li>
        <input type="text" name="writer" class="notice_input2" value="관리자" readonly="readonly"> ※ 관리자 이름이 노출 됩니다.       
    </li>
</ul>
<ul>
    <li>첨부파일</li>
    <li>
        <input type="file" name="nfile" id="nfile" > ※ 첨부파일 최대 용량은 2MB 입니다.       
    </li>
</ul>
<ul class="ul_height">
    <li>공지내용</li>
    <li>
        <textarea class="notice_input3" name="texts" id="editor" placeholder="공지내용을 입력하세요!"></textarea>
    </li>
</ul>
</div>
<div class="board_btn">
    <button type="button"  class="border_del" onclick="location.href='notice_list.do'">공지목록</button>
    <button type="button"  class="border_add" onclick="noticeok()">공지등록</button>
</div>
</form>  
</section>
 
</main>
 <script src ="../../shop_source/admin/nt_write.js?v=4"></script>   
 <!-- 제이쿼리 업로드 -->
 