package employeeServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeDao;

public class DeleteEmployee extends HttpServlet {
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
		int employee_no= Integer.valueOf(request.getParameter("employee_no"));
		boolean d = EmployeeDao.deleteEmployee(employee_no);
		
		if(d) {
			request.setAttribute("delete", "true");
		}else {
			request.setAttribute("delete", "false");
		}
		request.getRequestDispatcher("admin.jsp").forward(request,response);
		
		
		
	}

}
