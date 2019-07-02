package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.Borrow;
import entity.SBook;
import utils.DBHelper;

public class BookDao {
	
	public static List<Book> getBooks(String title,String author,String press,String category_id){
		String sql = "select ISBN,title,author,press,category_name,total,canborrow from book left join " + 
"category on book.category_id=category.category_id left join " +
"(select ISBN as I1,count(ISBN) as total from sbook group by ISBN) as one on book.ISBN=one.I1 left join " +
"(select ISBN as I2,count(ISBN) as canborrow from sbook where sbook_id not in (select sbook_id from borrow) " +
"and sbook_id not in (select sbook_id from reserve) group by ISBN) as two on book.ISBN=two.I2 " + 
"where title like '%" + title + "%' and author like '%" + author + "%' and press like '%" + press + "%' ";
		if(!("".equals(category_id) || category_id == null)){
			sql = sql + "and category.category_id=" + category_id ;
		}
		System.out.print(sql);
		
		List<Book> books = new ArrayList<Book>();
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Book book = new Book();
				String ISBN = rs.getString("ISBN");
				String newtitle = rs.getString("title");
				String newauthor = rs.getString("author");
				String newpress = rs.getString("press");
				String category_name = rs.getString("category_name");
				String total = String.valueOf(rs.getInt("total"));
				String canborrow = String.valueOf(rs.getInt("canborrow"));
				book.setISBN(ISBN);
				book.setTitle(newtitle);
				book.setAuthor(newauthor);
				book.setPress(newpress);
				book.setCategory_name(category_name);
				book.setTotal(total);
				book.setCanborrow(canborrow);
				books.add(book);
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("getBooks()��������");
			e.printStackTrace();
		}
		return books;
		
	}

	public static Book getBook(String ISBN) {
		// TODO Auto-generated method stub
		String sql = "select * from book natural join location natural join category where ISBN='" + ISBN + "'";
		System.out.print(sql);
		
		Book book = new Book();
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				book.setISBN(ISBN);
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getString("price"));
				book.setIntroduce(rs.getString("introduce"));
				book.setLocation_name(rs.getString("location_name"));
				book.setCategory_name(rs.getString("category_name"));
				book.setCallnumber(rs.getString("callnumber"));
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("getBook()��������");
			e.printStackTrace();
		}
		return book;
	}

	public static List<SBook> getSbooks(String ISBN) {
		// TODO Auto-generated method stub
		String sql = "select sbook.sbook_id,shouldback_time,reserve_time from sbook "
				+ "left join (select * from borrow where realback_time is null) as b on sbook.sbook_id=b.sbook_id "
				+ "left join reserve on sbook.sbook_id=reserve.sbook_id "
				+ "where ISBN='" + ISBN + "'";
		List<SBook> sbooks = new ArrayList<SBook>();
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				SBook sbook = new SBook();
				String sbook_id = rs.getString("sbook_id");
				String shouldback_time = Tool.dateChange(rs.getTimestamp("shouldback_time"));
				String reserve_time = Tool.dateTimeChange(rs.getTimestamp("reserve_time"));
				
				sbook.setSbook_id(sbook_id);
				sbook.setShouldback_time(shouldback_time);
				sbook.setReserve_time(reserve_time);
				sbooks.add(sbook);
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("getSBooks()��������");
			e.printStackTrace();
		}
		return sbooks;
	}

	public static Book homeSearchBook(String search) {
		// TODO Auto-generated method stub
		String sql = "select * from book natural join location natural join category where title='" + search + "' or author='" + search + "' limit 1";
		System.out.print(sql);
		
		Book book = new Book();
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				book.setISBN(rs.getString("ISBN"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getString("price"));
				book.setIntroduce(rs.getString("introduce"));
				book.setLocation_name(rs.getString("location_name"));
				book.setCategory_name(rs.getString("category_name"));
				book.setCallnumber(rs.getString("callnumber"));
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("getBook()��������");
			e.printStackTrace();
		}
		return book;
	}

}
