package notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_delete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Connection con = null;
	PreparedStatement ps = null;
	String sql ="";
	int result = 0;
	
	m_dbinfo db = new m_dbinfo();//db연결
	PrintWriter pw = null;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//게시물리스트 , 뷰 둘다 삭제가능 
		//String nidx= request.getParameter("nidx");
		
		String nidx[] = request.getParameterValues("nidx");
		
		this.pw= response.getWriter();
	
		try {
			//System.out.println("배열갯수:"+nidx.length);
			//System.out.println(nidx[0].toString()); 배열 잘 날라오는지 확인하기 
		    //System.out.println(nidx[1].toString());
			
			//db연결
			this.con= this.db.getConnection();
			
			//반복문으로 각각의 nidx를 삭제 				
				this.sql="delete from notice_teample where nidx=?";
				this.ps = this.con.prepareStatement(this.sql);
				
				
				
				for(String idx: nidx) { //idx 생성해서 집어넣기 
		        this.ps.setString(1, idx);
				this.result = this.ps.executeUpdate();//delete
				//System.out.println(this.result);
				
				//한번이라도 삭제가 되면 result 값이 1이상 될 것 
				if(this.result <=0){
					break;
				}
				}
			
			if(this.result > 0) {
				this.pw.write("<script>"
						+ "alert('게시물을 삭제하였습니다.');"
						+ "location.href='./notice_list.do';"
						+ "</script>");
		
		
			}else {
			this.pw.write("<script>"
					+ "alert('데이터베이스 삭제 오류로 인하여 삭제되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
			
		   }
		
			}
			catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				this.ps.close();
				this.con.close();
				this.pw.close();
			}
			catch(Exception e) {
				System.out.println("DB 접속에 따른 해제 권한 오류 발생!!");
			}
		}
	}
}






































/*
public class notice_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	Connection con = null;
	PreparedStatement ps = null;
	String sql ="";
	int result = 0;
	
	m_dbinfo db = new m_dbinfo();//db연결
	PrintWriter pw = null;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//게시물리스트 , 뷰 둘다 삭제가능 
		String nidx= request.getParameter("nidx");
		
		this.pw= response.getWriter();
	
		try {
			//db연결
			this.con= this.db.getConnection();
			
			//반복문으로 각각의 nidx를 삭제 				
				this.sql="delete from notice_teample where nidx=?";
				this.ps = this.con.prepareStatement(this.sql);
				this.ps.setString(1, nidx);
				this.result = this.ps.executeUpdate();//delete
				System.out.println(this.result);
				
			
			if(this.result > 0) {
				this.pw.write("<script>"
						+ "alert('게시물을 삭제하였습니다.');"
						+ "location.href='./notice_list.do';"
						+ "</script>");
		
		
			}else {
			this.pw.write("<script>"
					+ "alert('데이터베이스 삭제 오류로 인하여 삭제되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
			
		   }
			}
			catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				this.ps.close();
				this.con.close();
				this.pw.close();
			}
			catch(Exception e) {
				System.out.println("DB 접속에 따른 해제 권한 오류 발생!!");
			}
		}
	}
}
*/