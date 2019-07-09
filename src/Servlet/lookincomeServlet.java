package Servlet;

import java.io.IOException;
import DAO.*;

import javax.jws.WebService;

@WebService(name="lookincomeServlet")
public class lookincomeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String y = request.getParameter("y2");

        String m=request.getParameter("m2");

        double single=IncomeDao.singleRoomIncome(y,m);
       double dou=IncomeDao.doubleRoomIncome(y,m);
       double  bigbed=IncomeDao.bigBedRoomIncome(y,m);





        request.setAttribute("single",single);
        request.setAttribute("dou",dou);
        request.setAttribute("bigbed",bigbed);
        request.setAttribute("total",single+dou+bigbed);

        request.getSession().setAttribute("incomeflag", "1");


        request.getRequestDispatcher("admin.jsp").forward(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
