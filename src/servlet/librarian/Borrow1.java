/**
 * 
 */
package servlet.librarian;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BorrowDao;

@WebServlet("/borrow1")
public class Borrow1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Borrow1() {
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
		String user_id = request.getParameter("user_id");
		 HttpSession session = request.getSession();
         session.setAttribute("borrower_id", user_id);
         
		if(BorrowDao.judge(user_id)==1) {
			request.getRequestDispatcher("/librarian/borrow.jsp").forward(request, response);
		}
		else if (BorrowDao.judge(user_id)==-1) {
			request.setAttribute("correct", "-1");
			request.getRequestDispatcher("/librarian/borrow1.jsp").forward(request, response);
		}
        else if (BorrowDao.judge(user_id)==-2) {
        	request.setAttribute("correct", "-2");
        	request.getRequestDispatcher("/librarian/borrow1.jsp").forward(request, response);
		}
        else if (BorrowDao.judge(user_id)==-3) {
        	request.setAttribute("correct", "-3");
        	request.getRequestDispatcher("/librarian/borrow1.jsp").forward(request, response);
		}
}
	    
}