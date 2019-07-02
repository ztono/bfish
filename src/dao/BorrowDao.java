package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Borrow;
import utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Calendar;

public class BorrowDao {
	
	public static List<String> getEmails(){
		List<String> emails = new ArrayList<String>();
		String sql = "SELECT distinct email from borrow left join reader on (borrow.reader_id = reader.reader_id) "
				+ "where realback_time is NULL and NOW() > shouldback_time;";
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				emails.add(rs.getString("email"));
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("getEmails()方法出错！");
			e.printStackTrace();
		}
		return emails;
	}
	
public static List<Borrow> getBorrows(String reader_id){
		
		List<Borrow> borrows =new ArrayList<Borrow>();
		String sql = "select sbook.sbook_id,title,author,book.ISBN,borrow_time,shouldback_time,realback_time,"
				+ "borrow.bookstatus,fine from borrow left join sbook on borrow.sbook_id=sbook.sbook_id left join book"
				+ " on sbook.ISBN = book.ISBN where reader_id='" + reader_id + "'";
		System.out.println(sql);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Borrow borrow = new Borrow();
				borrow.setSbook_id(rs.getString("sbook_id"));
				borrow.setTitle(rs.getString("title"));
				borrow.setAuthor(rs.getString("author"));
				borrow.setISBN(rs.getString("ISBN"));
				borrow.setBorrow_time(Tool.dateChange(rs.getTimestamp("borrow_time")));
				borrow.setShouldback_time(Tool.dateChange(rs.getTimestamp("shouldback_time")));
				borrow.setRealback_time(Tool.dateChange(rs.getTimestamp("realback_time")));
				borrow.setBookstatus(rs.getString("bookstatus"));
				borrow.setFine(String.valueOf(rs.getDouble("fine")));
				borrows.add(borrow);
			}
			DBHelper.closeConnection(c, s, rs);
			
			
		}  catch (Exception e) {
			System.out.println("getBorrows()方法出错！");
            e.printStackTrace();
        }
		return borrows;
		
	}
    
    public static int judge(String user_id) {
    	int flag=0;
    	try {
    		if (user_id!="") {
    			Connection c = DBHelper.getInstance().getConnection();
    			String sqla = "select * from user where user_id=?";
    			PreparedStatement psa = c.prepareStatement(sqla, Statement.RETURN_GENERATED_KEYS);
    			psa.setString(1, user_id);
    			ResultSet sa = psa.executeQuery();
    			if (sa.next()) {
    				String sql2 = "select count(*) from borrow where reader_id=? and realback_time is null;";
    				PreparedStatement ps2 = c.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
    				ps2.setString(1, user_id);
    				ResultSet s1 = ps2.executeQuery();

    				s1.next();
    				int i = s1.getInt(1);
    				System.out.println(i);
    				if (i<3) {
    					flag=1;
    				}
    				else {
    					System.out.println("超出最大借书数量");
    					flag=-3;
    				}
    			}
    			else {
    				System.out.println("找不到该用户");
    				flag=-2;
    			}
    		}
    		else {
    			System.out.println("请输入借书人");
    			flag=-1;
    		}
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
    	return flag;
    }
    
	public static int add(String user_id, String Sbook_id) {

		int flag = 0;
		try {

			
				if (Sbook_id!="") {
			Connection c = DBHelper.getInstance().getConnection();
			Date date = new Date();

			String sql3 = "select period from admin;";
			PreparedStatement ps3 = c.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);

			ResultSet s2 = ps3.executeQuery();
			s2.next();
			int day = s2.getInt(1);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar x = Calendar.getInstance();
			x.setTime(date);
			x.add(Calendar.DAY_OF_MONTH, day);
			Date date2 = x.getTime();
			String sql2 = "select count(*) from borrow where reader_id=? and realback_time is null;";
			PreparedStatement ps2 = c.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
			ps2.setString(1, user_id);
			ResultSet s1 = ps2.executeQuery();

			s1.next();
			int i = s1.getInt(1);
			System.out.println(i);

			

			
				String sqlb = "select * from sbook where sbook_id=?";
				PreparedStatement psb = c.prepareStatement(sqlb, Statement.RETURN_GENERATED_KEYS);
				psb.setString(1,Sbook_id);
				ResultSet sb = psb.executeQuery();
			

				if (sb.next()) {
					String sqla = "select reader_id from borrow where sbook_id=? and realback_time is null";
					PreparedStatement psa = c.prepareStatement(sqla, Statement.RETURN_GENERATED_KEYS);
					psa.setString(1,Sbook_id);
					ResultSet sa = psa.executeQuery();

					if (sa.next()==false||user_id==sa.getString(1)) {
						
						String sqlc="select reader_id from reserve where sbook_id=? ";
						PreparedStatement psc = c.prepareStatement(sqlc, Statement.RETURN_GENERATED_KEYS);
						psc.setString(1, Sbook_id);
						ResultSet sc = psc.executeQuery();
						
							
						if(sc.next()==false||user_id==sc.getString(1)) {
						
						String sql = "insert into borrow(reader_id,sbook_id,borrow_time,shouldback_time) values(?,?,?,?)";

						PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setString(1, user_id);
						ps.setString(2, Sbook_id);
						ps.setString(3, sdf.format(date));
						ps.setString(4, sdf.format(date2));

						ps.execute();

						ResultSet rs = ps.getGeneratedKeys();

						DBHelper.closeConnection(c, ps, rs);
						flag=1;
						}
						else {
							System.out.println("该书已被其他人预约");
							flag = 4;
						}
						
					} else {
						System.out.println("该书已被借出");
						flag = -1;
					}
				}

				else {
					System.out.println("找不到此书");
					flag = 3;
				}

			
				}
				else {
					System.out.println("请输入书号");
					flag=-3;
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static int returnbook( String Sbook_id) {

		int flag = 0;
		int x=0;
		try {
			
				if (Sbook_id!="") {
			Connection c = DBHelper.getInstance().getConnection();
			String sqla = "select * from sbook where sbook_id=? ";
			PreparedStatement psa = c.prepareStatement(sqla, Statement.RETURN_GENERATED_KEYS);
			psa.setString(1, Sbook_id);
			ResultSet sa = psa.executeQuery();
		
			if (sa.next()) {
				String sqlb = "select reader_id from borrow where sbook_id=? and realback_time is null";
				PreparedStatement psb = c.prepareStatement(sqlb, Statement.RETURN_GENERATED_KEYS);
				psb.setString(1, Sbook_id);
				ResultSet sb = psb.executeQuery();
				
				if (sb.next()) {
					
					
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String da = sdf.format(date);
					date = sdf.parse(da);
					long fine = 0;
					String user_id=sb.getString(1);

					String sql3 = "select shouldback_time from borrow where reader_id=? and sbook_id=? and realback_time is null";
					PreparedStatement ps3 = c.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);
					ps3.setString(1, user_id);

					ps3.setString(2, Sbook_id);
					System.out.println(ps3);
					ResultSet s2 = ps3.executeQuery();
					String day = new String();
					while (s2.next()) {
						day = new String(s2.getString(1));
					}
					System.out.println(day);
					Date should = sdf.parse(day);
					String sql4 = "select fine from admin";

					PreparedStatement ps4 = c.prepareStatement(sql4, Statement.RETURN_GENERATED_KEYS);
					ResultSet s4 = ps4.executeQuery();
					String money = new String();
					while (s4.next()) {
						money = new String(s4.getString(1));
					}
					long i = Long.parseLong(money);
					if (date.after(should)) {
						fine = (date.getTime() - should.getTime()) / (24 * 60 * 60 * 1000) * i;
						x=1;
					}
					String sql = "update borrow set realback_time=?,fine=? ,bookstatus=? where reader_id=? and sbook_id=? and realback_time is null";
					PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

					ps.setString(1, sdf.format(date));
					ps.setString(2, String.valueOf(fine));
					ps.setString(3, String.valueOf(x));
					ps.setString(4, user_id);
					ps.setString(5, Sbook_id);
					ps.execute();
					ResultSet rs = ps.getGeneratedKeys();

					System.out.println(sql);
					System.out.print(user_id);

				
					
					if(fine>0) {
						String sqlc="insert into fine(reader_id,fine) values(?,?)";
						PreparedStatement psc = c.prepareStatement(sqlc, Statement.RETURN_GENERATED_KEYS);
						psc.setString(1, user_id);
						psc.setString(2, String.valueOf(fine));
						psc.execute();
						ResultSet rsc = psc.getGeneratedKeys();
						System.out.println(sqlc);
						DBHelper.closeConnection(c, psc, rsc);
					}
					DBHelper.closeConnection(c, ps, null);
					flag=1;
					
				} else {
					System.out.println("此书没有被借出");
					flag = 3;
				}
			} else {
				System.out.println("系统没有存入此书");
				flag = 2;
			}
				}
				else {
					System.out.println("请输入书号");
					flag=-3;
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public static int Specialreturnbook(String Sbook_id, String fine, String type) {
		
		int flag=0;
		try {
			
				if (Sbook_id!="") {
					if (fine!="") {
             int x=0;
             if ("damaged".equals(type))
            	 x=2;
             else 
            	 x=3;
			Connection c = DBHelper.getInstance().getConnection();
			String sqla = "select * from sbook where sbook_id=? ";
			PreparedStatement psa = c.prepareStatement(sqla, Statement.RETURN_GENERATED_KEYS);
			psa.setString(1, Sbook_id);
			ResultSet sa = psa.executeQuery();
			
			if(sa.next()) {
				String sqlb = "select reader_id from borrow where sbook_id=? and realback_time is null";
				PreparedStatement psb = c.prepareStatement(sqlb, Statement.RETURN_GENERATED_KEYS);
				psb.setString(1, Sbook_id);			
				ResultSet sb = psb.executeQuery();
			
				if(sb.next()) {
					
			String user_id=sb.getString(1);		
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String da = sdf.format(date);
			date = sdf.parse(da);
			long fine1 = 0;

			String sql4 = "select fine from admin";

			PreparedStatement ps4 = c.prepareStatement(sql4, Statement.RETURN_GENERATED_KEYS);
			ResultSet s4 = ps4.executeQuery();
			String money = new String();
			while (s4.next()) {
				money = new String(s4.getString(1));
			}

			String sql3 = "select shouldback_time from borrow where reader_id=? and sbook_id=? and realback_time is null";
			PreparedStatement ps3 = c.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);
			ps3.setString(1, user_id);

			ps3.setString(2, Sbook_id);
			System.out.println(ps3);
			ResultSet s2 = ps3.executeQuery();
			String day = new String();
			while (s2.next()) {
				day = new String(s2.getString(1));
			}
			System.out.println(day);
			Date should = sdf.parse(day);
			long perday = Long.parseLong(money);
			if (date.after(should))
				fine1 = (date.getTime() - should.getTime()) / (24 * 60 * 60 * 1000) * perday;

			String sql = "update borrow set realback_time=?,fine=? ,bookstatus=? where reader_id=? and sbook_id=? and realback_time is null";
			PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, sdf.format(date));
			ps.setString(2, String.valueOf(fine1 + fine));
			ps.setString(3, String.valueOf(x));
			ps.setString(4, user_id);
			ps.setString(5, Sbook_id);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();

			System.out.println(sql);
			System.out.print(user_id);

			
			String sqlc="update sbook set bookstatus=? where sbook_id=?";
			PreparedStatement psc = c.prepareStatement(sqlc, Statement.RETURN_GENERATED_KEYS);
			psc.setString(1, type);
			psc.setString(2, Sbook_id);
			psc.execute();
			ResultSet rsc = psc.getGeneratedKeys();
		
			
			if(Integer.valueOf(fine)>0) {
				String sqld="insert into fine(reader_id,fine) values(?,?)";
				PreparedStatement psd = c.prepareStatement(sqld, Statement.RETURN_GENERATED_KEYS);
				psd.setString(1, user_id);
				psd.setString(2, String.valueOf(fine));
				psd.execute();
				ResultSet rsd = psd.getGeneratedKeys();
				System.out.println(sqld);
				DBHelper.closeConnection(c, psd, rsd);
			}
			DBHelper.closeConnection(c, psc, rsc);
		flag=1;
				
				}
				
				else {
					System.out.println("此书没有被借出");
					flag = 3;
				}
			}
			else {
				System.out.println("系统没有存入此书");
				flag = 2;
			}
		}
			else {
				System.out.println("请输入价格");
				flag=-2;
			}
		}
		else {
			System.out.println("请输入书号");
			flag=-3;
		}
	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
}
