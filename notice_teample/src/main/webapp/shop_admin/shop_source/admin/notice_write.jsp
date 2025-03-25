<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
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
<body>
<!-- 상단메뉴  -->
<%@include file='./nt_top.jsp'%>
<!-- 상단메뉴  -->
<!-- 공지등록  -->
<main class="maincss">
<%@include file='./nt_view.jsp'%>
</main>
<!-- 공지등록  -->
<!-- 하단내용 -->
<footer class="main_copyright">
 <%@include file='nt_footer.jsp'%> 
</footer>
<!-- 하단내용 -->
</body>
</html>