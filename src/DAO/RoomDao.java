package DAO;
import java.util.*;
import  java.sql.*;
import BEAN.*;
public class RoomDao {
    public static List<Room> getrooms()  {
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

        }
        catch (Exception e){
            e.printStackTrace();;
        }
        return rooms;

    }
}
