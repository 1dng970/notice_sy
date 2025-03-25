package notice;
//DB연결

import java.sql.Connection;
import java.sql.DriverManager;

public class m_dbinfo {

	public static Connection getConnection() throws Exception{
		//해당 라이브러리를 가져옴
		String db_driver =" com.mysql.cj.jdbc.Driver";
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
		
	
		
		
		
		
		return null;
		
		
	}
	
}

/*
도메인 : kbsn.or.kr
port : 3306
DB : chang_d
아이디 : chang_d
패스워드 : 2025chang
*/
