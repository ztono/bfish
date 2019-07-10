package Servlet;

import BEAN.Client;
import DAO.ClientDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        ClientDao clientdao = new ClientDao();
        Client client  = new Client();

        String username1 = request.getParameter("username1");
        String password = request.getParameter("password");
        String idcard = request.getParameter("idcard");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        client.setUsername(username1);
        client.setPassword(password);
        client.setIdcard(idcard);
        client.setEmail(email);
        client.setTelephone(telephone);
        clientdao.addClient(client);
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }
}
