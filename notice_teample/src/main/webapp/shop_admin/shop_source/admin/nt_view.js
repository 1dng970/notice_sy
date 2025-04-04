function notice_info(p){
	switch(p){
	
	case 1:
		location.href="./notice_list.do"
	break;
	
	case 2:
		location.href="./notice_edit.jsp"
	break;
	
	  case 3:
            if (!confirm("해당 게시물을 삭제시 복구가 되지 않습니다.")) {
                return false;  // ❗취소 버튼을 누르면 함수 종료
            }
            frm.submit(); // ✅ 확인을 눌렀을 때만 실행됨
            break;
    }
}