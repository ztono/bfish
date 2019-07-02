package servlet.reader;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Tool;
import dao.UserDao;

/**
 * Servlet implementation class Forget
 */
@WebServlet("/Forget")
public class Forget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forget() {
        super();
        // TODO Auto-generated constructor stub
    }

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
	
		int action = Integer.parseInt(request.getParameter("action"));
		switch(action){
		case 1:
			forgetOne(request, response);
		    break;
		case 3:
			forgetThree(request, response);
		    break;
		}
	}

	private void forgetOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("accountkey");
		if(UserDao.existUser(user_id)){
			String to = UserDao.getEmail(user_id); 
			String security = Tool.sendSecurity(to);
			HttpSession session=request.getSession();
			session.setAttribute("forget_user_id", user_id);
			
			request.setAttribute("security", security);
			request.getRequestDispatcher("/reader/forget/two.jsp").forward(request,response);
			
		}else{
			request.setAttribute("exist", "false");
			request.getRequestDispatcher("/reader/forget/one.jsp").forward(request,response);
			
		}
	}

	private void forgetThree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String user_id = (String)session.getAttribute("forget_user_id");
		String password = request.getParameter("accountpwd");
		
		UserDao.updatePassword(user_id, password);
		request.getRequestDispatcher("/reader/forget/four.jsp").forward(request,response);
	}

}
