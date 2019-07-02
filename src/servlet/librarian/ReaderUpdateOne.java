package servlet.librarian;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReaderDao;
import entity.Reader;

public class ReaderUpdateOne extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String reader_id = request.getParameter("reader_id");		
		request.setAttribute("reader_id",reader_id);
		Reader reader = ReaderDao.updateOne(reader_id);
		request.setAttribute("reader", reader);

		request.getRequestDispatcher("/librarian/ReaderChange.jsp").forward(request,response);
	}

}
