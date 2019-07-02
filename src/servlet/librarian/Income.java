package servlet.librarian;
import dao.IncomDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Income
 */
@WebServlet("/Income")
public class Income extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Income() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String today=IncomDao.today();
		String week=IncomDao.week();
		String month=IncomDao.month();
		String today1=IncomDao.today1();
		String week1=IncomDao.week1();
		String month1=IncomDao.month1();
		String total=IncomDao.total();
		String total1=IncomDao.total1();
		String total2=IncomDao.total2();
		request.setAttribute("today",today); 
		request.setAttribute("week",week); 
		request.setAttribute("month",month); 
		request.setAttribute("today1",today1); 
		request.setAttribute("week1",week1); 
		request.setAttribute("month1",month1);
		request.setAttribute("total",total);
		request.setAttribute("total1",total1);
		request.setAttribute("total2",total2);
		request.getRequestDispatcher("/librarian/income.jsp").forward(request,response);
	}

}
