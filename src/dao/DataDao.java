package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Data;

import utils.DBHelper;

import entity.User;

public class DataDao {
	
	

	public static Data showData(){
		Data data = new Data();
		String sql="select fine,period,deposit from admin";
		System.out.print(sql);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()){
				
				String fine = rs.getString("fine");
				String period = rs.getString("period");
				String deposit = rs.getString("deposit");
				data.setFine(fine);
				data.setPeriod(period);
				data.setDeposit(deposit);
				
						
			}
			
			DBHelper.closeConnection(c, s, null);
			
		} catch (Exception e) {
			System.out.println("updateOne()方法出错！");
			e.printStackTrace();
		}
		return data;
	}
	
	public static void Fchange(String fine) {
		String sql = "UPDATE admin SET fine= '" + fine + "'";
		
		System.out.println(sql);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			DBHelper.closeConnection(c, s, null);
			

		} catch (Exception e) {
			System.out.println("Fchange()方法出错！");
	        e.printStackTrace();
	    }
		
	}
	public static void Pchange(String period) {
		String sql = "UPDATE admin SET period= '" + period + "'";
		
		System.out.println(sql);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			DBHelper.closeConnection(c, s, null);
			

		} catch (Exception e) {
			System.out.println("Pchange()方法出错！");
	        e.printStackTrace();
	    }
		
	}
	public static void Dchange(String deposit) {
		String sql = "UPDATE admin SET deposit= '" + deposit + "'";
		
		System.out.println(sql);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			DBHelper.closeConnection(c, s, null);
			

		} catch (Exception e) {
			System.out.println("Dchange()方法出错！");
	        e.printStackTrace();
	    }
		
	}
	
}