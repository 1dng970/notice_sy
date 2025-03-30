package notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.jni.File;


//첨부파일
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 2,	// 2MB
	maxFileSize = 1024 * 1024 * 2	// 최대 용량 20MB
)
public class notice_writeok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con =null;
	PreparedStatement ps = null;
	PrintWriter pw = null;
	
	//Model
	m_dbinfo db = new m_dbinfo();//DB 접속정보
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
	
		
		//첨부파일 방식 유무에 따라 sql 저장 방식이 변경됨
		Part nfile = request.getPart("nfile");
		long filesize = nfile.getSize();
		
		
		try {
			
			this.con =this.db.getConnection(); //DB연결
			String is_notice = request.getParameter("is_notice");//공지사항 체크여부
			String subject = request.getParameter("subject");//제목
			String writer = request.getParameter("writer");//글쓴이
			String texts = request.getParameter("texts");//공지내용
			
			if (is_notice == null) {
				
			    is_notice = "N";  // 체크박스가 선택되지 않았을 경우 기본값 "N" 설정
			}else {
				 is_notice = "Y";
				
			}
					
			String sql =""; //DB 쿼리문
			int result = 0;//DB에 저장된 결과를 받는 변수 
			
			if(filesize ==0) {//파일이 없을경우
				sql = "insert into notice_teample (nidx,is_notice,subject,writer,texts,ndate)"
						+ "values ('0',?,?,?,?,now())";
				    this.ps = this.con.prepareStatement(sql);
				    this.ps.setString(1 ,is_notice); 
				    this.ps.setString(2, subject);
				    this.ps.setString(3, writer);
				    this.ps.setString(4, texts);
				    result = this.ps.executeUpdate();
				
				if(result > 0) {
					this.pw.write("<script>"
							+ "alert('게시물이 올바르게 등록되었습니다.');"
							+ "location.href ='./notice_list.do';"
							+ "</script>");
				}
			}
			
			else {	// 첨부파일이 있을 경우
				// Model을 이용하여 첨부파일을 저장하는 방식
				m_notice nt = new m_notice(nfile,is_notice,subject,writer,texts,request);
				
				// return 메소드가 private이므로 전역변수의 값을 직접 Controller에 로드함
				String msg = nt.msg;
				
				if(msg.equals("ok")) {
					this.pw.write("<script>"
							+ "alert('게시물이 올바르게 등록되었습니다.');"
							+ "location.href = './notice_list.do';"
							+ "</script>");
				}
				else {
					this.pw.write("<script>"
							+ "alert('Database 및 첨부파일 문제로 인하여 저장되지 않았습니다.');"
							+ "history.go(-1);"
							+ "</script>");
	
				}
			}
		
		}
		
		catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('데이터베이스 문제로 인하여 저장되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		
		}
		finally {
			try {
				this.ps.close();
				this.con.close();
				this.pw.close();
			}
			catch(Exception e) {
				
			}
		}
	}
}