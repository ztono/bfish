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


public class ReaderUpdateTwo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		//edited
		// TODO Auto-generated method stub
		
		String reader_id = request.getParameter("reader_id");
		String name = request.getParameter("name");
		//String password = request.getParameter("password");
		String email = request.getParameter("email");

		ReaderDao.updateTwo(reader_id,name,email);

		List<Reader> readers = ReaderDao.getReaders();
		request.setAttribute("readers", readers);
		request.getRequestDispatcher("/librarian/ReaderListShow.jsp").forward(request,response);
	}

}
