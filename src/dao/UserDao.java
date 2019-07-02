package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.DBHelper;

public class UserDao {
	public static boolean existUser(String user_id){
		
		boolean result = false;
		String sql="select count(*) from user where user_id='" + user_id + "'";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				if(rs.getInt(1) == 1){
					result = true;
				}
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("exitUser()方法出错！");
			e.printStackTrace();
		}
		return result;
	}
	
	public static String getEmail(String user_id){
		
		String email = "";
		String sql="select email from reader where reader_id='" + user_id + "'";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				email = rs.getString("email");
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("getEmail()方法出错！");
			e.printStackTrace();
		}
		return email;
	}
	public static String getPasswrod(String user_id){
		
		String password = "";
		String sql="select password from user where user_id='" + user_id + "'";
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
	public static String getUserName(String user_id){
		
		String name = "";
		String sql="select name from user where user_id='" + user_id + "'";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				name = rs.getString("name");
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("getUserName()方法出错！");
			e.printStackTrace();
		}
		return name;
	}

	public static boolean isUser(String user_id, String password){
		
		boolean result = false;
		String sql="select count(*) from user where user_id='" + user_id + "' and password='" + password + "'";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				if(rs.getInt(1) == 1){
					result = true;
				}
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("isUser()方法出错！");
			e.printStackTrace();
		}
		return result;
	}

	public static void updatePassword(String user_id, String password) {
		// TODO Auto-generated method stub
		
		String sql="update user set password='" + password + "' where user_id='" + user_id + "'";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			DBHelper.closeConnection(c, s, null);
			
		} catch (Exception e) {
			System.out.println("updatePassword()方法出错！");
			e.printStackTrace();
		}
	}
	
	public static void updateEmail(String user_id, String email) {
		// TODO Auto-generated method stub
		
		String sql="update reader set email='" + email + "' where reader_id='" + user_id + "'";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			DBHelper.closeConnection(c, s, null);
			
		} catch (Exception e) {
			System.out.println("updateEmail()方法出错！");
			e.printStackTrace();
		}
	}

	public static String getAble(String user_id) {
		// TODO Auto-generated method stub
		String able = "";
		String sql="select able from user where user_id='" + user_id + "'";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				able = rs.getString("able");
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("getAble()方法出错！");
			e.printStackTrace();
		}
		return able;
	}

	public static void updateName(String user_id, String name) {
		// TODO Auto-generated method stub
		String sql="update user set name='" + name + "' where user_id='" + user_id + "'";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			DBHelper.closeConnection(c, s, null);
			
		} catch (Exception e) {
			System.out.println("updateName()方法出错！");
			e.printStackTrace();
		}
	}
}
