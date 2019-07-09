package Servlet;

import BEAN.Client;
import BEAN.Reserve;
import DAO.ReserveDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import DAO.ClientDao;

public class ReserveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String roomType = request.getParameter("room_type");
        String arrDateStr = request.getParameter("arrive_date");
        String leaveDatestr = request.getParameter("leave_date");
        String name = request.getParameter("name");
        String idNo = request.getParameter("id");
        String phoneNum = request.getParameter("phone_number");

        java.sql.Date arrDate = new java.sql.Date(strToDate(arrDateStr).getTime());
        java.sql.Date leaveDate = new java.sql.Date(strToDate(leaveDatestr).getTime());

        ReserveDAO reserveDAO = new ReserveDAO();
        System.out.println(roomType);
        boolean flag = true;
        int roomId = -1;
        int roomNo = -1;

        ResultSet rs1 = reserveDAO.searchRoomByType(roomType);
        System.out.println(rs1);
        while (true) {
            try {
                if (!rs1.next()) {
                    break;
                }
                roomId = rs1.getInt("room_id");
                roomNo = rs1.getInt("room_no");
                ResultSet rs2 = reserveDAO.searchReserveByNo(roomNo);
                while (true) {
                    try {
                        if (!rs2.next()) break;
                        if (!is_solt(arrDate, leaveDate, new java.sql.Date(rs2.getDate("orderarrivedate").getTime()), new java.sql.Date(rs2.getDate("orderleavedate").getTime()))) {
                            flag = false;
                            break;
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (flag == true) {
                    break;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

//        HttpSession httpSession = request.getSession();
//
//        String email = (String) httpSession.getAttribute("clientEmail");
//        ClientDao clientDao = new ClientDao();
//
//        int clientID = clientDao.searchClientByEmail(email);
//
//        System.out.println("reached");
        Reserve re = new Reserve(1, roomNo, arrDateStr, leaveDatestr);
        int is = reserveDAO.reserveRoom(re);
        if (is != 0) {
            System.out.println("order suceess");
            System.out.println(roomId);
        } else {
            System.out.println("order fail");
        }

        PrintWriter printWriter = response.getWriter();
        printWriter.write("result");
    }


    public boolean is_solt(Date arr_a, Date lea_a, Date arr_b, Date lea_b) {
        if (arr_b.before(arr_a) && (arr_a.before(lea_b) && !(compare_date(arr_a, lea_b)))) {
            System.out.println("1");
            return false;
        }
        if (arr_a.before(arr_b) && lea_b.before(lea_a)) {
            System.out.println("2");
            return false;
        }
        if (lea_a.after(arr_b) && lea_a.before(lea_b)) {
            System.out.println("3");
            return false;
        }
        if (arr_b.before(arr_a) && lea_a.before(lea_b)) {
            System.out.println("4");
            return false;
        }
        if (arr_a.equals(arr_b) && lea_a.equals(lea_b)) {
            System.out.println("5");
            return false;
        }
        return true;
    }

    /**
     * string转化为date
     *
     * @param str
     * @return Date
     */
    public Date strToDate(String str) {
        /*
            str to date function code
        */
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date strtodate = null;
        try {
            strtodate = formatter.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strtodate;
    }

    /**
     * 比较两个date是否相等
     *
     * @param date1
     * @param date2
     * @return true or false
     */
    public boolean compare_date(Date date1, Date date2) {

        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(date1).equals(fmt.format(date2));
    }
}
