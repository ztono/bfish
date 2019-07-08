package Servlet;

import BEAN.Change;
import DAO.CheckinDAO;

import java.io.IOException;

public class changeRoomServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Change change = new Change();
        CheckinDAO checkinDao = new CheckinDAO();

        String client_no = request.getParameter("clientid");
        String or_room_id = request.getParameter("oldRoomNo");
        String to_room_id = request.getParameter("newRoomNo");

        change.setClient_no(client_no);
        change.setOldroomid(or_room_id);
        change.setNewroomid(to_room_id);
        checkinDao.ChangeRoom(client_no,or_room_id,to_room_id); //插入记录到changeroom表
        checkinDao.updateChangeRoom(to_room_id, client_no); //更改checkin表
        checkinDao.updateRoomState_arrive(or_room_id); //更改原房间状态
        checkinDao.updateRoomState_arrive(to_room_id); //更改新房间状态

        request.getRequestDispatcher("employee.jsp").forward(request, response);

    }
}
