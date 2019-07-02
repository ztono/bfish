package servlet.librarian;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao2;
import entity.Book;
import entity.Category;
import entity.Location;

public class Getlocation extends HttpServlet {
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
	
	
		
		int location_id= Integer.valueOf(request.getParameter("location_id"));
		request.setAttribute("location_id",location_id);
		Location location=BookDao2.getLocation(location_id);
		
		request.setAttribute("location", location);
	request.getRequestDispatcher("/librarian/updatelocation.jsp").forward(request,response);
		
	}

}
