package servlet.librarian;

//¹ùÌÎ
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DamageDao;

public class Damage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Damage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String user_id = request.getParameter("user_id");
		String sbook_id = request.getParameter("sbook_id");
		String description = request.getParameter("description");
		String damage_fine = request.getParameter("damage_fine");
		String rec = request.getHeader("REFERER");

		DamageDao.addDamage(user_id, sbook_id, description, damage_fine);
		response.sendRedirect(rec);

	}
}
