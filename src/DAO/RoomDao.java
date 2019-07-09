package DAO;
import java.util.*;
import  java.sql.*;
import BEAN.*;
public class RoomDao {

    public static List<Room> getrooms() {
        List<Room> rooms = new ArrayList<Room>();
        String sql = "select * from room";
        System.out.print(sql);

        try {
            Connection c = DBHelper.getInstance().getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {

                Room room = new Room();

                room.setRoom_id(rs.getString("room_id"));


                room.setRoom_location(rs.getString("room_location"));

                room.setRoom_price(rs.getString("room_price"));
                room.setRoom_type(rs.getString("room_type"));
                room.setRoom_no(rs.getString("room_no"));

                rooms.add(room);

            }
            DBHelper.closeConnection(c, s, rs);

        } catch (Exception e) {
            e.printStackTrace();
            ;
        }
        return rooms;

    }

    public static String addroom(String id, String price, String type, String location) {


        String flag = "0";
        try {
            Connection c = DBHelper.getInstance().getConnection();
            String sql3 = "select * from room where room_id = ?";
            PreparedStatement ps3 = c.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);
            ps3.setString(1, id);
            ResultSet s1 = ps3.executeQuery();
            if (s1.next()) {
                flag = "1";
                return flag;
            }


            String sql2 = "INSERT into room(room_id,room_type,room_state,room_price,room_location)values(?,?,?,?,?)";
            PreparedStatement ps2 = c.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            ps2.setString(1, id);
            ps2.setString(2, type);
            ps2.setString(3, "available");
            ps2.setString(4, price);
            ps2.setString(5, location);
            System.out.println(ps2.toString());
            ps2. execute();
            DBHelper.closeConnection(c, ps2, null);

            return flag;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "2";
    }

    public static String editroom(String id, String price, String type, String location, String no) {
        String flag = "0";
        try {
            Connection c = DBHelper.getInstance().getConnection();


            String sql2 = "update room set room_id='" + id + "' , room_price='" + price + "' , room_type='" + type + "', room_location='" + location + "' where room_no='" + no + "'";
            System.out.print(sql2);


            Statement s = c.createStatement();
            s.executeUpdate(sql2);

            DBHelper.closeConnection(c, s, null);

            return flag;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "2";

    }

    public static String deleteroom(String no) {
        String flag = "0";
        try {
            Connection c = DBHelper.getInstance().getConnection();
            String sql = "delete from room where room_no = '" + no + "'";
            System.out.print(sql);
            Statement s = c.createStatement();
            s.executeUpdate(sql);

            DBHelper.closeConnection(c, s, null);

            return flag;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1";

    }
    public static  String verpassword(String id,String password){
        String flag="0";
        try{ Connection c = DBHelper.getInstance().getConnection();
            String sql="select * from admin where username='"+id+"' and password='"+password+"'";
            PreparedStatement ps3 = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet s1 = ps3.executeQuery();
            if(s1.next())
                return flag;

        }
        catch (Exception e){
            e.printStackTrace();
        }
                return  "1";
    }
}
