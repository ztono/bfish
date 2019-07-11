package Servlet;

import BEAN.Checkin;
import DAO.CheckinDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "checkOutServlet")
public class checkOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        CheckinDAO checkindao = new CheckinDAO();
        Checkin checkout = new Checkin();

        String client_no = request.getParameter("client_no");
        String room_no = request.getParameter("room_no");
        String flag = request.getParameter("isdamaged");
        String isdamaged;
        String exp_score = request.getParameter("exp_score");
        String ser_score = request.getParameter("ser_score");
        if (flag.equals("1")){
            isdamaged = "YES";
        }else{
            isdamaged = "NO";
        }

        ResultSet rs1 =checkindao.SearchIsRoom(room_no,client_no,flag);

        try {
            if(!rs1.next())
            {
                //如果房间不存在错误信息
                System.out.println("room wrong");
                request.getRequestDispatcher("employee.jsp?room_er2=12").forward(request, response);
                return ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        checkout.setClient_no(client_no);
        checkout.setRoom_no(room_no);
        checkout.setIsdamaged(isdamaged);
        checkout.setExp_score(exp_score);
        checkout.setSer_score(ser_score);

        checkindao.addCheckout(checkout);
        checkindao.updateRoomState_leave(room_no); //更新房间状态
       // response.sendRedirect("employee.jsp?#checkout");
     request.getRequestDispatcher("employee.jsp?checkout='55'").forward(request, response);
    }
}
