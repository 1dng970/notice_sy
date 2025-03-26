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


//첨부파일
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 2,	// 5MB
	maxFileSize = 1024 * 1024 * 2,	// 최대 용량 50MB
	maxRequestSize = 1024 * 1024 * 500	// 첨부파일을 한 개만 하면 이 코드는 필요 없음
)

public class notice_writeok extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	Connection con = null;
	PreparedStatement ps = null;
	PrintWriter pw = null;
	
	m_dbinfo db = new m_dbinfo();	// DB 접속 정보
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("utf-8");
	   response.setContentType("text/html;charset=utf-8");
	   	   
		this.pw= response.getWriter();
				
		// 첨부파일 유무에 따라 SQL 저장방식이 변경됨
		Part nfile = request.getPart("nfile");
		long filesize = nfile.getSize();
		
		try {
			
			String subject = request.getParameter("subject");
			String writer = request.getParameter("writer");
			String texts = request.getParameter("texts");
			
			String sql = "";	// DB Query문
			int result = 0;	// DB에서 저장된 결과를 받는 변수
		
			
			if(filesize == 0) {	// 첨부파일이 없을 경우
				sql = "insert into notice (nidx,subject,writer,texts,ndate)"
						+ "values ('0',?,?,?,now())";
				this.ps = this.con.prepareStatement(sql);
				this.ps.setString(1, subject);
				this.ps.setString(2, writer);
				this.ps.setString(3, texts);
				result = this.ps.executeUpdate();
				
				if(result > 0) {
					this.pw.write("<script>"
							+ "alert('게시물이 올바르게 등록되었습니다.');"
							+ "location.href = './notice_list.do';"
							+ "</script>");
				}
			}
			else {	// 첨부파일이 있을 경우
				// Model을 이용하여 첨부파일을 저장하는 방식
				m_notice nt = new m_notice(nfile,subject,writer,texts,request);
				
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