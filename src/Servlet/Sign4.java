package Servlet;

import DAO.WorkRecordDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Sign4 extends HttpServlet {

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

		if (flag == 1) {

			request.setAttribute("flag", "2");
		} else if (flag == -1) {

			request.setAttribute("flag", "-2");
		} else {

			request.setAttribute("flag", "-3");
		}
		request.getRequestDispatcher("/employee.jsp").forward(request, response);
	}
}
