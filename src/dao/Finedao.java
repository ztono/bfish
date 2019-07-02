package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Borrow;
import entity.Fine;
import utils.DBHelper;

public class Finedao {
public static List<Fine> getFine(String reader_id){
		
		List<Fine> fines =new ArrayList<Fine>();
		String sql = "select * from Fine where reader_id=" + reader_id;
		System.out.println(sql);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Fine fine = new Fine();
				fine.setFID(rs.getString("FID"));
				fine.setReader_id(rs.getString("reader_id"));
				fine.setFine(rs.getString("fine"));
				fines.add(fine);
			}
			DBHelper.closeConnection(c, s, rs);
			
			
		}  catch (Exception e) {
			System.out.println("get方法出错！");
            e.printStackTrace();
        }
		return fines;
		
	}
public static List<Fine> getPFine(String reader_id){
	
	List<Fine> fines =new ArrayList<Fine>();
	String sql =  "select * from PFine where reader_id=" + reader_id;
	System.out.println(sql);
	try {
		Connection c = DBHelper.getInstance().getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while (rs.next()) {
			Fine fine = new Fine();
			fine.setFID(rs.getString("FID"));
			fine.setReader_id(rs.getString("reader_id"));
			fine.setFine(rs.getString("fine"));
			fines.add(fine);
		}
		DBHelper.closeConnection(c, s, rs);
		
		
	}  catch (Exception e) {
		System.out.println("get方法出错！");
        e.printStackTrace();
    }
	return fines;
	
}
public static void Pay(String FID){
	Fine fine=new Fine();
	System.out.println(FID);
	String sql =  "select * from Fine where FID=" +FID ;
	System.out.println(sql);
	try {
		Connection c = DBHelper.getInstance().getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while (rs.next()) {
			
			fine.setFID(rs.getString("FID"));
			fine.setReader_id(rs.getString("reader_id"));
			fine.setFine(rs.getString("fine"));
		
		}
		
		String sql2 = "insert into PFine(reader_id,fine) values(?,?)";

		PreparedStatement ps = c.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, fine.getReader_id());
		ps.setString(2, fine.getFine());
		ps.execute();
		String sql3="delete from Fine where FID="+fine.getFID();
		PreparedStatement ps2 = c.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);
	     ps2.execute();
		DBHelper.closeConnection(c, s, rs);
		
		
	}  catch (Exception e) {
		System.out.println("getfines()方法出错！");
        e.printStackTrace();
    }

	
}
}

