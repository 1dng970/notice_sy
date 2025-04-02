<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//Controller에서 1차 클래스 배열값을 JSP에서 받아서 출력하는 방식
	ArrayList<String> views = (ArrayList)request.getAttribute("notice_v");
   
   if(views==null){//데이터가 없을 경우 리스트 페이지로 이동
    	out.print("<script>alert ('올바른 접근이 아닙니다.');location.href='./notice_list.do'; </script>");	
    	
    } else {//아닐 경우 HTML 활성화 

%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 내용 확인 페이지</title>
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

<%@include file='./nt_top.jsp'%>

<main class="maincss">
<section>
    <p>공지사항 확인 페이지</p>
<div class="write_view">
<ul>
    <li>공지사항 제목</li>
    <li><%=views.get(2)%>
       
    </li>
</ul>
<ul>
    <li>글쓴이</li>
    <li><%=views.get(3)%>
     
    </li>
</ul>

<ul>
    <li>첨부파일</li>
    <%
    String fileName = (views.get(4) != null) ? views.get(4) : ""; // 파일명이 null이면 빈 문자열 처리
    if (views.get(5) != null && !fileName.isEmpty()) { // 첨부파일 정보가 존재하고 파일명이 비어있지 않을 경우만 출력
    %>
        <li>
            <a href="<%= request.getContextPath() %>/notice_file/<%= fileName %>" target="_blank">
                <%= fileName %>
            </a>
        </li>
    <%
    } else { // 파일이 없을 경우 대체 메시지를 출력할 수도 있음
    %>
        <li>첨부된 파일이 없습니다.</li>
    <%
    }
    %>
</ul>
<ul class="ul_height">
    <li>공지내용</li>
    <li>
        <div class="notice_input3" style="overflow-y: auto;"><%=views.get(5)%></div>
    </li>
</ul>
</div>

<%
}
%>

<div class="board_btn">
    <button type="button" class="border_add" >수정하기</button>    
</div>
</section>
</main>
<footer class="main_copyright">
 <%@include file='nt_footer.jsp'%> 
</footer>
</body>
<script src ="../../shop_source/admin/nt_view.js?v=2"></script>   
</html>