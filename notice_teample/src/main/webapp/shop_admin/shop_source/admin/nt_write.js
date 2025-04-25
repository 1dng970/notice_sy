function noticeok() {
    // 공지사항 체크 여부 확인
    var is_notice = document.getElementById("is_notice").checked;

    if (is_notice) {
        is_notice = "Y";  // 체크된 경우
    } else {
        is_notice = "N";  // 체크되지 않은 경우
    }



    // 파일 사이즈 체크
    var maxsize = 2 * 1024 * 1024; // 2MB 사이즈 제한
    var nfile = document.getElementsByName('nfile')[0];
    var filesize = nfile.files[0] ? nfile.files[0].size : 0; // 파일 사이즈 확인 (파일이 선택된 경우에만)

    if (filesize > maxsize) { // 파일 사이즈가 2MB 초과일 경우
        alert("파일 첨부 사이즈는 2MB 이내로 가능합니다.");
        $(nfile).val(''); // 업로드한 파일 제거
        return false; // 파일 선택을 취소하고 폼 제출을 막음
    }


    // 폼 유효성 검사
     else if (frm.subject.value == "") {
        alert("공지사항 제목을 입력하세요");
        return false; // 제목이 비어 있으면 폼 제출을 막기
    } else if (frm.writer.value == "") {
        alert("글쓴이를 입력하세요");
        return false; // 글쓴이가 비어 있으면 폼 제출을 막기
    } else if (frm.texts.value == "") {  // 공지내용이 비어 있을 경우
        alert("공지내용을 입력하세요");
        return false; // 공지내용이 비어 있으면 폼 제출을 막기
    }

    // 모든 검사를 통과하면 폼을 수동으로 제출
    frm.submit();
}


function noticelist() {
    window.location.href = "./notice_list.do"; // 공지목록 페이지로 이동
}