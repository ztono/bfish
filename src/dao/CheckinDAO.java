package DAO;

import BEAN.Checkin;

import java.util.ArrayList;
import java.util.List;

public class CheckinDAO extends BaseDao{

    public CheckinDAO() {
    }

    public int addCheckout(Checkin checkout) {
        String update = "insert checkin (client_no, room_no, isdamaged, exp_score, ser_score) values (?,?,?,?,?)";
        List<Object> params = new ArrayList<Object>();
        params.add(checkout.getClient_no());
        params.add(checkout.getRoom_no());
        params.add(checkout.getIsdamaged());
        params.add(checkout.getExp_score());
        params.add(checkout.getSer_score());
        return executeUpdate(update, params);
    }
}
