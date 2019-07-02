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

public class Update2 extends HttpServlet {
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
	
	
		
		String ISBN=request.getParameter("ISBN");
		int category_id= Integer.valueOf(request.getParameter("category_id"));
		String price=request.getParameter("price");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String press=request.getParameter("press");
		String introduce=request.getParameter("introduce");
	int  location_id=Integer.valueOf(request.getParameter("location_id"));
		String callnumber=request.getParameter("callnumber");
		int flag=BookDao2.updateTwo(ISBN, category_id,price,title, author, press, introduce, location_id, callnumber);
List<Book> books=BookDao2.showBook();
		if(flag==1) {
			request.setAttribute("tt","1");}
		else
		{
			request.setAttribute("tt","2");
		}
		request.setAttribute("books",books);
		request.getRequestDispatcher("showallbook.do").forward(request,response);
		
	}

}
