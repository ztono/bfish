package DAO;
import BEAN.Reserve;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReserveDAO extends DAO.BaseDao {

    public ReserveDAO() {
    }

    public int addReserve(Reserve reserve) {
        String update = "insert reserve (client_no, room_no, orderarrivedate, orderleavedate) values (?,?,?,?)";
        List<Object> params = new ArrayList<Object>();
        params.add(reserve.getClient_no());
        params.add(reserve.getRoom_no());
        params.add(reserve.getArr_date());
        params.add(reserve.getLea_date());
        return executeUpdate(update, params);
    }

    /**
     * 查找所有预定
     * @return ResultSet
     */
    public ResultSet researchRe()
    {
        String str = "select * from reserve";
        List<Object> params = new ArrayList<Object>();
        ResultSet rs = executeQuery(str,params);
        return rs;
    }

    public ResultSet searchRoomByType(String roomType)  {
//        String str ="select reserve_no,client_no,reserve.room_no,orderarrivedate,orderleavedate,room_type from room,reserve where room.room_no=reserve.room_no and room_type = ?";
//        List<Object> params = new ArrayList<Object>();
//        params.add(roomType);
//        ResultSet rs = executeQuery(str,params);
        String str ="select room_no,room_id,room_type from room where room_type = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(roomType);
        ResultSet rs = executeQuery(str,params);
        return rs;
    }
    public ResultSet searchReserveByNo(int room_no)  {
        String str ="select * from reserve where room_no = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(room_no);
        ResultSet rs = executeQuery(str,params);

        return rs;
    }
    public int reserveRoom(Reserve reserve)
    {
        String str = "insert reserve(client_no,room_no,orderarrivedate,orderleavedate)values(?,?,?,?)";
        List<Object> params = new ArrayList<Object>();
        params.add(reserve.getClient_no());
        params.add(reserve.getRoom_no());
        params.add(reserve.getArr_date());
        params.add(reserve.getLea_date());

        return executeUpdate(str, params);
    }


}
