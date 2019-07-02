package servlet.librarian;
//qiuyuang
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDao2;
import entity.Book;

public class Deletebook extends HttpServlet {
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
		String ISBN = request.getParameter("ISBN");
		

		int flag=BookDao2.deleteBook(ISBN);
		if(flag==1) {
			request.setAttribute("delete","1");
		}else if(flag==0){
			request.setAttribute("delete", "0");
		}
		request.getRequestDispatcher("showallbook.do").forward(request,response);
		
		
	}

}
