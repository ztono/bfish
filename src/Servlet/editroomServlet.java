package Servlet;



import javax.jws.WebService;
import java.io.IOException;
import DAO.*;


import java.io.IOException;



    @WebService(name="editroomServlet")
    public class editroomServlet extends javax.servlet.http.HttpServlet {
        protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            String id = request.getParameter("room_id");

            String price=request.getParameter("room_price");
            String type=request.getParameter("room_type");
            String location=request.getParameter("room_location");
            String no=request.getParameter("room_no");



            String flag= RoomDao.editroom(id,price,type,location,no);


            if(flag=="0") {

                request.setAttribute("edit","0");
            }else if(flag=="2"){

                request.setAttribute("edit", "1");
            }


            request.getRequestDispatcher("admin.jsp").forward(request, response);

        }

        protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            doPost(request,response);
        }
    }


