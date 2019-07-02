package servlet.librarian;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Reader;
import dao.ReaderDao;

/**
 * Servlet implementation class ReaderAdd
 */
//@WebServlet("/ReaderAdd")
public class ReaderAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReaderAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String reader_id = request.getParameter("reader_id");
		String name = request.getParameter("name");
		//String password = request.getParameter("password");
		String email = request.getParameter("email");
		ReaderDao.addReader(reader_id,name,email);
		//String rec = request.getHeader("REFERER");
		//response.sendRedirect(rec);
		request.setAttribute("reader_id", reader_id);
		request.getRequestDispatcher("/librarian/ShowReaderBarCode.jsp").forward(request,response);
	}

}
