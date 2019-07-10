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
        response.setContentType("text/html;charset=utf-8");

        LoginDAO login = new LoginDAO();

        String email = request.getParameter("email");
        String  password = request.getParameter("password");

        if(login.existClient(email)){
            String name = login.getName(email);
            if(password.equals(login.getPasswrod(email))) {
                request.getSession().setAttribute("id", name);
                request.getSession().setAttribute("clientEmail", email);
                PrintWriter printWriter = response.getWriter();
                printWriter.write(name);
                request.getRequestDispatcher("client.html").forward(request, response);

            }
            else {
                request.getSession().setAttribute("message", "密码错误");
                response.sendRedirect("/login.jsp");
            }
        }
        else if(login.existEmployee(email)){
            String name = login.getEName(email);
            if(password.equals(login.getEPasswrod(email))) {
                request.getSession().setAttribute("id", name);
                request.getRequestDispatcher("employee.jsp").forward(request, response);

            }
            else {
                request.getSession().setAttribute("message", "密码错误");
                response.sendRedirect("/login.jsp");
            }




        }
        else {
            request.getSession().setAttribute("message", "邮箱错误");
            response.sendRedirect("/login.jsp");

        }
        // request.getRequestDispatcher("user.jsp").forward(request, response);


    }






}
