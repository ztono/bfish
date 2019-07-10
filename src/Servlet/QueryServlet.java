package Servlet;

import DAO.QueryDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

/**
 * @author JunzhengChen
 * Create Time 2019/7/10 11:59
 */
public class QueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String queryDate = req.getParameter("query_date");
        QueryDAO queryDAO = new QueryDAO();
        ArrayList<Integer> result = queryDAO.getRoomRemain(queryDate);
        PrintWriter printWriter = resp.getWriter();

        printWriter.write(result.get(0).toString()+"|"+result.get(1).toString()+"|"+result.get(2).toString());
    }
}
