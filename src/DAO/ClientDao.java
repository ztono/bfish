package DAO;
import BEAN.Reserve;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao extends DAO.BaseDao{
    public ClientDao() {
    }
    public ResultSet searchClientById(String id)
    {
        String str = "select * from client where idcard = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(id);
        ResultSet rs = executeQuery(str,params);
        return rs;
    }

}
