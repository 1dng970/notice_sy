package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class notice_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        int nidx = Integer.parseInt(request.getParameter("nidx"));
	        
	        // 조회수 +1 증가 및 데이터 가져오기
	        m_noticeview mv = new m_noticeview();
	        mv.viewcount(nidx);
	        ArrayList<String> notice_v = mv.db_data;

	        // JSP에 데이터 전달
	        request.setAttribute("notice_v", notice_v);

	        // 🔹 어느 페이지로 이동할지 결정 (수정 페이지인지, 조회 페이지인지)
	        String page = request.getParameter("page"); // `page` 파라미터 추가

	        String viewpage = "./notice_view.jsp"; // 기본값 (조회 페이지)
	        if ("modify".equals(page)) { 
	        	viewpage = "./notice_modify.jsp"; // 수정 페이지로 변경
	        }

	        RequestDispatcher rd = request.getRequestDispatcher(viewpage);
	        rd.forward(request, response);
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
       
   /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int nidx = Integer.parseInt(request.getParameter("nidx"));
		//조회수 +1증가 및 데이터 출력
		m_noticeview mv = new m_noticeview();
	    mv.viewcount(nidx);
	    
	    ArrayList<String> notice_v = mv.db_data;
	   // System.out.println(notice_v);
	    
	    //게시물 1개의 데이터 내용을 jsp로 전달
	    request.setAttribute("notice_v", notice_v);
	    

		RequestDispatcher rd = request.getRequestDispatcher("./notice_view.jsp");
		rd.forward(request, response);
	}

}
*/