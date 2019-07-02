package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import utils.DBHelper;

public class Sbookdao {
	public static void damage(String sbook_id){
		String sql = "update sbook set bookstatus=? where sbook_id="+sbook_id;
		System.out.println(sql);
	
		try {
			Connection c = DBHelper.getInstance().getConnection();
			PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, "damaged");
			ps.execute();
			DBHelper.closeConnection(c, ps, null);
			
		}  catch (Exception e) {
			
	        e.printStackTrace();
	    }
		
	}	
	public static void lost(String sbook_id){
		String sql = "update sbook set bookstatus=? where sbook_id="+sbook_id;
		System.out.println(sql);
	
		try {
			Connection c = DBHelper.getInstance().getConnection();
			PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, "lost");
			ps.execute();
			DBHelper.closeConnection(c, ps, null);
			
		}  catch (Exception e) {
			
	        e.printStackTrace();
	    }
		
	}	
}
