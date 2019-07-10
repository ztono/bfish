package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JunzhengChen
 * Create Time 2019/7/10 0:57
 */
public class QueryDAO extends DAO.BaseDao {

    public QueryDAO() {

    }

    public ArrayList<Integer> getRoomRemain(String queryDate) {
        int singleRoomNumber = 0;
        int doubleRoomNumber = 0;
        int bigbedroomNumber = 0;
        ArrayList<Integer> result=new ArrayList<Integer>();
        String[] roomType = {"singleRoom", "doubleRoom", "bigbedroom"};
        //Get all room
        ResultSet roomResult;
        String roomSql = "select room_type,room_id from room";
        try {
            List<Object> params = new ArrayList<Object>();
            roomResult = executeQuery(roomSql, params);
            while (roomResult.next()) {
                String roomNo = roomResult.getString("room_id");
                System.out.println(roomResult.getString("room_id"));
                System.out.println(queryDate);
                if(checkCheckin(queryDate,roomNo)&&checkReserve(queryDate,roomNo)){
                    if("singleroom".equals(roomResult.getString("room_type"))){
                        singleRoomNumber+=1;
                    }
                    System.out.println(roomResult.getString("room_id"));
                    if("doubleroom".equals(roomResult.getString("room_type"))){
                        doubleRoomNumber+=1;
                    }
                    if("bigbedroom".equals(roomResult.getString("room_type"))){
                        bigbedroomNumber+=1;
                    }
                }
                else{
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        result.add(singleRoomNumber);
        result.add(doubleRoomNumber);
        result.add(bigbedroomNumber);
        System.out.println(result.toString());
        return result;
    }

    /**
     * 根据入住判断该房是否可用
     *
     * @param queryDate 查询的日期
     * @param roomNo    查询的房间
     * @return
     */
    public boolean checkCheckin(String queryDate, String roomNo) {
        ResultSet resultSet;
        String sql = "Select * from checkin where room_no=? and arrivedate<=? and leavedate>?";
        try {
            List<Object> params = new ArrayList<Object>();
            params.add(roomNo);
            params.add(queryDate);
            params.add(queryDate);
            resultSet = executeQuery(sql, params);
            if (resultSet.next()) {
                return false;
            } else {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据预约判断该房是否可用
     *
     * @param queryDate
     * @param roomNo
     * @return
     */
    public boolean checkReserve(String queryDate, String roomNo) {
        ResultSet resultSet;
        String sql = "Select * from reserve where room_no=? and orderarrivedate<=? and orderleavedate>?";
        try {
            List<Object> params = new ArrayList<Object>();
            params.add(roomNo);
            params.add(queryDate);
            params.add(queryDate);
            resultSet = executeQuery(sql, params);
            if (resultSet.next()) {
                return false;
            } else {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
