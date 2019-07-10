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

            String operator_name = request.getParameter("operator_name");
            CheckinDAO chindao = new CheckinDAO();
            ResultSet rs;
            rs = chindao.SearchScoreByOpr(operator_name);

            /* 求平均值 */
            int num=0;
            int average =0;
//            while(true)
//            {
//                try {
//                    if (!rs.next()) break;
//                    num++;
//                    average = average + rs.getInt("ser_score");
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//
//            }
//            average = average/num;


              /*返回表格*/
            List<Checkin> commentList = new ArrayList<Checkin>();
            while(true)
            {
                try {
                    if (!rs.next()) break;
                    num++;
                    average = average + rs.getInt("ser_score");
                    Checkin ch = new Checkin();
                    ch.setRoom_no(rs.getString("room_no"));
                    ch.setClient_no(rs.getString("client_no"));

                    ch.setLeavedate(rs.getString("leavedate"));
                    ch.setSer_score(rs.getString("ser_score"));
                    commentList.add(ch);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            average=average/num;
            request.getSession().setAttribute("average",average);
            request.getSession().setAttribute("commentList",commentList);
            request.getSession().setAttribute("commentflag","1");


            request.getRequestDispatcher("manager.jsp").forward(request, response);
        }





}
