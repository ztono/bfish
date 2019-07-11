package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import BEAN.JudgeDay;
import DAO.JudgeDao;

public class Judge1 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String employee_no = request.getParameter("employee_no");
		String perfermance = request.getParameter("performance");
		int flag;
		flag = JudgeDao.judge_day(employee_no, perfermance);

		String y = request.getParameter("y");
		String m = request.getParameter("m");

//		String d = request.getParameter("d");
		List<JudgeDay> jds = new ArrayList<JudgeDay>();
		jds = DAO.JudgeDao.getall(y,m,"0");
		if(y!=null)
			request.setAttribute("judge2flag","1");
		else
			request.setAttribute("judge1flag","1");
		request.setAttribute("jds", jds);
		request.setAttribute("judge1flag","1");
		request.getRequestDispatcher("/manager.jsp").forward(request, response);
	}
}
