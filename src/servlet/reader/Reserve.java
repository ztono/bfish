package servlet.reader;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReserveDao;



public class Reserve extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session=request.getSession();
		String reader_id = (String)session.getAttribute("user_id");
		String sbook_id = request.getParameter("sbook_id");
		String ISBN = request.getParameter("ISBN");
		
		ReserveDao.reserve(reader_id, sbook_id);
		request.setAttribute("reserve", "true");
		request.setAttribute("ISBN", ISBN);
		request.getRequestDispatcher("/reader/lookbook.jsp").forward(request,response);
	}

}