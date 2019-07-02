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

public class Judge extends HttpServlet {
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
		request.setAttribute("ISBN",ISBN);

		int flag=BookDao2.judge(ISBN);
		if(flag==0) {
			request.setAttribute("ISBN",ISBN);

			Book book=BookDao2.getBook2(ISBN);
			request.setAttribute("book",book);
			request.setAttribute("n1","2");
			request.getRequestDispatcher("/librarian/ISBN2.jsp").forward(request,response);		
			
		}else if(flag==1){
			request.setAttribute("ISBN",ISBN);
			request.setAttribute("n1","1");
			
			request.getRequestDispatcher("/librarian/addBook.jsp").forward(request,response);	
		}
		//request.getRequestDispatcher("showallbook.do").forward(request,response);
		
		
	}

}
