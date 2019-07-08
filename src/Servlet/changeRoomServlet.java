package Servlet;

import java.io.IOException;

public class changeRoomServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String client_no = request.getParameter("client_no");
        String or_room_id = request.getParameter("room_id1");
        String to_room_id = request.getParameter("room_id2");

    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


    }
}
