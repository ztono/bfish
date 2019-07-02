package servlet.librarian;

//¹ùÌÎ
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BorrowDao;

/**
 * Servlet implementation class Return
 */
@WebServlet("/Return")
public class Return extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Return() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String sbook_id = request.getParameter("sbook_id");
		String rec = request.getHeader("REFERER");

		if (BorrowDao.returnbook( sbook_id) == 1) {
			request.setAttribute("correct", "1");
			request.getRequestDispatcher("/librarian/return.jsp").forward(request, response);
		} else if (BorrowDao.returnbook( sbook_id) == 2) {
			request.setAttribute("correct", "2");
			request.getRequestDispatcher("/librarian/return.jsp").forward(request, response);
		} else if (BorrowDao.returnbook( sbook_id) == 3) {
			request.setAttribute("correct", "3");
			request.getRequestDispatcher("/librarian/return.jsp").forward(request, response);
		} else if (BorrowDao.returnbook( sbook_id) == -3) {
			request.setAttribute("correct", "-3");
			request.getRequestDispatcher("/librarian/return.jsp").forward(request, response);
		} 
	}
}
