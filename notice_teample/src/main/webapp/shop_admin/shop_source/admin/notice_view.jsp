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
    <li>
   <a href="<%= request.getContextPath()%>/notice_file/<%= views.get(4) %>" target="_blank">
      <%=views.get(4)%> 
      </a>
    </li>

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
    <button type="button" class="border_del">공지목록</button>
    <button type="button" class="border_add">공지수정</button>
    <button type="button" class="border_modify" style="margin-left: 8px;">공지삭제</button>
</div>
</section>
</main>
<footer class="main_copyright">
 <%@include file='nt_footer.jsp'%> 
</footer>
</body>
</html>