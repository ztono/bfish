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

    public static boolean existmanager(String email){

        boolean result = false;
        String sql="select * from employee where email='" + email + "'and position ='manager'";
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

    public static String getEName(String email){

        String username = "";
        String sql="select username from employee where email='" + email + "'";
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
            System.out.println("getEname()方法出错！");
            e.printStackTrace();
        }
        return username;
    }
    public static String getEno(String email){

        String username = "";
        String sql="select employee_no from employee where email='" + email + "'";
        System.out.print(sql);

        try {
            Connection c = DBHelper.getInstance().getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                username = rs.getString("employee_no");
            }
            DBHelper.closeConnection(c, s, rs);

        } catch (Exception e) {
            System.out.println("getEname()方法出错！");
            e.printStackTrace();
        }
        return username;
    }

    public static int getCno(String email){

        String username = "";
        String sql="select client_no from client where email='" + email + "'";
        System.out.print(sql);

        try {
            Connection c = DBHelper.getInstance().getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                username = rs.getString("client_no");
            }
            DBHelper.closeConnection(c, s, rs);

        } catch (Exception e) {
            System.out.println("getEno()方法出错！");
            e.printStackTrace();
        }
        int client_no =Integer.parseInt(username);
        return client_no;
    }

    public static boolean ChangePassword(String email,String password) {

        String sql = "update client set password='"+ password +"' where email='" +email+"'";
        System.out.println(sql);

        int d=0;
        try {

            Connection c = (Connection) DAO.DBHelper.getInstance().getConnection();


            Statement s = (Statement) c.createStatement();
            s.executeUpdate(sql);
            DAO.DBHelper.closeConnection(c, s, null);
            d=1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(d==0) {return false;}
        else { return true;}
    }


    public static Client DisplayClient(String email){
        String sql = "select username,idcard,email,telephone from Client where email='" + email + "'";
        System.out.print(sql);
        Client client= new Client();
        try {
            Connection c = (Connection) DAO.DBHelper.getInstance().getConnection();
            Statement s = (Statement) c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {


                client.setEmail(rs.getString("email"));
                client.setIdcard(rs.getString("idcard"));
                client.setTelephone(rs.getString("telephone"));
                client.setUsername(rs.getString("username"));

            }
            DAO.DBHelper.closeConnection(c, s, rs);

        } catch (Exception e) {
            System.out.println("DisplayClient()方法出错");
            e.printStackTrace();
        }
        return client;
    }

    public static boolean updateClient(String email,String username,String idcard,String telephone,String password,int client_no){

        String sql = "update client set email='" + email +"',username='"+username+"',idcard='" + idcard + "',telephone='" + telephone + "',password='"
                + password +"'where client_no='" +client_no+"'";
        System.out.println(sql);
        int p=0;

        try {

            Connection c = (Connection) DAO.DBHelper.getInstance().getConnection();


            Statement s = (Statement) c.createStatement();
            s.executeUpdate(sql);
            DAO.DBHelper.closeConnection(c, s, null);
            p=1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(p==0) {return false;}
        else { return true;}
    }



}
