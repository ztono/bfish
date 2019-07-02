package servlet.librarian;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao2;
import entity.Book;

public class Addcategory  extends HttpServlet {
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
		
		
		String category_name=request.getParameter("category_name");
		try {
			int flag=BookDao2.addCategory(category_name);
			if(flag==2) {
				request.setAttribute("add","2");
			}else if(flag==3){
				request.setAttribute("add", "3");
			}
		} catch (Exception e1) {
		
			e1.printStackTrace();
		}
	
		request.getRequestDispatcher("/showcategory.do").forward(request,response);
		
		
	}

}
