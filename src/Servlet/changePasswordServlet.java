package Servlet;

import DAO.LoginDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "changePasswordServlet")
public class changePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println("sss");
        LoginDAO login = new LoginDAO();

        String email = (String) request.getSession().getAttribute("clientEmail");
        String  password1 = request.getParameter("password1");
        String  password2 = request.getParameter("password2");
        String name = login.getName(email);
        request.getSession().removeAttribute("message3");
        request.getSession().removeAttribute("message");
            if(password1.equals(login.getPasswrod(email))) {
                if(password1.equals(password2)){
                    request.getSession().setAttribute("message3", "新密码和旧密码相同");
                    response.sendRedirect("/change.jsp");
                }
                else {
                    request.getSession().removeAttribute("message3");
                    request.getSession().removeAttribute("message");
                    request.getSession().removeAttribute("clientEmail");
                    request.getSession().removeAttribute("id");
                    request.getSession().setAttribute("message4","修改成功");
                    login.ChangePassword(email, password2);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
            else {
                request.getSession().setAttribute("message3", "原密码错误");
                response.sendRedirect("/change.jsp");
            }




        }

       // request.getRequestDispatcher("user.jsp").forward(request, response);



}
