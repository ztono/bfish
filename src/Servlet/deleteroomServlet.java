package Servlet;

import javax.jws.WebService;
import java.io.IOException;
import DAO.*;
@WebService(name="deleteroomServlet")
public class deleteroomServlet extends javax.servlet.http.HttpServlet  {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String no = request.getParameter("room_no");


        String flag=RoomDao.deleteroom(no);

        if(flag=="0") {

            request.setAttribute("room_delete","0");
        }else if(flag=="1"){

            request.setAttribute("room_delete", "1");
        }


        request.getRequestDispatcher("admin.jsp").forward(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }

}
