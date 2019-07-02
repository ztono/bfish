package servlet.admin;
//qiuyuang
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DataDao;
import entity.Data;


public class Pchange extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String period = (String) request.getParameter("period");
		DataDao.Pchange(period);

		Data data = DataDao.showData();
		request.setAttribute("data", data);
		request.getRequestDispatcher("/manager/DataShow.jsp").forward(request,response);
	}

}
