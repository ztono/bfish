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
     * 查询所有评论exp_score
     * @return ResultSet
     */
    public ResultSet researchComment()
    {
        String str = "select * from checkin where exp_score is not null";
        List<Object> params = new ArrayList<Object>();
        return executeQuery(str, params);
    }

    /**
     * 按时间查询评论     未完成！！！！！！！！！！！
     * @return
     */
    public ResultSet researchCommentBytime()
    {
        String str = "select * from checkin where exp_score is not null ";
        List<Object> params = new ArrayList<Object>();
        return executeQuery(str, params);
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
//        while(true){
//            try {
//                if (!rs.next()) break;
//                System.out.println(rs.getString("room_id"));
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }


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
//                while(true){
//            try {
//                if (!rs.next()) break;
//                System.out.println(rs.getString("room_no"));
//                System.out.println(rs.getString("room_id"));
//                System.out.println(rs.getString("room_location"));
//                System.out.println(rs.getString("room_price"));
//                System.out.println(rs.getString("room_type"));
//                System.out.println(rs.getString("room_state"));
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
//        System.out.println("room_id");
        //Room rm = new Room(rs.getString("room_id"),rs.getString("room_type"),rs.getString("room_state"),rs.getString("room_price"),rs.getString("room_location"),rs.getString("room_no"));
//        rm.setRoom_no(rs.getString("room_no"));
//        rm.setRoom_id(rs.getString("room_id"));
//        rm.setRoom_location(rs.getString("room_location"));
//        rm.setRoom_price(rs.getString("room_price"));
//        rm.setRoom_type(rs.getString("room_type"));
//        rm.setRoom_state(rs.getString("room_state"));
        rs.next();
        Room rm = new Room();
        rm.setRoom_no(rs.getString("room_no"));
        rm.setRoom_id(rs.getString("room_id"));
        rm.setRoom_location(rs.getString("room_location"));
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
    public List<Room> searchRoomAvaiable(String roomType,String arr_dateStr,String lea_dateStr)  {


        System.out.println(roomType);
        System.out.println(arr_dateStr);
        System.out.println(lea_dateStr);
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

//            for(int i =0;i<rlist.size();i++)
//            {
//                System.out.println(rlist.get(i));
//            }

        List<Room> roomlist = new ArrayList<Room>();
        for(int i=0;i<rlist.size();i++)
        {//            for(int i =0;i<roomlist.size();i++)
//            {
//                System.out.println(roomlist.get(i).toString());
//            }

            try {
                roomlist.add(SearchRoomByNo(rlist.get(i)));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(roomlist.size());

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
