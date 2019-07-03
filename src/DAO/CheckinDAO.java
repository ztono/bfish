package DAO;

import BEAN.Checkin;

import java.util.ArrayList;
import java.util.List;

public class CheckinDAO extends DAO.BaseDao {

    public CheckinDAO() {
    }

    public int addCheckout(Checkin checkout) {
        String update = "insert checkin (checkin_no, arrivedata, leavedata, client_no, room_no, isdamaged, exp_score, ser_score) values (111,'2019-07-01','2019-07-04',?,?,?,?,?)";
        List<Object> params = new ArrayList<Object>();
        params.add(checkout.getClient_no());
        params.add(checkout.getRoom_no());
        params.add(checkout.getIsdamaged());
        params.add(checkout.getExp_score());
        params.add(checkout.getSer_score());
        return executeUpdate(update, params);
    }
}
