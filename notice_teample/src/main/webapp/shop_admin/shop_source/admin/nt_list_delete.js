function selectall(selectall){//전체선택 
	var nt_checkbox= document.getElementsByName('nidx');//name 값을 부름
	
	nt_checkbox.forEach((checkbox) => {
		checkbox.checked =selectall.checked;
	
	})
	console.log("checkbox.checked");
}

//선택된 항목 삭제 함수 
function ntlist_delete(){
   var nt_list_checkboxes = document.getElementsByName('nidx');
   var nt_select_values=[];//선택 값 배열로 전송

    nt_list_checkboxes.forEach((checkbox)=>{
	 if(checkbox.checked){
		nt_select_values.push(checkbox.value);// 선택항목 배열에 저장		
	    }	
    });
	
	if(nt_select_values.length>0){
		//선택된 항목이 있으면 삭제 진행
		if(confirm("선택한 게시물을 삭제하시겠습니까?")){
			
	
		}else{
			
			alert("삭제할 항목을 선택해 주세요.");
		}
		 frm.submit();
	}
}

function notice_view(no){
	// 해당 게시물의 내용 및 첨부파일을 확인할 수 있는 view 페이지
	location.href="./notice_view.do?nidx="+no;
    }




/*
function selectall(selectall){//전체선택 
	var nt_checkbox= document.getElementsByName('nidx');//name 값을 부름
	
	nt_checkbox.forEach((checkbox) => {
		checkbox.checked =selectall.checked;
		
	 
     if(checkbox.checked){
	       nidx= "Y"

     }else{
	
	   nidx= "N"
      }
	
   console.log("nt_checkbox");
	
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
*/