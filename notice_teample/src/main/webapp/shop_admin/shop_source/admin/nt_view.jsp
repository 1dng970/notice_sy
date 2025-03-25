<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- /*
<section>
    <p>공지사항 등록페이지</p>
<form id="frm" method="post" action="./nt_notice_writeok.do" enctype="multipart/form-data"> 
<div class="write_view">
<ul>
    <li>공지사항 여부</li>
    <li>
        <label class="label_notice"><em class="cbox"><input type="checkbox" id="noticeck"></em> 공지 출력</label> ※ 공지출력을 체크할 시 해당 글 내용은 최상단에 노출 되어 집니다.
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
        <input type="file" name="nfile" id="nfile"> ※ 첨부파일 최대 용량은 2MB 입니다.       
    </li>
</ul>
<ul class="ul_height">
    <li>공지내용</li>
    <li>
        <textarea class="notice_input3" name="text" id="editor" placeholder="공지내용을 입력하세요!"></textarea>
    </li>
</ul>
</div>
<div class="board_btn">
    <button class="border_del" onclick="location.href='공지목록_페이지_URL'">공지목록</button>
    <button type="button"  class="border_add" onclick="noticeok()">공지등록</button>
</div>
</form>  
</section>
 <script src ="../../shop_source/admin/nt_view.js?v=2"></script>   
 <!-- 제이쿼리 업로드 -->
 