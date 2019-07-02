package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

public class Login extends HttpServlet {
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
		String user_id=request.getParameter("username");
		String password=request.getParameter("password");
		
		boolean user = UserDao.isUser(user_id, password);
		if(user){
			String name = UserDao.getUserName(user_id);
			HttpSession session=request.getSession();
			
			session.setAttribute("user_id", user_id);
			session.setAttribute("name", name);
			
			String able = UserDao.getAble(user_id);
			session.setAttribute("able", able);
			
			int a = Integer.valueOf(able);
			if(a == 0){
				response.sendRedirect("/bfish/reader/search.jsp");
			}else if(a == 1){
				request.getRequestDispatcher("/librarian/borrow1.jsp").forward(request,response);
			}else{
				request.getRequestDispatcher("/UserShow.do").forward(request,response);
			}
		}else{
			System.out.println("fail");
			request.setAttribute("login", "false");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
	}

}
