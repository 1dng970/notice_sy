package notice;

//수정 
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int nidx = Integer.parseInt(request.getParameter("nidx"));
					
		m_noticeview mv = new m_noticeview();
		mv.viewcount(nidx);
		
		ArrayList<String> notice_v = mv.db_data;
		
		 //게시물 1개의 데이터 내용을 jsp로 전달
	    request.setAttribute("notice_v", notice_v);
		
		RequestDispatcher rd = request.getRequestDispatcher("./notice_modify.jsp");
		rd.forward(request, response);
		
	}

}
