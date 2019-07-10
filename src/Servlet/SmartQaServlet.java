package Servlet;

import qa.SmartQA;

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
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        String question = req.getParameter("question");
        SmartQA smartQa = new SmartQA();
        String result = smartQa.getResult(question);
        PrintWriter printWriter = resp.getWriter();
        String hotelLocationResponse = "我们旅馆是国际一流的6星级旅馆，坐落于陕西省西安市友谊西路127号。" +
                "可以乘坐110路公交车直达。更多问题欢迎致电110";
        String bookRoomResponse = "欢迎拨打我们的订房热线，或者通过页面上方的导航栏前往订房";
        String undefinedResponse = "对不起，小助手还没办法回答你的问题呢。";
        if ("询问宾馆信息".equals(result)) {
            printWriter.write(hotelLocationResponse);
        } else if ("订房间".equals(result)) {
            printWriter.write(bookRoomResponse);
        } else {
            printWriter.write(undefinedResponse);
        }

    }
}
