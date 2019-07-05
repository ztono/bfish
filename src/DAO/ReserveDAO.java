package DAO;
import BEAN.Reserve;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReserveDAO extends DAO.BaseDao {

    public ReserveDAO() {
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

}
