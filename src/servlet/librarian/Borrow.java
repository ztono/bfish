package servlet.librarian;

//¹ùÌÎ
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BorrowDao;

@WebServlet("/borrow")
public class Borrow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Borrow() {
		super();
		// TODO Auto-generated constructor stub
	}

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

		
		
		String user_id=request.getParameter("user_id");
		String sbook_id = request.getParameter("sbook_id");
        
		String rec = request.getHeader("REFERER");

		if (BorrowDao.add(user_id, sbook_id) == 1) {
			request.setAttribute("correct", "1");
			request.getRequestDispatcher("/librarian/borrow.jsp").forward(request, response);
		} else if (BorrowDao.add(user_id, sbook_id) == 3) {
			request.setAttribute("correct", "3");
			request.getRequestDispatcher("/librarian/borrow.jsp").forward(request, response);
		} else if (BorrowDao.add(user_id, sbook_id) ==4) {
			request.setAttribute("correct", "4");
			request.getRequestDispatcher("/librarian/borrow.jsp").forward(request, response);
		} else if (BorrowDao.add(user_id, sbook_id) ==-3) {
			request.setAttribute("correct", "-3");
			request.getRequestDispatcher("/librarian/borrow.jsp").forward(request, response);
		}
		else if (BorrowDao.add(user_id, sbook_id) ==-1) {
			request.setAttribute("correct", "-1");
			request.getRequestDispatcher("/librarian/borrow.jsp").forward(request, response);
		}
		
	}
}
