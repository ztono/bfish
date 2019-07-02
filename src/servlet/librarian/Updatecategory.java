package servlet.librarian;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao2;
import entity.Category;

public class Updatecategory extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @param ISBN 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		int category_id= Integer.valueOf(request.getParameter("id"));
		String category_name=request.getParameter("name");

	BookDao2.updateCategory(category_id, category_name);
	List <Category> categorys=BookDao2.ShowCategory();
		request.setAttribute("categorys", categorys);
		request.getRequestDispatcher("/librarian/showcategory.jsp").forward(request,response);

		
	}

}
