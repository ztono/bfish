package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Reader;
import utils.DBHelper;

public class ReaderDao {
	
	public static List<Reader> getReaders(){				//edited		//edited
		
		List<Reader> readers = new ArrayList<Reader>();
		
		String sql="select user.user_id,user.name,email from reader,user\r\n" + 
				"where user.user_id=reader.reader_id ";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()){
				Reader reader = new Reader();
				String reader_id = rs.getString("user_id");
				String name = rs.getString("name");
				//String password = rs.getString("password");
				String email = rs.getString("email");

				reader.setReader_id(reader_id);
				reader.setName(name);
				//reader.setPassword(password);
				reader.setEmail(email);

				readers.add(reader);
			}
			
			DBHelper.closeConnection(c, s, null);
			
		} catch (Exception e) {
			System.out.println("getReaders() error£¡");
			e.printStackTrace();
		}
		return readers;
	}
	
	
	public static int deleteReader(String reader_id){			//edited
		String sql_exam = "select count(*) from borrow where reader_id=? and realback_time is null;";
		
		
		String sql_1 = "delete from reader where reader_id=  '" + reader_id + "' ";
		String sql_2 = "delete from user where user_id=  '" + reader_id + "' ";
		System.out.println(sql_1);
		System.out.println(sql_2);
		try {
			
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			PreparedStatement ps2 = c.prepareStatement(sql_exam, Statement.RETURN_GENERATED_KEYS);
			ps2.setString(1, reader_id);
			ResultSet s1 = ps2.executeQuery();
			s1.next();
			int i = s1.getInt(1);
			if (i == 0) 
			{
				s.executeUpdate(sql_1);
				s.executeUpdate(sql_2);
				DBHelper.closeConnection(c, s, null);
				return 1;
			}
			else
			{
				DBHelper.closeConnection(c, s, null);
				return 0;
			}
		}  catch (Exception e) {
			System.out.println("deleteReader() error£¡");
            e.printStackTrace();
        }
		return 0;
	}
	
	
	public static void addReader(String user_id,String name,String email) {			///edited
		String able = "0";
		String password = "12345678";
		String sql_1 = "INSERT INTO user VALUES ( '" + user_id + "','" + name + "','" + password + "','" + able + "');" ;
		String sql_2 = "INSERT INTO reader VALUES ( '" + user_id + "','" + email + "');";
		String sql_3 = "INSERT INTO register_record(register_time,register_money) VALUES (NOW(),(SELECT deposit FROM admin))";
		
		System.out.println(sql_1);
		System.out.println(sql_2);
		System.out.println(sql_3);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql_1);
			s.executeUpdate(sql_2);
			s.executeUpdate(sql_3);
			DBHelper.closeConnection(c, s, null);
			

		} catch (Exception e) {
			System.out.println("addReader() error£¡");
            e.printStackTrace();
        }
	}
	
	
	public static List<Reader> getReader(String  reader_id){			//edited		//edited
		
		List<Reader> readers = new ArrayList<Reader>();
		
		String sql="select user.user_id,user.name,email from reader,user\r\n"  + 
				"where user.user_id=reader.reader_id and user.user_id='" + reader_id + "' ";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()){
				Reader reader = new Reader();
				String name = rs.getString("name");
				//String password = rs.getString("password");
				String email = rs.getString("email");

				reader.setReader_id(reader_id);
				reader.setName(name);
				//reader.setPassword(password);
				reader.setEmail(email);

				readers.add(reader);
			}
			
			DBHelper.closeConnection(c, s, null);
			
		} catch (Exception e) {
			System.out.println("getReader() error£¡");
			e.printStackTrace();
		}
		return readers;
	}
	
public static List<Reader> getReaderByName(String  name){			//edited		//new
		
		List<Reader> readers = new ArrayList<Reader>();
		
		String sql="select reader.reader_id,user.name,email from reader,user\r\n"  + 
				"where user.user_id=reader.reader_id and user.name='" + name + "' ";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()){
				Reader reader = new Reader();
				String reader_id = rs.getString("reader_id");
				//String password = rs.getString("password");
				String email = rs.getString("email");

				reader.setReader_id(reader_id);
				reader.setName(name);
				//reader.setPassword(password);
				reader.setEmail(email);

				readers.add(reader);
			}
			
			DBHelper.closeConnection(c, s, null);
			
		} catch (Exception e) {
			System.out.println("getReaderByName() error£¡");
			e.printStackTrace();
		}
		return readers;
	}


	public static Reader updateOne(String  reader_id){			//edited		//edited
	
		Reader reader = new Reader();
		
		String sql="select user.user_id,user.name,email from reader,user\r\n"  + 
				"where user.user_id=reader.reader_id and user.user_id='" + reader_id + "' ";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
		
			while(rs.next()){
			
				String name = rs.getString("name");
				//String password = rs.getString("password");
				String email = rs.getString("email");

				reader.setReader_id(reader_id);
				reader.setName(name);
				//reader.setPassword(password);
				reader.setEmail(email);

			}
		
			DBHelper.closeConnection(c, s, null);
		
		} catch (Exception e) {
			System.out.println("ReaderDao.updateOne() error£¡");
			e.printStackTrace();
		}
		return reader;
	}
	
	
	public static void updateTwo(String reader_id,String name,String email) {			//edited		//edited
		
		String sql_1 = "UPDATE user SET  name = '" + name + "'where user_id= '" + reader_id + "';";
		String sql_2 = "UPDATE reader SET  email = '" + email + "' where reader_id= '" + reader_id + "'";
	
		System.out.println(sql_1);
		System.out.println(sql_2);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql_1);
			s.executeUpdate(sql_2);
			DBHelper.closeConnection(c, s, null);
		

		} catch (Exception e) {
			System.out.println("ReaderDao.updateTwo() error£¡");
			e.printStackTrace();
		}
	}
}
