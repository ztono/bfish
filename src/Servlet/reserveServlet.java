package Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.text.*;
import java.util.Calendar;
import java.util.Date;

import BEAN.Reserve;
import DAO.ReserveDAO;
import DAO.ClientDao;

@WebServlet(name = "reserveServlet")
public class reserveServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String rm_type = request.getParameter("room_type");
        String arr_dateStr = request.getParameter("arrive_date");
        String lea_dateStr  = request.getParameter("leave_date");
        String name = request.getParameter("name");
        String id_no = request.getParameter("cid2");
        String ph_no = request.getParameter("phone_number");


        java.sql.Date arr_date = new java.sql.Date(strToDate(arr_dateStr).getTime());
        java.sql.Date lea_date = new java.sql.Date(strToDate(lea_dateStr).getTime());

        ReserveDAO reservedao = new ReserveDAO();
        System.out.println(rm_type);
        Boolean flag = true;
        int room_id=-1;
        int room_no=-1;
        ResultSet rs1 =reservedao.searchRoomByType(rm_type);


                while (true)
        {
            try {
                if (!rs1.next()) break;
                room_id = rs1.getInt("room_id");
                room_no = rs1.getInt("room_no");
                ResultSet rs2 = reservedao.searchReserveByNo(room_no);
                while (true)
                {
                    try {
                        if (!rs2.next()) break;
                        if(!is_solt(arr_date,lea_date,new java.sql.Date(rs2.getDate("orderarrivedate").getTime()),new java.sql.Date(rs2.getDate("orderleavedate").getTime())))
                        {
                            flag = false;
                            break;
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
                if(flag==true)
                {
                    break;
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

         ClientDao cdao = new ClientDao();
         ResultSet cRs = cdao.searchClientById(id_no);
        try {
            cRs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int client_no = -1;
        try {
            client_no = cRs.getInt("client_no");
        } catch (SQLException e) {
            e.printStackTrace();
        }



        if(!flag)
        {
            System.out.println("order fail");

        }else {
            System.out.println(room_id);
            Reserve re = new Reserve(client_no, room_no, arr_dateStr, lea_dateStr);
            int is = reservedao.reserveRoom(re);
            if (is != 0) {
                System.out.println("order suceess");
                System.out.println(room_id);
            }else
            {
                System.out.println("order fail");
            }
        }


        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }



    public boolean is_solt(Date arr_a,Date lea_a,Date arr_b,Date lea_b)
    {
        if(arr_b.before(arr_a)&&(arr_a.before(lea_b)&&!(compare_date(arr_a,lea_b))))
        {System.out.println("1");return false;}
        if(arr_a.before(arr_b)&&lea_b.before(lea_a))
        {System.out.println("2");return false;}
        if(lea_a.after(arr_b)&&lea_a.before(lea_b))
        {System.out.println("3");return false;}
        if(arr_b.before(arr_a)&&lea_a.before(lea_b))
        {System.out.println("4");return false;}
        if(arr_a.equals(arr_b)&&lea_a.equals(lea_b))
        {System.out.println("5");return false;}
        return true;
    }
    public Date strToDate(String str)
    {
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
    public  boolean compare_date(Date date1, Date date2) {

        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(date1).equals(fmt.format(date2));
    }
}
