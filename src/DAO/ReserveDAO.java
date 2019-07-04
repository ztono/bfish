package DAO;
import BEAN.Reserve;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReserveDAO extends DAO.BaseDao {

    public ReserveDAO() {
    }

    public int searchRoom(String roomType) throws SQLException {
        String str ="select count( * ) from room where room_type = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(roomType);
        ResultSet rs = executeQuery(str,params);
        System.out.println(rs.next());
        int number = rs.getInt(1);
        return number;
    }
}
