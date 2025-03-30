package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class m_notice {
	Connection con = null;
	PreparedStatement ps = null;
	
	m_dbinfo db = new m_dbinfo();	// DB 접속 정보
	
	String sql = "";	// DB query문
	int result = 0;	// DB 저장 결과값
	
	String msg = "";	// Model에서 처리된 값을 Controller로 결과값을 반환하는 역할 변수
	
	String is_notice,subject,writer,texts;
	
	// 즉시 실행 메소드에서 첨부파일을 저장하는 역할만 합니다.
	public m_notice(Part nfile,String is_notice,String subject,String writer,String texts,HttpServletRequest request) throws Exception {
		this.is_notice = is_notice;
		this.subject = subject;
		this.writer = writer;
		this.texts = texts;
		
		
		// 파일 용량
		long filesize = nfile.getSize();
		
		// 파일명
		String filenm = nfile.getSubmittedFileName();
		
		// System.out.println(filenm);
		// System.out.println(request.getServletContext().getRealPath(""));
		
		// 첨부파일이 저장될 Web Directory 설정
		String url = request.getServletContext().getRealPath("/notice_file/");
		System.out.println(url);

		try {
			nfile.write(url + filenm);	// 웹에 저장
			this.fileok(filenm);	// 정상적으로 저장되었을 경우
		}
		catch(Exception e) {
			this.fileok("error");	// 비정상적으로 해당 디렉토리에 파일이 저장되지 않을 경우
		}
	}
	
	// DB로 저장 및 Controller로 결과값을 return 하는 메소드
	private String fileok(String data) throws Exception {
		if(data.equals("error")) {
			this.msg = "error";
		}
		else {	// 파일이 정상적으로 저장되었을 경우
			try {
			    this.con = this.db.getConnection();
	            
	            // 수정된 쿼리: 각 컬럼에 맞는 값을 바인딩
	            this.sql = "insert into notice_teample(nidx,is_notice,subject, writer, texts, filenm, nfile, ndate) "
	                    + "values ('0',?, ?, ?, ?, ?, ?, now())";
	            this.ps = this.con.prepareStatement(this.sql);
	            
	            // 각 파라미터 순서에 맞게 값 설정
	            this.ps.setString(1, this.is_notice);   // subject
	            this.ps.setString(2, this.subject);   // subject
	            this.ps.setString(3, this.writer);    // writer
	            this.ps.setString(4, this.texts);     // texts
	            this.ps.setString(5, data);           // filenm (파일 이름)
	            this.ps.setString(6, data);           // nfile (파일 경로)	            
	            this.result = this.ps.executeUpdate();
	            
	            if(this.result > 0) {
	                this.msg = "ok";
	            }
			}
			catch(Exception e) {
				this.msg = "error";
	
			}
			finally {
				this.ps.close();
				this.con.close();
			}
		}
		return this.msg;	// Controller로 보내는 값
	}
}