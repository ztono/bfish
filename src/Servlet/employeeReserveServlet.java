package Servlet;

import BEAN.Client;
import BEAN.Reserve;
import DAO.ClientDao;
import DAO.ReserveDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "employeeReserveServlet")
public class employeeReserveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Reserve reserve = new Reserve();
        ClientDao clientdao = new ClientDao();
        ReserveDAO reserveDao = new ReserveDAO();


        String client_name = request.getParameter("client_name");
        String client_no = request.getParameter("clientIDnum");
        String phone_no = request.getParameter("telephone");
        String roomNumber = request.getParameter("roomNumber");
        String arrtime = request.getParameter("arrtime");
        String leatime = request.getParameter("leatime");

        ResultSet rs1 = clientdao.searchClientById(client_no);
        Client client = new Client();
        String email = phone_no + "@163.com";
        try {
            if(!rs1.next()) {
                //如果客户不存在就创建一个
                client.setEmail(email);
                client.setIdcard(client_no);
                client.setPassword("123456");
                client.setTelephone(phone_no);
                client.setUsername(client_name);
                clientdao.addClient(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ResultSet rs2 = clientdao.returnClient_No(client_no);
            try {
                rs2.next();
                reserve.setClient_no(rs2.getInt("client_no"));
                reserve.setRoom_no(roomNumber);
                reserve.setArr_date(arrtime);
                reserve.setLea_date(leatime);
                reserveDao.addReserve(reserve);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        request.getRequestDispatcher("employee.jsp?employeeRes='eRes'").forward(request, response);
    }
}
