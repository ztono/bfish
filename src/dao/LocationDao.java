package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.Category;
import entity.Location;
import utils.DBHelper;

public class LocationDao {
	
	public static List<Location> getLocations(){
		
		String sql = "select * from location";
		System.out.print(sql);
		
		List<Location> locations = new ArrayList<Location>();
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Location location=new Location();
				location.setLocation_id(String.valueOf(rs.getInt("location_id")));
				location.setLocation_name(rs.getString("location_name"));
				locations.add(location);
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("getLocation()��������");
			e.printStackTrace();
		}
		return locations;
	}

}
