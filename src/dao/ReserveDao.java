package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Reserve;
import utils.DBHelper;

public class ReserveDao {
	public static void reserve(String reader_id,String sbook_id){
		
		Date date=new Date();
		String today=Tool.dateTimeChange(date);
		
		String sql="insert into reserve(reader_id,sbook_id,reserve_time) values('" + reader_id + "','" + sbook_id + "','" + today + "')";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			
			DBHelper.closeConnection(c, s, null);
			
		} catch (Exception e) {
			System.out.println("reserve()方法出错！");
			e.printStackTrace();
		}
	}
	
	public static List<Reserve> getReserves(String reader_id){
		
		List<Reserve> reserves =new ArrayList<Reserve>();
		String sql = "select reserve.sbook_id,title,author,sbook.ISBN,reserve_time from reserve left join sbook on sbook.sbook_id=reserve.sbook_id "
				+ "left join book on book.ISBN=sbook.ISBN where reader_id='" + reader_id + "'";
		System.out.println(sql);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Reserve reserve = new Reserve();
				reserve.setSbook_id(rs.getString("sbook_id"));
				reserve.setTitle(rs.getString("title"));
				reserve.setAuthor(rs.getString("author"));
				reserve.setISBN(rs.getString("ISBN"));
				reserve.setReserve_time(Tool.dateTimeChange(rs.getTimestamp("reserve_time")));
				reserves.add(reserve);
			}
			DBHelper.closeConnection(c, s, rs);
			
			
		}  catch (Exception e) {
			System.out.println("getReserves()方法出错！");
            e.printStackTrace();
        }
		return reserves;
		
	}
	

}
