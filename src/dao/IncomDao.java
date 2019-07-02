package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import utils.DBHelper;

public class IncomDao {
	public static String today(){
		try {
		Connection c = DBHelper.getInstance().getConnection();
		
		String sql="select SUM(fine) from borrow where to_days(realback_time) = to_days(now()); ";
				 PreparedStatement ps2 = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    
        ResultSet s1=ps2.executeQuery();
        if( s1.next()) {
      int i=s1.getInt(1);
      
      return String.valueOf(i);
        }
        else return "0";
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}
	public static String week(){
		try {
			Connection c = DBHelper.getInstance().getConnection();
		 String sql="SELECT SUM(fine) FROM borrow WHERE YEARWEEK(date_format(realback_time,'%Y-%m-%d')) = YEARWEEK(now());  ";
		 PreparedStatement ps2 = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet s1=ps2.executeQuery();
        if( s1.next()) {
            int i=s1.getInt(1);
            
            return String.valueOf(i);
              }
              else return "0";
      	}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}
	public static String total1(){
		try {
			int i=0;
			Connection c = DBHelper.getInstance().getConnection();
		 String sql="SELECT SUM(fine) FROM borrow ;  ";
		 PreparedStatement ps2 = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet s1=ps2.executeQuery();
        if( s1.next()) {
             i=s1.getInt(1);
        } 
    
            return String.valueOf(i);
              
             
      	}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}
	public static String total2(){
		try {
			int i=0;
			Connection c = DBHelper.getInstance().getConnection();
	
        String sql1="select SUM(register_money) from register_record  ";
		 PreparedStatement ps1 = c.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
	        ResultSet s11=ps1.executeQuery();
	        if( s11.next()) {
	             i=i+s11.getInt(1);
	        }
            return String.valueOf(i);
              
             
      	}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}
	public static String total(){
		try {
			int i=0;
			Connection c = DBHelper.getInstance().getConnection();
		 String sql="SELECT SUM(fine) FROM borrow ;  ";
		 PreparedStatement ps2 = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet s1=ps2.executeQuery();
        if( s1.next()) {
             i=s1.getInt(1);
        } 
        String sql1="select SUM(register_money) from register_record  ";
		 PreparedStatement ps1 = c.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
	        ResultSet s11=ps1.executeQuery();
	        if( s11.next()) {
	             i=i+s11.getInt(1);
	        }
            return String.valueOf(i);
              
             
      	}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}
	public static String month(){
		try {
		Connection c = DBHelper.getInstance().getConnection();
	
		
		 String sql="SELECT SUM(fine) FROM borrow WHERE DATE_FORMAT( realback_time, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ); ";
		 PreparedStatement ps2 = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		 
        ResultSet s1=ps2.executeQuery();
        if( s1.next()) {
            int i=s1.getInt(1);
            
            return String.valueOf(i);
              }
              else return "0";
      	}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}
	public static String today1(){
		try {
		Connection c = DBHelper.getInstance().getConnection();
		 Date date = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 String da=sdf.format(date);
		 System.out.println(da);
		 String sql="select SUM(register_money) from register_record where to_days(register_time) = to_days(now()); ";
				 PreparedStatement ps2 = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
     
        ResultSet s1=ps2.executeQuery();
        if( s1.next()) {
            int i=s1.getInt(1);
            
            return String.valueOf(i);
              }
              else return "0";
      	}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}
	public static String week1(){
		try {
		Connection c = DBHelper.getInstance().getConnection();
		 Date date = new Date();
	
		 String sql="SELECT * FROM register_record WHERE YEARWEEK(date_format(register_time,'%Y-%m-%d')) = YEARWEEK(now()); ";
		 PreparedStatement ps2 = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		
        ResultSet s1=ps2.executeQuery();
        if( s1.next()) {
            int i=s1.getInt(1);
            
            return String.valueOf(i);
              }
              else return "0";
      	}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}
	public static String month1(){
		try {
		Connection c = DBHelper.getInstance().getConnection();
	
		
		 String sql="SELECT SUM(register_money) FROM register_record WHERE DATE_FORMAT( register_time, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )";
		 PreparedStatement ps2 = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	
        ResultSet s1=ps2.executeQuery();
        if( s1.next()) {
            int i=s1.getInt(1);
            
            return String.valueOf(i);
              }
              else return "0";
      	}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}

	
	}


