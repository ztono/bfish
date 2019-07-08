package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Client;
import DAO.ClientDao;
@WebServlet(name = "deleteClientServlet")
public class deleteClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ClientDao clientdao = new ClientDao();
        String email = request.getParameter("email1");
        clientdao.deleteClient(email);
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }
}