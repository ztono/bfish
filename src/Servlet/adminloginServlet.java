package Servlet;
import java.io.IOException;
import DAO.*;

import javax.jws.WebService;

@WebService(name="adminloginServlet")
public class adminloginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String id = request.getParameter("email");

        String password=request.getParameter("password");

        String flag=RoomDao.verpassword(id,password);


          System.out.println(flag);
        if(flag.equals("0") ){

            request.getSession().setAttribute("adminid", id);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }else if(flag.equals("1")){
            request.getSession().setAttribute("message", "用户名或密码错误");
            response.sendRedirect("/adminlogin.jsp");
        }




    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
