package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import DAO.LoginDAO;
import BEAN.Client;

@WebServlet(name = "logonServlet")
public class logonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        LoginDAO logindao = new LoginDAO();
        Client client = new Client();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");
        String idcard = request.getParameter("idcard");
        if (LoginDAO.existClient(email)) {


            request.getSession().setAttribute("message2", "邮箱已被使用");
            System.out.println("fail");
            request.getRequestDispatcher("/logon.jsp").forward(request,response);


        }
        else{
            System.out.println("ok");
            client.setUsername(name);
            client.setEmail(email);
            client.setPassword(password);
            client.setTelephone(telephone);
            client.setIdcard(idcard);
            logindao.addClient(client);
            System.out.println("ok1");
            request.getSession().setAttribute("id", name);
            request.getRequestDispatcher("user.jsp").forward(request, response);



        }
    }
}
