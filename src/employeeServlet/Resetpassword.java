package employeeServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.EmployeeDao;

import BEAN.*;

public class Resetpassword extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 *
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		int employee_no= Integer.valueOf(request.getParameter("employee_no"));

		boolean d =EmployeeDao.resetPassword(employee_no);
		if(d) {
			request.setAttribute("reset", "true");
		}else {
			request.setAttribute("reset", "false");
		}
		request.getRequestDispatcher("admin.jsp").forward(request,response);

		
	}

}
