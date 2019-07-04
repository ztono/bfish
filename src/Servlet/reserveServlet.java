package Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import BEAN.Reserve;
import DAO.ReserveDAO;

@WebServlet(name = "reserveServlet")
public class reserveServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String rm_type = request.getParameter("room_type");
        String arr_date = request.getParameter("arrive_date");
        String lea_date  = request.getParameter("leave_date");
        String name = request.getParameter("name");
        String id_no = request.getParameter("cid2");
        String ph_no = request.getParameter("phone_number");


//        checkout.setClient_no(client_no);
//        checkout.setRoom_no(room_no);
//        checkout.setIsdamaged(isdamaged);
//        checkout.setExp_score(exp_score);
//        checkout.setSer_score(ser_score);
//        checkindao.addCheckout(checkout);
        ReserveDAO reservedao = new ReserveDAO();
        System.out.println(rm_type);
        try {
            int num = reservedao.searchRoom(rm_type);
            request.setAttribute("num",num);
            System.out.println(num);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

}
