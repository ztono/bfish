package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.Category;
import utils.DBHelper;

public class CategoryDao {
	
	public static List<Category> getCategorys(){
		
		String sql = "select * from category";
		System.out.print(sql);
		
		List<Category> categorys = new ArrayList<Category>();
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Category category = new Category();
				category.setCategory_id(String.valueOf(rs.getInt("category_id")));
				category.setCategory_name(rs.getString("category_name"));
				categorys.add(category);
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("getBook()·½·¨³ö´í£¡");
			e.printStackTrace();
		}
		return categorys;
	}

}
