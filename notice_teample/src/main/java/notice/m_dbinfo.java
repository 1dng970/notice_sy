package notice;
//DB연결

import java.sql.Connection;
import java.sql.DriverManager;

public class m_dbinfo {
	
	
	
	
	
	public static Connection getConnection() throws Exception{
		//해당 라이브러리를 가져옴
		String db_driver ="com.mysql.cj.jdbc.Driver";
		//data base 경로 연결
		String db_url ="jdbc:mysql://localhost:3306/mrp";
		//mysql 접속하는 사용자
		String db_user ="project";
		//mysql 접속하는 패스워드
		String db_passwd ="a123456";
		
		//database 연결하는 명령어 
		Class.forName(db_driver);
		Connection con = DriverManager.getConnection(db_url,db_user,db_passwd);

			
		
		return con;
		
	}
	
/*
	public static Connection getConnection() throws Exception{
		//해당 라이브러리를 가져옴
		String db_driver ="com.mysql.cj.jdbc.Driver";
		//data base 경로 연결
		String db_url ="jdbc:mysql://kbsn.or.kr:3306/chang_d";
		//mysql 접속하는 사용자
		String db_user ="chang_d";
		//mysql 접속하는 패스워드
		String db_passwd ="2025chang";
		
		//database 연결하는 명령어 
		Class.forName(db_driver);
		Connection con = DriverManager.getConnection(db_url,db_user,db_passwd);
		System.out.println(con);
			
		
		return con;
		
		
	}
*/
}

