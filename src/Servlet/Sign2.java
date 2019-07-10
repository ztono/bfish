package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.WorkRecordDao;

public class Sign2 extends HttpServlet {

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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String staff_no = request.getParameter("staff_no2");
		int flag = WorkRecordDao.changeEndrecord(staff_no);
		String  url = request.getHeader("referer");

		if (flag == 1) {

			request.setAttribute("flag", "2");
		} else if (flag == -1) {

			request.setAttribute("flag", "-2");
		} else {

			request.setAttribute("flag", "-3");
		}
		request.getRequestDispatcher("/manager.jsp").forward(request, response);
	}
}
