package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;

public class Sign1 extends HttpServlet {

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

		String staff_no = request.getParameter("staff_no");
		int flag = WorkRecordDao.addStartrecord(staff_no);

		if (flag == 1) {

			request.setAttribute("flag", "1");
		} else if (flag == -1) {

			request.setAttribute("flag", "-1");
		} else {

			request.setAttribute("flag", "3");
		}
		request.getRequestDispatcher("/manager.jsp").forward(request, response);
	}
}
