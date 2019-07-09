package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import DAO.WorkRecordDao;

public class WorkRecord extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String y = request.getParameter("y");
		String m = request.getParameter("m");
		String d = request.getParameter("d");

		// List<entity.WorkRecord> wrs = WorkRecordDao.getrecords("1");
		List<BEAN.WorkRecord> wrs = WorkRecordDao.getrecords2(y, m, d);
		request.setAttribute("wrs", wrs);
		request.setAttribute("recordshow", "1");
		request.getRequestDispatcher("/admin.jsp").forward(request, response);

	}
}
