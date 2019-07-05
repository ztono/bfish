package DAO;

import BEAN.Checkin;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public int addCheckout(Checkin checkout) {
        String update = "update checkin set leavedate=sysdate(), isdamaged=?, exp_score=?, ser_score=? where client_no = ? and room_no = ?;";
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

    public int updateRoomState_arrive(Checkin checkin){
        String update = "update room set room_state = 'unAvailable' where room_no = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(checkin.getRoom_no());
        return executeUpdate(update, params);
    }

    public int updateRoomState_leave(Checkin checkout){
        String update = "update room set room_state = 'available' where room_no = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(checkout.getRoom_no());
        return executeUpdate(update, params);
    }

    public ResultSet researchComment()
    {
        String str = "select * from checkin where exp_score is not null";
        List<Object> params = new ArrayList<Object>();
        return executeQuery(str, params);
    }

}
