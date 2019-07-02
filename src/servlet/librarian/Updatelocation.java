package servlet.librarian;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao2;
import entity.Category;
import entity.Location;

public class Updatelocation extends HttpServlet {
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
	
	
		int location_id= Integer.valueOf(request.getParameter("id"));
		String location_name=request.getParameter("name");

	BookDao2.updateLocation(location_id, location_name);
	List <Location> locations=BookDao2.ShowLocation();
		request.setAttribute("locations",locations);
		request.getRequestDispatcher("/librarian/showlocation.jsp").forward(request,response);

		
	}

}
