package Servlet;

import BEAN.Checkin;
import BEAN.Client;
import BEAN.Reserve;
import DAO.CheckinDAO;
import DAO.ClientDao;
import DAO.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "checkInServlet")
public class checkInServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String operator = (String) request.getSession().getAttribute("id");
        EmployeeDao employeeDao = new EmployeeDao();
        String operator_id = "";
        ResultSet resultSet = employeeDao.searchEmployeeById(operator);
        try {
            resultSet.next();
            operator_id = resultSet.getString("username");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Checkin checkin = new Checkin();
        CheckinDAO checkinDao = new CheckinDAO();

        String client_no = request.getParameter("clientNo");
        String client_name = request.getParameter("clientName");
        String phone_no = request.getParameter("phone_no");
        String room_no = request.getParameter("roomNo");
        int duration = Integer.parseInt(request.getParameter("duration"));
        String isReserved = request.getParameter("isReserved");

        ResultSet rs1 =checkinDao.SearchIsRoom(room_no);
        try {
            if(!rs1.next())
            {
                //如果房间不存在错误信息
                System.out.println("room wrong");
                request.getRequestDispatcher("employee.jsp?room_er1=11").forward(request, response);
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ClientDao clientdao = new ClientDao();
        ResultSet rs2 = clientdao.searchClientById(client_no);
        Client client = new Client();
        String email = phone_no + "@163.com";
        try {
            if(!rs2.next())
            {
                //如果客户不存在就创建一个

                client.setEmail(email);
                client.setIdcard(client_no);
                client.setPassword("123456");
                client.setTelephone(phone_no);
                client.setUsername(client_name);
                clientdao.addClient(client);
                System.out.println("dadasdasdadassdasdas");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(isReserved.equals("0"))
        {
            //如果没有预约就在预约表上添加
            Reserve re = new Reserve();
            re.setRoom_no( room_no );
            ResultSet rs3 = clientdao.searchClientById(client_no);
            int c_no = 0;
            try {
                rs3.next();
                c_no=rs3.getInt("client_no");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int m = checkinDao.reserveRoom(c_no,Integer.parseInt( room_no ),duration);
        }



        checkin.setClient_no(client_no);
        checkin.setRoom_no(room_no);
        checkinDao.addCheckin(checkin,operator_id);
        checkinDao.updateLeaveDate(checkin,duration);
        checkinDao.updateCost(checkin);
        checkinDao.updateRoomState_arrive(room_no); //更新房间状态

        request.getRequestDispatcher("employee.jsp?checkin='in'").forward(request, response);
    }
}
