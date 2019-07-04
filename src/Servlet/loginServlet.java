package Servlet;

import BEAN.Client;
import DAO.LoginDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        LoginDAO login = new LoginDAO();

        String email = request.getParameter("email1");
        String  password = request.getParameter("password1");
        if(login.existClient(email)){
            if(password.equals(login.getPasswrod(email)))
            request.getRequestDispatcher("user.jsp").forward(request, response);
            else
                response.sendRedirect("/login.jsp");
        }
        else
            response.sendRedirect("/login.jsp");
       // request.getRequestDispatcher("user.jsp").forward(request, response);


    }
}
