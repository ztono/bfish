package servlet.librarian;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao2;
import dao.CategoryDao;
import entity.Book;
import entity.Category;

public class Addbook extends HttpServlet {
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
		int category_id= Integer.valueOf(request.getParameter("category_id"));
		System.out.println("" + category_id);
		int number= Integer.valueOf(request.getParameter("number"));
		
		String bookstatus=request.getParameter("bookstatus");
		String price=request.getParameter("price");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String press=request.getParameter("press");
		String introduce=request.getParameter("introduce");
		int location_id= Integer.valueOf(request.getParameter("location_id"));
		String callnumber=request.getParameter("callnumber");
		request.setAttribute("ISBN",ISBN);
		request.setAttribute("location_id",location_id);
		
		request.setAttribute("price",price);
		request.setAttribute("title",title);
		request.setAttribute("author",author);
		request.setAttribute("press",press);
		request.setAttribute("introduce",introduce);
		request.setAttribute("location_id",location_id);
		request.setAttribute("callnumber",callnumber);
		request.setAttribute("number",number);
		request.setAttribute("bookstatus",bookstatus);
		
int flag=BookDao2.addBook(ISBN,category_id,price,title,author,press,introduce,location_id,callnumber,number,bookstatus);
	
		
		if(flag==2) {
			
			request.setAttribute("add","2");
		}else if(flag==3){
			
			request.setAttribute("add", "3");
		}
		
		List<Integer> sbooks = BookDao2.getMaxSbook(number);
		request.setAttribute("sbooks",sbooks);
		
		request.getRequestDispatcher("/librarian/showBarCode.jsp").forward(request,response);
		
	
		
	}

}
