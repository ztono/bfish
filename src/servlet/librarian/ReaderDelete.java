package servlet.librarian;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Borrow;
import entity.Reader;
import utils.DBHelper;
import dao.ReaderDao;
import dao.Tool;

/**
 * Servlet implementation class ReaderDelete
 */
//@WebServlet("/ReaderDelete")
public class ReaderDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReaderDelete() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String reader_id = request.getParameter("reader_id");
		int flag = ReaderDao.deleteReader(reader_id);
		if(flag == 1)
		request.setAttribute("correct", "1");
		else if (flag == 0)
		request.setAttribute("correct", "0");
		
		request.getRequestDispatcher("/LReaderShow.do").forward(request, response);
	}

}
