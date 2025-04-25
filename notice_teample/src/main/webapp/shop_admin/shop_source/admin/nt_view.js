function notice_info(p){
	switch(p){
	
	case 1:
		location.href="./notice_list.do"
	break;
	
	case 2:
		location.href="./notice_modifyok.do"
	break;
	
	  case 3:
            if (!confirm("해당 게시물을 삭제시 복구가 되지 않습니다.")) {
                return false;  
            }
            frm.submit(); 
  
    }
}