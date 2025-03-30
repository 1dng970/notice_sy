<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 
 ArrayList<ArrayList<String>> notice_teample = (ArrayList<ArrayList<String>>)request.getAttribute("result");
out.print(notice_teample);
//페이지번호 생성

String total_page = notice_teample.get(0).get(5);

/*
페이징 생성방법
1. 한 페이지당 몇 개씩 데이터를 출력할 것인지를 설정합니다.
2. 데이터베이스에 있는 데이터의 총 개수 / 한 페이지당 개수 (소수점)
3. Math.ceil 사용하는 이유는 반올림으로 페이지가 추가되도록 합니다.
*/

int pg = 1;
if(total_page!=null || total_page.equals("")){
	float pg2=Integer.parseInt(total_page)/5f;
	pg=(int)Math.ceil(pg2);

}

/*
get으로 page 번호를 가져오는 방식
최초 공지사항 리스트 페이지에 접근시 페이지 번호가 없을 수 있음 또는 페이지 번호가 1을 클릭했을 경우
*/

 String pno =request.getParameter("pageno");
if(pno==null || pno.equals("1")){
	pno="1";
}
 
 %>   
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 리스트 페이지</title>
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
    <p>공지사항 관리페이지</p>
    <div class="subpage_view">
    <ul>
        <li><input type="checkbox"></li>
        <li >NO</li>
        <li>제목</li>
        <li>글쓴이</li>
        <li>날짜</li>
        <li>조회</li>
    </ul>
 <%
 int f;
 //리스트 출력 번호를 총 데이터 개수로 처리
 //총 데이터 개수 - ((페이지 번호 - 1) * 한 페이지당 출력개수)
  int total =Integer.parseInt(total_page)- ((Integer.parseInt(pno) - 1) * 5);
  for(f=0;f<notice_teample.size();f++){
	  
 %>   
    
    <ol>
        <li><input type="checkbox"></li>
        <li>1</li>
        <li>테스트 제목</li>
        <li>관리자</li>
        <li>2025-02-17</li>
        <li>100</li>
    </ol>
  <%
	total--;
	}
  %>
    <ol class="none_text">
        <li id="notice_list">등록된 공지 내용이 없습니다.</li>
    </ol>
    <tr>
	<%
		int w = 1;
		while(w <= pg){
	%>
		<td width=20 height=20 align="center"><a href="./notice_list.do?pageno=<%=w%>"><%=w%></td>
	<%
			w++;
		}
	%>
	</tr>
    </div>
    <div class="board_btn">
        <button class="border_del">공지삭제</button>
        <button class="border_add">공지등록</button>
    </div>
    <div class="border_page">
        <ul class="pageing">
            <li><img src="./ico/double_left.svg"></li>
            <li><img src="./ico/left.svg"></li>
            <li>1</li>
            <li><img src="./ico/right.svg"></li>
            <li><img src="./ico/double_right.svg"></li>
        </ul>
    </div>
</section>
</main>
<footer class="main_copyright">
 <%@include file='nt_footer.jsp'%> 
</footer>
<!-- 하단내용 -->
</body>
<script>
function notice_view(no){
	// 해당 게시물의 내용 및 펌부파일을 확인할 수 있는 view 페이지
	location.href="./notice_view.do?nidx="+no;
}
</script>
</html>