package servlet.librarian;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao2;
import dao.Finedao;
import entity.Delete;
import entity.Fine;

/**
 * Servlet implementation class ShowFine
 */
@WebServlet("/ShowFine")
public class ShowFine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reader_id=request.getParameter("reader_id");
		
		List<Fine> fines = Finedao.getFine(reader_id);
		List<Fine> fines2 = Finedao.getPFine(reader_id);
		request.setAttribute("fines", fines);	
		request.setAttribute("fines2", fines2);	
		request.getRequestDispatcher("/librarian/ReaderFineRecord.jsp").forward(request,response);
	}

}
