package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class notice_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //사용자가 페이지 번호를 클릭 시 해당 값을 받는 역할
		String pageno =request.getParameter("pageno");
		
		if(pageno == null || pageno.equals("1")) {//최초 해당게시판에 접속시 페이지 배열 번호 0번으로 처리
			
			pageno="0";
			
		}
		//리스트 모델
		m_noticelist nl = new m_noticelist(Integer.parseInt(pageno));
		//2차 클래스배열로 저장된 table에 모든 데이터 셋팅 
		ArrayList<ArrayList<String>> result = nl.db_data();
		System.out.println(result.size());
		
		
		//jsp로 2차 배열 값 전달
		request.setAttribute("result", result);
		request.setAttribute("ea", result.size());
		
	
		
		RequestDispatcher rd = request.getRequestDispatcher("notice_list.jsp");
		rd.forward(request, response);
	
	
	
	}
}
