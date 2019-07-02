package servlet.librarian;
//qiuyuang
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDao2;

public class Deletesbook extends HttpServlet {
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
		HttpSession session=request.getSession();
		String user_id=(String)session.getAttribute("user_id");

		String sbook_id = request.getParameter("sbook_id");
		
		try {
			int flag=BookDao2.deleteSBook(user_id,sbook_id);
			
			if(flag==0) {
				request.setAttribute("dd","0");
				
			}
			
			else if(flag==1) {
				
				request.setAttribute("dd","1");
				
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String rec = request.getHeader("REFERER");
		response.sendRedirect(rec);
		
		
	}
}
