package notice;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class m_noticemodify {
	Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    String sql = "";
    m_dbinfo db = new m_dbinfo(); // DB 연결
    ArrayList<String> db_data = null; // 수정할 데이터 저장

    // 수정할 공지 데이터를 불러오는 메서드
    public ArrayList<String> getNotice(int nidx) {
        try {
            this.con = this.db.getConnection();
            this.sql = "SELECT * FROM notice_teample WHERE nidx = ?";
            this.ps = this.con.prepareStatement(this.sql);
            this.ps.setInt(1, nidx);
            this.rs = this.ps.executeQuery();

            if (this.rs.next()) {
                this.db_data = new ArrayList<>();
                this.db_data.add(this.rs.getString("nidx"));
                this.db_data.add(this.rs.getString("is_notice"));
                this.db_data.add(this.rs.getString("subject"));
                this.db_data.add(this.rs.getString("writer"));
                this.db_data.add(this.rs.getString("nfile"));
                this.db_data.add(this.rs.getString("texts"));
                this.db_data.add(this.rs.getString("nview"));
                this.db_data.add(this.rs.getString("ndate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (this.rs != null) this.rs.close();
                if (this.ps != null) this.ps.close();
                if (this.con != null) this.con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.db_data;
    }

    // 공지사항 수정 메서드
    public void modifyNotice(int nidx, String subject, String texts, String nfile) {
        try {
            this.con = this.db.getConnection();
            this.sql = "UPDATE notice_teample SET subject = ?, texts = ?, nfile = ? WHERE nidx = ?";
            this.ps = this.con.prepareStatement(this.sql);

            this.ps.setString(1, subject);
            this.ps.setString(2, texts);
            this.ps.setString(3, nfile);
            this.ps.setInt(4, nidx);

            int result = this.ps.executeUpdate();

            if (result > 0) {
                System.out.println("공지사항 수정 성공!");
            } else {
                System.out.println("공지사항 수정 실패!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (this.ps != null) this.ps.close();
                if (this.con != null) this.con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}