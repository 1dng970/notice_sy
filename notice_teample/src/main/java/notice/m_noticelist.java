package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class m_noticelist {
	//db에있는 데이터 가져오기 
    Connection con= null;
    PreparedStatement ps =null;
    ResultSet rs  = null;
    
	String sql;//쿼리문

	//sql db 연결
	m_dbinfo db = new m_dbinfo();
	
	ArrayList<String> data = null;//1차 클래스배열
	ArrayList<ArrayList<String>> alldata= null; //2차 클래스 배열
	
	int spage = 0;//첫번째 배열
	int ea = 5; //
	
	public m_noticelist(int s) {
		
		if(s > 0) { //1번페이지 외에 다른 번호로 클릭 했을 경우 (페이지 번호-1)* 한페이지당 출력할 갯수 
		   this.spage=(s-1)*ea ;//한페이지당 5개  출력 
			
			
		}
		else {
			
			this.spage = s;//sql 쿼리문의 limit 사용 
		}
	}
	
	public ArrayList<ArrayList<String>> db_data(){
		try {
			
		   this.con=this.db.getConnection();

		   
		   this.sql ="select nidx,subject,writer,nview,ndate,(select count(*) from notice_teample)as total from notice_teample"
		   		+ " order by nidx desc limit ?,?";
			
			this.ps= this.con.prepareStatement(this.sql);
			this.ps.setInt(1,this.spage);
		    this.ps.setInt(2,this.ea);
		   
		   this.rs = this.ps.executeQuery();//select
		   
		   this.alldata = new ArrayList<ArrayList<String>>();
		   
		   //반복문으로 1차배열 ->2차배열로 받음 
		   while(this.rs.next()) {
			   this.data = new ArrayList<String>();
			   this.data.add(this.rs.getString("nidx"));
			   this.data.add(this.rs.getString("subject"));
			   this.data.add(this.rs.getString("writer"));
			   this.data.add(this.rs.getString("nview"));//조회수
			   this.data.add(this.rs.getString("ndate"));
			   this.data.add(this.rs.getString("total"));//개시물 전체 개수를 저장한 배열값 
			   this.alldata.add(this.data);
		   }	
		  
		   
		} 
		catch (Exception e) {
		//this.alldata = null;
		 
		
		}finally {
			try {
				this.ps.close();
				this.con.close();
				
			} catch (Exception e) {
			//this.alldata = null;
			
			}
			
		}
		
		
		return this.alldata;
		
	}
	
}
