package servlet.librarian;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NoticeDao;
import entity.Notice;

public class NoticeUpdateOne extends HttpServlet {
	
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
		request.setAttribute("notice_id",notice_id);
		Notice notice = NoticeDao.updateOne(notice_id);
		request.setAttribute("notice", notice);

		request.getRequestDispatcher("/librarian/NoticeChange.jsp").forward(request,response);
	}

}
