function selectall(selectall){//전체선택 
	var nt_checkbox= document.getElementsByName('nidx');//name 값을 부름
	
	nt_checkbox.forEach((checkbox) => {
		checkbox.checked =selectall.checked;
		
	})
	
}

function notice_list_info(p) {
    switch (p) {
        case 1:
            location.href = "./notice_write.jsp";
            break;
	    case 2:
            if (confirm("해당 게시물을 삭제하면 복구할 수 없습니다. 삭제하시겠습니까?")) {
               frm.submit();
    }
  }
}

function notice_view(no){
	// 해당 게시물의 내용 및 첨부파일을 확인할 수 있는 view 페이지
	location.href="./notice_view.do?nidx="+no;
    }
