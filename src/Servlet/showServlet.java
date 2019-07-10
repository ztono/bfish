package Servlet;

import BEAN.Client;
import DAO.LoginDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "showServlet")
public class showServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        String login1 = "登录";

        LoginDAO login = new LoginDAO();
        String email = (String) request.getSession().getAttribute("clientEmail");
        System.out.println(email);
        String name = login.getName(email);
        if (!email.equals("null")) {
            login1 = name;
        }
        printWriter.write(login1);
    }
}