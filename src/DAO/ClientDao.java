package DAO;
import BEAN.Client;
import BEAN.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;

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

    public int searchClientByEmail(String id)
    {
        String str = "select * from client where email = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(id);
        ResultSet rs = executeQuery(str,params);
        try {
            rs.next();
            int client_no = rs.getInt("client_no");
            return client_no;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public int addClient(Client client) {
        String update = "insert client (username, password, idcard, email, telephone) values (?,?,?,?,?)";
        List<Object> params = new ArrayList<Object>();
        params.add(client.getUsername());
        params.add(client.getPassword());
        params.add(client.getIdcard());
        params.add(client.getEmail());
        params.add(client.getTelephone());
        return executeUpdate(update, params);
    }
    public static void deleteClient(String email) {
        String sql = "delete from client   where email='" + email + "'";
        System.out.println(sql);
        try {
            Connection c = DBHelper.getInstance().getConnection();
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            DBHelper.closeConnection(c, s, null);

        } catch (Exception e) {
            System.out.println("deleteClient()方法出错！");
            e.printStackTrace();
        }

    }
    public static void changePassword(String email) {
        String sql = "delete from client   where email='" + email + "'";
        System.out.println(sql);
        try {
            Connection c = DBHelper.getInstance().getConnection();
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            DBHelper.closeConnection(c, s, null);

        } catch (Exception e) {
            System.out.println("deleteClient()方法出错！");
            e.printStackTrace();
        }

    }

}
