package Servlet;

import BEAN.Room;
import DAO.CheckinDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "searchRoomServlet")
public class searchRoomServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        CheckinDAO checkinDao = new CheckinDAO();

        String room_type = request.getParameter("room_type");
        String arrivetime = request.getParameter("arrivetime");
        String leavetime = request.getParameter("leavetime");

        List<Room> roomList = checkinDao.searchRoomAvailable(room_type,arrivetime,leavetime);

        request.getSession().setAttribute("roomList", roomList);

        request.getRequestDispatcher("employee.jsp?ds='showEmptyRooms'").forward(request, response);
    }
}
