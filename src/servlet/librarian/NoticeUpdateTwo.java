package servlet.librarian;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDao;
import entity.Notice;

/**
 * Servlet implementation class NoticeUpdateTwo
 */
@WebServlet("/NoticeUpdateTwo")
public class NoticeUpdateTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateTwo() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String notice_id = request.getParameter("notice_id");
		String content = request.getParameter("content");
	

		NoticeDao.updateTwo(notice_id,content);

		List<Notice> notices = NoticeDao.getNotices();
		request.setAttribute("notices", notices);
		request.getRequestDispatcher("/librarian/NoticeListShow.jsp").forward(request,response);
	}

}
