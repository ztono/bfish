package servlet.librarian;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao2;

public class Deletecategory extends HttpServlet {
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
		int category_id= Integer.valueOf(request.getParameter("category_id"));
		boolean d = BookDao2.deleteCategory(category_id);
		//BookDao2.deleteBookBycid(category_id);
		
		
		//String rec = request.getHeader("REFERER");
		
		//response.sendRedirect(rec);
		if(d) {
			request.setAttribute("delete", "true");
		}else {
			request.setAttribute("delete", "false");
		}
		request.getRequestDispatcher("/showcategory.do").forward(request,response);
		
		
		
	}

}
