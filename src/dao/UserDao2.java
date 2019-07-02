package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import utils.DBHelper;

public class UserDao2 {
	
	public static List<User> getUsers(){
		
		List<User> users = new ArrayList<User>();
		
		String sql="select user_id,name,password,able from user";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()){
				User user = new User();
				String user_id = rs.getString("user_id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String able = rs.getString("able");
				user.setUser_id(user_id);
				user.setName(name);
				user.setPassWord(password);
				user.setAble(able);				
				users.add(user);
			}
			
			DBHelper.closeConnection(c, s, null);
			
		} catch (Exception e) {
			System.out.println("getUsers()方法出错！");
			e.printStackTrace();
		}
		return users;
	}
	
	public static void deleteUser(String user_id){
		String sql = "delete from user where user_id=  '" + user_id + "' ";
		System.out.println(sql);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			DBHelper.closeConnection(c, s, null);
			
		}  catch (Exception e) {
			System.out.println("deleteUser()方法出错！");
            e.printStackTrace();
        }
	}
	public static void addUser(String user_id,String name,String password) {
		String able="1";
		String sql = "INSERT INTO user SET user_id = '" + user_id + "', name = '" + name + "', password = '" + password + "',able= '" + able + "'";
		System.out.println(sql);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			DBHelper.closeConnection(c, s, null);
			

		} catch (Exception e) {
			System.out.println("addUser()方法出错！");
            e.printStackTrace();
        }
	}
public static List<User> getUser(String  name){
		
		List<User> users = new ArrayList<User>();
		
		String sql="select user_id,name,password,able from user where name='" + name + "' ";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()){
				User user = new User();

				String user_id = rs.getString("user_id");
				String password = rs.getString("password");
				String able = rs.getString("able");
				user.setUser_id(user_id);
				user.setName(name);
				user.setPassWord(password);
				user.setAble(able);				
				users.add(user);
			}
			
			DBHelper.closeConnection(c, s, null);
			
		} catch (Exception e) {
			System.out.println("getUser()方法出错！");
			e.printStackTrace();
		}
		return users;
	}
	
public static User updateOne(String  user_id){
	
	User user = new User();
	
	String sql="select user_id,name,password,able from user where user_id='" + user_id + "' ";
	System.out.print(sql);
	
	try {
		Connection c = DBHelper.getInstance().getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while(rs.next()){
			
			String name = rs.getString("name");
			String password = rs.getString("password");
			String able = rs.getString("able");
			user.setUser_id(user_id);
			user.setName(name);
			user.setPassWord(password);
			user.setAble(able);				
		}
		
		DBHelper.closeConnection(c, s, null);
		
	} catch (Exception e) {
		System.out.println("updateOne()方法出错！");
		e.printStackTrace();
	}
	return user;
}
public static void updateTwo(String user_id,String user_id1,String name,String password) {
	String able="1";
	String sql = "UPDATE user SET  user_id= '"+user_id1+"',name = '" + name + "',password= '" + password + "',able= '" + able + "'where user_id= '" + user_id + "'";
	
	System.out.println(sql);
	try {
		Connection c = DBHelper.getInstance().getConnection();
		Statement s = c.createStatement();
		s.executeUpdate(sql);
		DBHelper.closeConnection(c, s, null);
		

	} catch (Exception e) {
		System.out.println("updateTwo()方法出错！");
        e.printStackTrace();
    }
}

public static void setUser(String user_id) {
	String password="00010001";
	String sql = "UPDATE user SET  password= '" + password + "'where user_id= '" + user_id + "'";
	
	System.out.println(sql);
	try {
		Connection c = DBHelper.getInstance().getConnection();
		Statement s = c.createStatement();
		s.executeUpdate(sql);
		DBHelper.closeConnection(c, s, null);
		

	} catch (Exception e) {
		System.out.println("updateTwo()方法出错！");
        e.printStackTrace();
    }
	
}
}
