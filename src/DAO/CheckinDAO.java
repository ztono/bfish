package DAO;

import BEAN.Change;
import BEAN.Checkin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import BEAN.Room;

public class CheckinDAO extends DAO.BaseDao {

    public CheckinDAO() {
    }

    public int addCheckin(Checkin checkin){
        String sql = "insert checkin (client_no, room_no, arrivedate) values (?,?,sysdate())";
        List<Object> params = new ArrayList<Object>();
        params.add(checkin.getClient_no());
        params.add(checkin.getRoom_no());
        return executeUpdate(sql, params);
    }

    public int updateLeaveDate(Checkin checkin, int duration){
        String sql = "update checkin set leavedate = (arrivedate + "+duration+") where client_no = ?;";
        List<Object> params = new ArrayList<Object>();
        params.add(checkin.getClient_no());
        return executeUpdate(sql, params);
    }

    public int addCheckout(Checkin checkout) {
        String update = "update checkin set isdamaged=?, exp_score=?, ser_score=? where client_no = ? and room_no = ?;";
        List<Object> params = new ArrayList<Object>();
        params.add(checkout.getIsdamaged());
        params.add(checkout.getExp_score());
        params.add(checkout.getSer_score());
        params.add(checkout.getClient_no());
        params.add(checkout.getRoom_no());
        return executeUpdate(update, params);
    }

    public int updateCost(Checkin checkout){
        String update = "update checkin set cost = (select room_price from room where room_id = ?) * (select (leavedate - arrivedate) where client_no = ?) where room_no = ?;";
        List<Object> params = new ArrayList<Object>();
        params.add(checkout.getRoom_no());
        params.add(checkout.getClient_no());
        params.add(checkout.getRoom_no());
        return executeUpdate(update, params);
    }

    public int updateRoomState_arrive(String room_no){
        String update = "update room set room_state = 'checkedin' where room_id = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(room_no);
        return executeUpdate(update, params);
    }

    public int updateRoomState_leave(String room_no){
        String update = "update room set room_state = 'unavailable' where room_id = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(room_no);
        return executeUpdate(update, params);
    }

    public int updateRoomState_clean(String room_no){
        String update = "update room set room_state = 'available' where room_id = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(room_no);
        return executeUpdate(update, params);
    }

    /**
     * 根据操作员查找评分
     * @param operator_name
     * @return
     */
    public ResultSet SearchScoreByOpr(String operator_name)
    {
        String sql = "select * from checkin,employee where checkin.operator_id = employee.employee_no and username = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(operator_name);

        return executeQuery(sql,params);
    }

    /**
     * 查找预定
     * @param id
     * @param arrive_date
     * @return
     */

    public ResultSet SearchReserveById(String id,String arrive_date)
    {
        String sql = "select * from reserve,client,room where reserve.client_no=client.client_no and room.room_no=reserve.room_no and client.idcard= ? and reserve.orderarrivedate = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(id);
        params.add(arrive_date);
        ResultSet rs =executeQuery(sql, params);
        return rs;
    }





    /**
     * 换房,更新changeroom表
     * @param or_room_id
     * @param to_room_id
     * @param client_no
     * @return
     */
    public int ChangeRoom(String or_room_id,String to_room_id,String client_no)
    {
        String sql = "insert changeroom ( oldroomid ,newroomid ,client_no ) values (?,?,?)";
        List<Object> params = new ArrayList<Object>();
        params.add(or_room_id);
        params.add(to_room_id);
        params.add(client_no);
        return executeUpdate(sql, params);
    }

    /**
     * 换房,更新checkin表
     * @param to_room_no
     * @param client_no
     * @return
     */
    public int updateChangeRoom(String to_room_no, String client_no){
        String sql = " update checkin set room_no = ? where client_no = ?;";
        List<Object> params = new ArrayList<Object>();
        params.add(to_room_no);
        params.add(client_no);
        return executeUpdate(sql, params);
    }





    /**
     * 根据房间号查找这个房间的所有预定
     * @param room_no
     * @return ResultSet
     */
    public ResultSet searchReserveByNo(int room_no)  {
        String str ="select * from reserve where room_no = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(room_no);
        ResultSet rs = executeQuery(str,params);

        return rs;
    }

    /**
     * 根据房型返回所有房间
     * @param roomType
     * @return ResultSet
     */
    public ResultSet searchRoomByType(String roomType)
    {
        String str ="select room_no,room_id,room_type from room where room_type = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(roomType);
        ResultSet rs = executeQuery(str,params);

        return rs;
    }

    /**
     * 根据房间号查找房间信息
     * @param room_no
     * @return Room
     * @throws SQLException
     */
    public Room SearchRoomByNo(int room_no) throws SQLException {
        String str = "select * from room where room_no = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(room_no);
        ResultSet rs = executeQuery(str,params);
        rs.next();
        Room rm = new Room();
        rm.setRoom_no(rs.getString("room_no"));
        rm.setRoom_id(rs.getString("room_id"));
        rm.setRoom_location(rs.getString("room_location"));
        rm.setRoom_price(rs.getString("room_price"));
        rm.setRoom_price(rs.getString("room_price"));
        rm.setRoom_type(rs.getString("room_type"));
        rm.setRoom_state(rs.getString("room_state"));

        return rm;
    }

    /**
     * 根据房型到达离开时间查找可以现在可以预定的所有房间
     * @param roomType
     * @param arr_dateStr
     * @param lea_dateStr
     * @return List<room>
     */
    public List<Room> searchRoomAvailable(String roomType,String arr_dateStr,String lea_dateStr)  {

        ResultSet rs = searchRoomByType(roomType);

        java.sql.Date arr_date = new java.sql.Date(strToDate(arr_dateStr).getTime());
        java.sql.Date lea_date = new java.sql.Date(strToDate(lea_dateStr).getTime());

        Boolean flag = true;
        int room_id=-1;
        int room_no=-1;

        List<Integer> rlist = new ArrayList<Integer>();
        while (true)
        {
            try {
                if (!rs.next())
                    break;
                room_id = rs.getInt("room_id");
                room_no = rs.getInt("room_no");
                ResultSet rs2 = searchReserveByNo(room_no);
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
                    rlist.add(room_no);
                }
                flag=true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        List<Room> roomlist = new ArrayList<Room>();
        for(int i=0;i<rlist.size();i++)
        {
            try {
                roomlist.add(SearchRoomByNo(rlist.get(i)));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return roomlist;
    }

    /**
     * 比较两组到达离开时间是否冲突
     * @param arr_a
     * @param lea_a
     * @param arr_b
     * @param lea_b
     * @return
     */
    public boolean is_solt(Date arr_a, Date lea_a, Date arr_b, Date lea_b)
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

    /**
     *  string转化为date
     * @param str
     * @return  Date
     */
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

    /**
     * 比较两个date是否相等
     * @param date1
     * @param date2
     * @return true or false
     */
    public  boolean compare_date(Date date1, Date date2) {

        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(date1).equals(fmt.format(date2));
    }
}
