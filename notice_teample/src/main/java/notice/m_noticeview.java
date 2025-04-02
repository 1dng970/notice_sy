package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class m_noticeview {
   Connection con =null;
   PreparedStatement ps = null;
   ResultSet rs = null;
   
   String sql=""; //쿼리문법
   m_dbinfo db = new m_dbinfo(); //database정보 연결
   ArrayList<String> db_data  = null; // 한개의 데이터 그룹만 저장시킴
	
	public void viewcount(int nidx) { //조회수
		try {
		this.con=this.db.getConnection();

		//해당 컬럼에 값을 +1씩 증가 시키는 쿼리문
		this.sql= "update notice_teample set nview=nview+1 where nidx=?";
		this.ps = this.con.prepareStatement(this.sql);
		this.ps.setInt(1, nidx);
		this.ps.executeUpdate();//쿼리문 실행
		
		//해당 테이블에 맞는 컬럼값을 select함 
		this.sql="select * from notice_teample where nidx=? order by nidx desc";
		this.ps = this.con.prepareStatement(this.sql);
		this.ps.setInt(1, nidx);
		this.rs=this.ps.executeQuery();		
		if(this.rs.next()==true) {
			this.db_data = new ArrayList<String>();//1차클래서 배열로 넣는다 
			this.db_data.add(this.rs.getString("nidx"));
			this.db_data.add(this.rs.getString("is_notice"));
			this.db_data.add(this.rs.getString("subject"));
			this.db_data.add(this.rs.getString("writer"));
			this.db_data.add(this.rs.getString("nfile"));
			this.db_data.add(this.rs.getString("texts"));
			this.db_data.add(this.rs.getString("nview"));
			this.db_data.add(this.rs.getString("ndate"));
			//System.out.println("데이터 확인: " + this.db_data); // 데이터 출력
			
		     }
			
		}
		catch(Exception e){

			
		}finally {
			try {
			this.rs.close();
			this.ps.close();
			this.con.close();
			
     }catch (Exception e) {
				
			}
		}	
	}
	
}
	

