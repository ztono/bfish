package Servlet;

import BEAN.Reserve;
import DAO.ReserveDAO;

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

import BEAN.Checkin;
import DAO.CheckinDAO;
@WebServlet(name = "commentServlet")
public class commentServlet extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");


            CheckinDAO chindao = new CheckinDAO();
            ResultSet rs;
            rs = chindao.researchComment();
            List<Checkin> chinList = new ArrayList<Checkin>();
            while(true)
            {
                try {
                    if (!rs.next()) break;
                    Checkin checkin  = new Checkin();

                    checkin.setCheckin_no(rs.getInt("checkin_no"));
                    checkin.setClient_no(rs.getString("client_no"));
                    checkin.setRoom_no(rs.getString("room_no"));
                    checkin.setExp_score(rs.getString("exp_score"));
                    chinList.add(checkin);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            request.setAttribute("chinList",chinList);
            request.getRequestDispatcher("employee.jsp").forward(request, response);
        }





}
