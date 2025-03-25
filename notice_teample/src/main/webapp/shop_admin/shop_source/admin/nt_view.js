function noticeok() {
    // 공지사항 체크 여부 확인
    var noticeck = document.getElementById("noticeck").checked;
    
    if (noticeck) {
        // 공지사항이 체크된 경우, 제목을 상단으로 이동시키는 코드 추가
        // 예시로, 제목을 다른 영역으로 이동
        var subject = document.getElementsByName("subject")[0].value;
        alert("공지사항 제목: " + subject + "가 상단에 배치됩니다.");
        
        // 예시: 상단에 새로운 공지사항을 표시하는 코드 (상단에 공지사항 목록 추가)
        var noticelist = document.getElementById("noticelist");
        var newnotice = document.createElement("li");
        newnotice.textContent = "공지사항 제목: " + subject;
        noticelist.insertBefore(newnotice, noticelist.firstChild); // 새 공지사항을 리스트의 첫 번째 항목으로 추가
    }else{

    // 파일 사이즈 체크
    var maxsize = 2 * 1024 * 1024; // 2MB 사이즈 제한
    var nfile = $("input[name=nfile]")[0]; // 파일 input 엘리먼트 가져오기
    var filesize = nfile.files[0] ? nfile.files[0].size : 0; // 파일 사이즈 확인 (파일이 선택된 경우에만)

    if (filesize > maxsize) { // 파일 사이즈가 2MB 초과일 경우
        alert("파일 첨부 사이즈는 2MB 이내로 가능합니다.");
        $(nfile).val(''); // 업로드한 파일 제거
        return false; // 파일 선택을 취소하고 폼 제출을 막음
    }
}
    // 폼 유효성 검사
    if (frm.subject.value == "") {
        alert("공지사항 제목을 입력하세요");
        return false; // 제목이 비어 있으면 폼 제출을 막기
    } else if (frm.writer.value == "") {
        alert("글쓴이를 입력하세요");
        return false; // 글쓴이가 비어 있으면 폼 제출을 막기
    } else if (frm.text.value == "") {  // 공지내용이 비어 있을 경우
        alert("공지내용을 입력하세요");
        return false; // 공지내용이 비어 있으면 폼 제출을 막기
    }

    // 모든 검사를 통과하면 폼을 수동으로 제출
    frm.submit();
}

function noticelist() {
    window.location.href = "./noticelist.do"; // 공지목록 페이지로 이동
}