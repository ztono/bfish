package employeeServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeDao;
import BEAN.Employee;

public class UpdateEmployee extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		int employee_no= Integer.valueOf(request.getParameter("employee_no"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String telephone=request.getParameter("telephone");
		String position=request.getParameter("position");

	boolean p=EmployeeDao.updateEmployee(employee_no, username, password, email, telephone, position);
		if(p) {
			request.setAttribute("update", "true");
		}else {
			request.setAttribute("update", "false");
		}
		request.getRequestDispatcher("admin.jsp").forward(request,response);

		
	}

}
