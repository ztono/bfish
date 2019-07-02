package servlet.librarian;
//qiuyuang
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao2;
import entity.Book;
import entity.SBook;

public class Addsbook  extends HttpServlet {
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
		
		
		int number= Integer.valueOf(request.getParameter("number"));
		String ISBN = request.getParameter("ISBN");
		String bookstatus= request.getParameter("bookstatus");
		int flag=BookDao2.addSbook(number,ISBN,bookstatus);
		
		List<Integer> sbooks = BookDao2.getMaxSbook(number);
		request.setAttribute("sbooks",sbooks);
		
		request.getRequestDispatcher("/librarian/showBarCode.jsp").forward(request,response);
		
		
	}

}
