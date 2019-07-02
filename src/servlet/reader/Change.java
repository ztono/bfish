package servlet.reader;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Tool;
import dao.UserDao;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class Change extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String security;
    private String email;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Change() {
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
		String A = request.getParameter("action");
		System.out.println(A);
		int action = Integer.parseInt(A);
		switch(action){
		case 0:
		    sendSecurity(request, response);
		    break;
		case 1:
		    changePassword(request, response);
		    break;
		case 2:
			changeEmail(request, response);
		    break;
		case 3:
			changeInformation(request, response);
		    break;
		}
	}
	
	private void sendSecurity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		email = request.getParameter("email");
		security = Tool.sendSecurity(email);
		response.getWriter().print("<script>history.go(-1);</script>"); 
	}
	
	private void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session=request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		String password = request.getParameter("newpwd");
		
		UserDao.updatePassword(user_id, password);
		request.getRequestDispatcher("reader/change/success.jsp").forward(request,response);
	}
	//ÐÞ¸ÄÓÊÏä
	private void changeEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String code = request.getParameter("code");
		if(security.equals(code)){
			HttpSession session=request.getSession();
			String user_id = (String)session.getAttribute("user_id");
			UserDao.updateEmail(user_id, email);
			request.getRequestDispatcher("/reader/change/success.jsp").forward(request,response);
		}else{
			response.getWriter().print("<script>history.go(-1);</script>"); 
		}
	}
	//ÐÞ¸ÄÃû×Ö
	private void changeInformation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		HttpSession session=request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		UserDao.updateName(user_id, name);
		session.setAttribute("name", name);
		request.getRequestDispatcher("/reader/change/success.jsp").forward(request,response);
	}

}
