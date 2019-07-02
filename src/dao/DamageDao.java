package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.DBHelper;

public class DamageDao {
	public static void addDamage(String user_id,String Sbook_id,String description,String damage_fine) {

		try {

			Connection c = DBHelper.getInstance().getConnection();


			String sql = "insert into damage values(?,?,?,?)";
			
			PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user_id);
			ps.setString(2, Sbook_id);
			ps.setString(3, description);
			ps.setString(4, damage_fine);

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();

			DBHelper.closeConnection(c, ps, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
