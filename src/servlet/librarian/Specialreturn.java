package servlet.librarian;

import java.io.IOException;
import dao.BorrowDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Specialreturn
 */
@WebServlet("/Specialreturn")
public class Specialreturn extends HttpServlet {

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
		String fine = request.getParameter("fine");
		String type = request.getParameter("type");
		String rec = request.getHeader("REFERER");

		if (BorrowDao.Specialreturnbook( sbook_id, fine, type)==1) {
			request.setAttribute("correct", "1");
			request.getRequestDispatcher("/librarian/specialreturn.jsp").forward(request, response);
		}
		else if (BorrowDao.Specialreturnbook( sbook_id, fine, type)==2) {
			request.setAttribute("correct", "2");
			request.getRequestDispatcher("/librarian/specialreturn.jsp").forward(request, response);
		}
		else if (BorrowDao.Specialreturnbook( sbook_id, fine, type)==3) {
			request.setAttribute("correct", "3");
			request.getRequestDispatcher("/librarian/specialreturn.jsp").forward(request, response);
		}
		else if (BorrowDao.Specialreturnbook( sbook_id, fine, type)==-3) {
			request.setAttribute("correct", "-3");
			request.getRequestDispatcher("/librarian/specialreturn.jsp").forward(request, response);
		}
		else if(BorrowDao.Specialreturnbook( sbook_id, fine, type)==-2){
			request.setAttribute("correct", "-2");
			request.getRequestDispatcher("/librarian/specialreturn.jsp").forward(request, response);
		}
	}
}
