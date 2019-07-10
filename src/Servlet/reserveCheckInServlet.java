package Servlet;

import BEAN.ReserveShow;
import DAO.CheckinDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "reserveCheckInServlet")
public class reserveCheckInServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            String client_id = request.getParameter("clientId_no");
            String arrive_time = request.getParameter("arrivetime");

            CheckinDAO checkindao = new CheckinDAO();
            ResultSet rs;
            rs = checkindao.SearchReserveById(client_id,arrive_time);
            List<ReserveShow> rslist = new ArrayList<ReserveShow>();
            try {
                rs.next();
                ReserveShow re = new ReserveShow();
                re.setReserve_no(rs.getInt("reserve_no"));
                re.setRoom_id(rs.getString("room_id"));
                re.setRoom_type(rs.getString("room_type"));
                re.setRoom_price(rs.getString("room_price"));
                re.setRoom_state(rs.getString("room_state"));
                re.setClient_id(rs.getString("idcard"));
                re.setClient_name(rs.getString("username"));
                re.setArr_date(rs.getString("orderarrivedate"));
                re.setLea_date(rs.getString("orderleavedate"));
                re.setClient_tele(rs.getString("telephone"));
                rslist.add(re);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            request.getSession().setAttribute("searchList",rslist);
            request.getRequestDispatcher("employee.jsp?searchReserve='serR'").forward(request, response);
        }

}
