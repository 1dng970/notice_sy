//게시물을 등록하는 체크 함수 
function writeck(){
	if(frm.subject.value==""){
	  alert("제목을 입력하셔야 합니다.");	
	  frm.subject.focus();
	}
	else if(frm.writer.value=""){
	  alert("글쓴이를 입력하셔야 합니다.");
	  frm.writer.focus();	
	}
	else if(frm.pw.value==""){
		alert("비밀번호를 입력하셔야 합니다.");
	     frm.pw.focus();
	}
	else {
	   //CKEDITOR.instances id이름.getData(): ckditor를 로드 
	   var txt = CKEDITOR.instances.editor.getData();

 	if(txt==""){
	    alert("내용을 입력하셔야 합니다.");
     }
    else if(txt.length<40){//40자이상 등록되게 조건
        alert("최소 40자 이상 입력이 되어야 합니다.");
     }
    else{
	frm.submit();
        }		
	 }
  }
	/*
	//내용적는건 작동이 안된다.
	else if(frm.texts.value==""){
		alert("내용을 입력하셔야 합니다.");
		frm.texts.focus();
	}	
	*/
	
