package DAO;

import BEAN.Client;
import BEAN.DBHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO extends DAO.BaseDao {



    public static boolean existClient(String email){

        boolean result = false;
        String sql="select * from client where email='" + email + "'";
        System.out.print(sql);

        try {
            Connection c = DBHelper.getInstance().getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                if(!rs.getString(1).equals(null)){
                    result = true;
                }
            }
            DBHelper.closeConnection(c, s, rs);

        } catch (Exception e) {
            System.out.println("existClient()方法出错！");
            e.printStackTrace();
        }
        return result;
    }

    public static boolean existEmployee(String email){

        boolean result = false;
        String sql="select * from employee where email='" + email + "'";
        System.out.print(sql);

        try {
            Connection c = DBHelper.getInstance().getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                if(!rs.getString(1).equals(null)){
                    result = true;
                }
            }
            DBHelper.closeConnection(c, s, rs);

        } catch (Exception e) {
            System.out.println("existEmployee()方法出错！");
            e.printStackTrace();
        }
        return result;
    }


    public static String getPasswrod(String email){

        String password = "";
        String sql="select password from client where email='" + email + "'";
        System.out.print(sql);

        try {
            Connection c = DBHelper.getInstance().getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                password = rs.getString("password");
            }
            DBHelper.closeConnection(c, s, rs);

        } catch (Exception e) {
            System.out.println("getPassword()方法出错！");
            e.printStackTrace();
        }
        return password;
    }

    public static String getEPasswrod(String email){

        String password = "";
        String sql="select password from Employee where email='" + email + "'";
        System.out.print(sql);

        try {
            Connection c = DBHelper.getInstance().getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                password = rs.getString("password");
            }
            DBHelper.closeConnection(c, s, rs);

        } catch (Exception e) {
            System.out.println("getEPassword()方法出错！");
            e.printStackTrace();
        }
        return password;
    }

    public static String getName(String email){

        String username = "";
        String sql="select username from client where email='" + email + "'";
        System.out.print(sql);

        try {
            Connection c = DBHelper.getInstance().getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                username = rs.getString("username");
            }
            DBHelper.closeConnection(c, s, rs);

        } catch (Exception e) {
            System.out.println("getUsername()方法出错！");
            e.printStackTrace();
        }
        return username;
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
}
