package Servlet;

import DAO.CheckinDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cleanSureServlet")
public class cleanSureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        CheckinDAO checkinDao = new CheckinDAO();

        String room_no = request.getParameter("room_no");

        checkinDao.updateRoomState_clean(room_no);

        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }
}
