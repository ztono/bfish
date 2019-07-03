package qa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author JunzhengChen
 * Create Time 2019/7/3 16:30
 */
public class SmartQaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String question = req.getParameter("question");
        SmartQA smartQa = new SmartQA();
        String result = smartQa.getResult(question);
        PrintWriter printWriter = resp.getWriter();
        String returnResult="";

        printWriter.write(returnResult);
    }
}
