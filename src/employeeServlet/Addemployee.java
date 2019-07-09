package employeeServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.EmployeeDao;
public class Addemployee  extends HttpServlet {
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
		
		String username = request.getParameter("username");

		String password=request.getParameter("password");
		String position=request.getParameter("position");
		String email=request.getParameter("email");
		String telephone=request.getParameter("telephone");
		request.setAttribute("username",username);

		
		request.setAttribute("password",password);
		request.setAttribute("position",position);
		request.setAttribute("email",email);
		request.setAttribute("telephone",telephone);
	

			int flag=EmployeeDao.addEmployee(username,password,email,telephone,position);
			if(flag==2) {
				request.setAttribute("add","2");
			}else if(flag==3){
				request.setAttribute("add", "3");
			}
	
	
		request.getRequestDispatcher("admin.jsp").forward(request,response);
		
		
	}

}
