package servlet.admin;
//qiuyuang
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao2;
import entity.User;


public class UpdateTwo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user_id1 = request.getParameter("user_id1");
		String user_id = request.getParameter("user_id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		UserDao2.updateTwo(user_id,user_id1,name,password);

		List<User> users = UserDao2.getUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/manager/UserShow.jsp").forward(request,response);
	}

}
