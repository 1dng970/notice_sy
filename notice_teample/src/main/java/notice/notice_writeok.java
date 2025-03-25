package notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





//첨부파일
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 2,	// 5MB
	maxFileSize = 1024 * 1024 * 2,	// 최대 용량 50MB
	maxRequestSize = 1024 * 1024 * 500	// 첨부파일을 한 개만 하면 이 코드는 필요 없음
)
public class notice_writeok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
