package Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.text.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import BEAN.Reserve;
import DAO.ReserveDAO;
import DAO.ClientDao;

@WebServlet(name = "reserveSearchServlet")
public class reserveSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        String rm_type = request.getParameter("room_type");
//        String arr_dateStr = request.getParameter("arrive_date");
//        String lea_dateStr = request.getParameter("leave_date");
//        String name = request.getParameter("name");
//        String id_no = request.getParameter("cid2");
//        String ph_no = request.getParameter("phone_number");

        ReserveDAO redao = new ReserveDAO();
        ResultSet rs;
        rs = redao.researchRe();
        List<Reserve> reList = new ArrayList<Reserve>();
        while(true)
        {
            try {
                if (!rs.next()) break;
                Reserve re  = new Reserve();
                re.setClient_no(rs.getInt("client_no"));
                re.setRoom_no(rs.getInt("room_no"));
                re.setArr_date(rs.getString("orderarrivedate"));
                re.setLea_date(rs.getString("orderleavedate"));
                reList.add(re);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        request.setAttribute("reList",reList);
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }
}



