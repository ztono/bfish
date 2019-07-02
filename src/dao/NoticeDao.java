package dao;			//onomei

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Notice;
import entity.Reader;
import utils.DBHelper;

public class NoticeDao {

	public static List<Notice> getNotices() {
		// TODO Auto-generated method stub
		
		List<Notice> notices = new ArrayList<Notice>();
		String sql="select notice_id,name,notice_time,content from notice natural join user";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Notice notice = new Notice();
				notice.setNotice_id(rs.getString("notice_id"));
				notice.setName(rs.getString("name"));
				notice.setNotice_time(Tool.dateTimeChange(rs.getTimestamp("notice_time")));
				notice.setContent(rs.getString("content"));
				notices.add(notice);
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("geNotices()·½·¨³ö´í£¡");
			e.printStackTrace();
		}
		return notices;
	}
	
	
	public static void deleteNotice(String notice_id){			//edited
		String sql = "delete from notice where notice_id=  '" + notice_id + "' ";
		System.out.println(sql);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			DBHelper.closeConnection(c, s, null);
			
		}  catch (Exception e) {
			System.out.println("deleteNotice() error£¡");
            e.printStackTrace();
        }
	}
	
	
	public static void addNotice(String user_id,String content) {			//edited
		String sql = "insert into notice(user_id,content,notice_time) values ('" + user_id + "','" + content + "',NOW())";
		
		
		System.out.println(sql);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			DBHelper.closeConnection(c, s, null);
			

		} catch (Exception e) {
			System.out.println("addNotice() error£¡");
            e.printStackTrace();
        }
	}
	
	public static Notice updateOne(String  notice_id){			//edited
		
		Notice notice = new Notice();
		
		String sql="select content from notice where notice_id='" + notice_id + "' ";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
		
			while(rs.next()){
			
				//String name = rs.getString("name");
				//String password = rs.getString("password");
				String content = rs.getString("content");

				//reader.setReader_id(reader_id);
				//reader.setName(name);
				//reader.setPassword(password);
				notice.setContent(content);

			}
		
			DBHelper.closeConnection(c, s, null);
		
		} catch (Exception e) {
			System.out.println("NoticeDao.updateOne() error£¡");
			e.printStackTrace();
		}
		return notice;
	}
	
	
	public static void updateTwo(String notice_id,String content) {			//edited
		
		String sql = "UPDATE notice SET  content = '" + content + "'where notice_id ='" + notice_id + "';";
		
	
		System.out.println(sql);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			DBHelper.closeConnection(c, s, null);
		

		} catch (Exception e) {
			System.out.println("NoticeDao.updateTwo() error£¡");
			e.printStackTrace();
		}
	}
	
	
	/*
	public static List<Reader> getNotice(String  reader_id){			//edited
		
		List<Reader> readers = new ArrayList<Reader>();
		
		String sql="select user.user_id,`user`.`name`,`user`.`password`,email from reader,user\r\n"  + 
				"where user.user_id=reader.reader_id and user.user_id='" + reader_id + "' ";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()){
				Reader reader = new Reader();
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");

				reader.setReader_id(reader_id);
				reader.setName(name);
				reader.setPassword(password);
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
	*/
}
