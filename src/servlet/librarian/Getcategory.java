package servlet.librarian;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao2;
import entity.Book;
import entity.Category;

public class Getcategory extends HttpServlet {
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
	
	
		
		int category_id= Integer.valueOf(request.getParameter("category_id"));
		request.setAttribute("category_id",category_id);
		Category category=BookDao2.getCategory(category_id);
		
		request.setAttribute("category", category);
	request.getRequestDispatcher("/librarian/updatecategory.jsp").forward(request,response);
		
	}

}
