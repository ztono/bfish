package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entity.Book;
import entity.Category;
import entity.Delete;
import entity.Location;
import entity.SBook;

import utils.DBHelper;

public class BookDao2 {
	
/*灞曠ず鍥句功棣嗘墍鏈変功鐨勭绫�*/	
	public static List<Category> ShowCategory(){
		
		List<Category> categorys = new ArrayList<Category>();
		String sql = "select * from category";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {

				Category category= new Category();
				
				category.setCategory_id(String.valueOf(rs.getInt("category_id")));
				
				
				category.setCategory_name(rs.getString("category_name"));
				
				categorys.add(category);
				
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("showCategory()锟斤拷锟斤拷锟斤拷锟斤拷");
			e.printStackTrace();
		}
		return categorys;
	}
public static List<Location> ShowLocation(){
		
		List<Location> locations= new ArrayList<Location>();
		String sql = "select * from location";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {

				Location location= new Location();
				
				location.setLocation_id(String.valueOf(rs.getInt("location_id")));
				
				
				location.setLocation_name(rs.getString("location_name"));
				
				locations.add(location);
				
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("showLocation()锟斤拷锟斤拷锟斤拷锟斤拷");
			e.printStackTrace();
		}
		return locations;
	}	
/*灞曠ず鏌愪竴绉嶇被涓寘鍚殑鎵�鏈夊浘涔�*/	
	public static List<Book> Showbooks(int category_id) {
		// TODO Auto-generated method stub
		List<Book> books = new ArrayList<Book>();
		String sql = "select * from book natural join category "
			+ "where category_id=" +category_id;
		System.out.print(sql);
		
	
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Book book = new Book();
				book.setCategory_id(String.valueOf(category_id));
				book.setCategory_name(rs.getString("category_name"));
				book.setISBN(rs.getString("ISBN"));
				book.setPrice(rs.getString("price"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setIntroduce(rs.getString("introduce"));
				book.setLocation_id(rs.getString("location_id"));
				book.setCallnumber(rs.getString("callnumber"));
				books.add(book);
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("showBooks()锟斤拷锟斤拷锟斤拷锟斤拷");
			e.printStackTrace();
		}
		return books;
	}
	
/*灞曠ず鏌愪竴纭畾鐨処SBN涓嬬殑涔︾殑sbook_id*/	
	public static List<SBook> getSbooks(String ISBN) {
		// TODO Auto-generated method stub
		List<SBook> sbooks = new ArrayList<SBook>();
		String sql = "select * from sbook "
			+ "where ISBN='" + ISBN + "'";
		System.out.print(sql);
		
	
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				SBook sbook = new SBook();
				String sbook_id = rs.getString("sbook_id");
				String bookstatus= rs.getString("bookstatus");
				sbook.setISBN(ISBN);
				sbook.setSbook_id(sbook_id);
				sbook.setBookstatus(bookstatus);
				sbooks.add(sbook);
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("getSBooks()锟斤拷锟斤拷锟斤拷锟斤拷");
			e.printStackTrace();
		}
		return sbooks;
	}
/*娣诲姞鏂扮殑鍥句功绉嶇被*/
	public static int addCategory(String category_name) throws Exception {
		
		
		int flag=2;
		
		try {
		
		Connection c = DBHelper.getInstance().getConnection();
		String sqla="select category_name from category where category_name='"+ category_name + "'"; 
		
		System.out.println(sqla);
		PreparedStatement psa =c.prepareStatement(sqla, Statement.RETURN_GENERATED_KEYS);
		ResultSet sa = psa.executeQuery();
		if (sa.next()) {
		
		flag=2;}
		
		
		else {
		
		String sql = "insert into category set category_name='"+ category_name + "'";
		System.out.println(sql);
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			
			DBHelper.closeConnection(c, s, null);
		flag=3;
		}

		} catch (Exception e) {
			System.out.println("addCategory()方法出错�?");
	        e.printStackTrace();
	    }
		return flag;
		
	}
/*鍒犻櫎鍥句功绉嶇被*/	
public static boolean deleteCategory(int category_id){
	String sql = "delete from category where category_id=  "+ category_id 
			+ " and " + category_id + "  not in(select category_id from book)";
	System.out.println(sql);
	int d=0;
	try {
		Connection c = DBHelper.getInstance().getConnection();
		Statement s = c.createStatement();
		d = s.executeUpdate(sql);
		DBHelper.closeConnection(c, s, null);
		
	}  catch (Exception e) {
		System.out.println("deleteCategory()鏂规硶鍑洪敊锟�?");
        e.printStackTrace();
    }
	if(d==0) {return false;}
	else { return true;}
}	
/*add location*/
public static int addLocation(String location_name) throws Exception {
	
	
	int flag=2;
	
	try {
	
	Connection c = DBHelper.getInstance().getConnection();
	String sqla="select location_name from location where location_name='"+ location_name + "'"; 
	
	System.out.println(sqla);
	PreparedStatement psa =c.prepareStatement(sqla, Statement.RETURN_GENERATED_KEYS);
	ResultSet sa = psa.executeQuery();
	if (sa.next()) {
	
	flag=2;}
	
	
	else {
	
	String sql = "insert into location set location_name='"+ location_name + "'";
	System.out.println(sql);
		Statement s = c.createStatement();
		s.executeUpdate(sql);
		
		DBHelper.closeConnection(c, s, null);
	flag=3;
	}

	} catch (Exception e) {
		System.out.println("addLocation()方法出错�?");
        e.printStackTrace();
    }
	return flag;
	
}

public static boolean deleteLocation(int location_id){
	String sql = "delete from location where location_id= "+ location_id ;
	System.out.println(sql);
	int d=0;
	try {
		Connection c = DBHelper.getInstance().getConnection();
		Statement s = c.createStatement();
		d = s.executeUpdate(sql);
		DBHelper.closeConnection(c, s, null);
		d=1;
	}  catch (Exception e) {
		System.out.println("deleteLocation()鏂规硶鍑洪敊锟�?");
        e.printStackTrace();
    }
	if(d==0) {return false;}
	else { return true;}
}	


public static void updateLocation(int location_id,String location_name) {

	String sql = "update location set location_name='" + location_name +
					"' where location_id=" +location_id;
System.out.println(sql);


try {

	Connection c = DBHelper.getInstance().getConnection();
	
	
	Statement s = c.createStatement();
	s.executeUpdate(sql);
	DBHelper.closeConnection(c, s, null);


} catch (Exception e) {
	e.printStackTrace();
}

}		

/*灞曠ず閫変腑鐨刬d鐨勭绫讳俊鎭�*/
public static Location getLocation(int location_id) {

	
	Location location=new Location();

	String sql = "select * from location where location_id=" +location_id;
System.out.println(sql);


try {

	Connection c = DBHelper.getInstance().getConnection();
	
	
	Statement s = c.createStatement();
	
	ResultSet rs = s.executeQuery(sql);
	while(rs.next()){
		

		String location_name=rs.getString("location_name");
		
		location.setLocation_id(String.valueOf(location_id));
		location.setLocation_name(location_name);
	}
	
	DBHelper.closeConnection(c, s, null);


} catch (Exception e) {
	e.printStackTrace();
}
return location;
}		

/*鏇存柊鐩綍*/

public static void updateCategory(int category_id,String category_name) {

	String sql = "update category set category_name='" + category_name +
					"' where category_id=" +category_id;
System.out.println(sql);


try {

	Connection c = DBHelper.getInstance().getConnection();
	
	
	Statement s = c.createStatement();
	s.executeUpdate(sql);
	DBHelper.closeConnection(c, s, null);


} catch (Exception e) {
	e.printStackTrace();
}

}		

/*灞曠ず閫変腑鐨刬d鐨勭绫讳俊鎭�*/
public static Category getCategory(int category_id) {

	
	Category category=new Category();

	String sql = "select * from category where category_id=" +category_id;
System.out.println(sql);


try {

	Connection c = DBHelper.getInstance().getConnection();
	
	
	Statement s = c.createStatement();
	
	ResultSet rs = s.executeQuery(sql);
	while(rs.next()){
		

		String category_name=rs.getString("category_name");
		
		category.setCategory_id(String.valueOf(category_id));
		category.setCategory_name(category_name);
	}
	
	DBHelper.closeConnection(c, s, null);


} catch (Exception e) {
	e.printStackTrace();
}
return category;
}		

public static int addBook(String ISBN,int category_id,String price,String title,String author,String press,String introduce,int location_id,String callnumber,int number,String bookstatus) {
	

	int flag=2;
	
	try {
	String sql = "insert into book set ISBN='" + ISBN + "',category_id="+category_id+",price='"+price+"',title='"+title+"',author='"+author+"',press='"+press+"',introduce='"+introduce+"',location_id='"+location_id+"',callnumber='"+callnumber+ "'";
	
	System.out.println(sql);
	Connection c = DBHelper.getInstance().getConnection();
		Statement s = c.createStatement();
		s.executeUpdate(sql);
		flag=3;
		for(int i=0;i<number;i++)
		{
		String sqlc = "insert into sbook set ISBN='" + ISBN + "',bookstatus='"+bookstatus+ "'";
		System.out.println(sqlc);
		try {		
			
			Statement s1 = c.createStatement();
			s1.executeUpdate(sqlc);
			
		
		} catch (Exception e) {
			System.out.println("add()鏂规硶鍑洪敊锟�?");
	        e.printStackTrace();
	    }}
		DBHelper.closeConnection(c, s, null);}
	 catch (Exception e) {
		System.out.println("addBook()方法出错�?");
        e.printStackTrace();
    }
	return flag;
}

public static int deleteBook(String ISBN){
	

	int flag=0;
	
	try {
	
	Connection c = DBHelper.getInstance().getConnection();
	String sqla="select sbook_id from sbook where ISBN='"+ ISBN+ "'"; 
	
	System.out.println(sqla);
	PreparedStatement psa =c.prepareStatement(sqla, Statement.RETURN_GENERATED_KEYS);
	ResultSet sa = psa.executeQuery();
	if (sa.next()) {
	
	flag=0;}
	else {
	String sql = "delete from book where ISBN=  '" + ISBN 
			+ "'";
	System.out.println(sql);
	
		
		Statement s = c.createStatement();
		s.executeUpdate(sql);
		DBHelper.closeConnection(c, s, null);
		flag=1;
		
	}  
	}catch (Exception e) {
		System.out.println("deleteBook()方法出错�?");
        e.printStackTrace();
    }
	return flag;
}	

/*  */


/*鏇存柊涔︾殑淇℃伅*/
public static Book updateOne(String ISBN) {

	
	Book book=new Book();

	String sql = "select * from book where ISBN='" +ISBN+"' ";



System.out.println(sql);


try {

	Connection c = DBHelper.getInstance().getConnection();
	
	
	Statement s = c.createStatement();
	
	ResultSet rs = s.executeQuery(sql);
	
	

	while(rs.next()){
		
		int category_id= rs.getInt("category_id");
		String price=rs.getString("price");
		String title=rs.getString("title");
		String author=rs.getString("author");
		String press=rs.getString("press");
		String introduce=rs.getString("introduce");
		String location_id=rs.getString("location_id");
		String callnumber=rs.getString("callnumber");
		
		book.setISBN(ISBN);
		book.setCategory_id(String.valueOf(category_id));
		book.setPrice(price);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPress(press);
		book.setIntroduce(introduce);
		book.setLocation_id(location_id);
		book.setCallnumber(callnumber);
	}
	
	DBHelper.closeConnection(c, s, null);


} catch (Exception e) {
	e.printStackTrace();
}
return book;
}		

/*鏇存柊涔︾殑淇℃伅*/
public static int updateTwo(String ISBN,int category_id,String price,String title,String author,String press,String introduce,int location_id,String callnumber) {




String sql = "update book set category_id="+category_id+",price='"+price+"',title='" + title + "',author='" + author + "',press='"
		+ press +"',introduce ='"
				+ introduce+"',location_id="+ location_id+",callnumber='"+callnumber+

				"' where ISBN='" +ISBN+"'";


int flag=0;
System.out.println(sql);


try {

Connection c = DBHelper.getInstance().getConnection();


Statement s = c.createStatement();
s.executeUpdate(sql);
DBHelper.closeConnection(c, s, null);
flag=1;

} catch (Exception e) {
e.printStackTrace();
}
return flag;
}	

/*鎵惧埌鏌愪釜鐗瑰畾ISBN鐨勪功*/
public static  List<Book> getBooks1(String title) {
	// TODO Auto-generated method stub
	List<Book> books = new ArrayList<Book>();
	String sql = "select * from book a INNER JOIN category b INNER JOIN location c on a.category_id=b.category_id and a.location_id=c.location_id where title like'%" + title + "%'";
	System.out.print(sql);
	
	try {
		Connection c = DBHelper.getInstance().getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while(rs.next()){
			Book book=new Book();
		
			int category_id=rs.getInt("category_id");
			String author=rs.getString("author");
			String price=rs.getString("price");
			String title1=rs.getString("title");
			String ISBN=rs.getString("ISBN");
			String press=rs.getString("press");
			String introduce=rs.getString("introduce");
			int location_id=rs.getInt("location_id");
			String callnumber=rs.getString("callnumber");
		
			book.setISBN(ISBN);
			book.setCategory_id(String.valueOf(category_id));
			book.setCategory_name(rs.getString("category_name"));
			book.setPrice(price);
			book.setTitle(title1);
			book.setAuthor(author);
			book.setPress(press);
			book.setIntroduce(introduce);
			book.setLocation_id(String.valueOf(location_id));
			book.setLocation_name(rs.getString("location_name"));
			book.setCallnumber(callnumber);
			
		books.add(book);
		}
		
		DBHelper.closeConnection(c, s, null);
		
	} catch (Exception e) {
		System.out.println("鏂规硶鍑洪敊锟�?");
		e.printStackTrace();
	}
	return books;
}	

/*鎼滅储涔︾睄璋冪敤*/
public static List<Book> getBooks(String author){
	
	List<Book> books = new ArrayList<Book>();
	
	String sql="select * from book a INNER JOIN category b INNER JOIN location c on a.category_id=b.category_id and a.location_id=c.location_id where author like'%" + author + "%' ";
	System.out.print(sql);
	
	try {
		Connection c = DBHelper.getInstance().getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while(rs.next()){
			Book book=new Book();
		
			int category_id=rs.getInt("category_id");
			String author1=rs.getString("author");
			String price=rs.getString("price");
			String title=rs.getString("title");
			String ISBN=rs.getString("ISBN");
			String press=rs.getString("press");
			String introduce=rs.getString("introduce");
			String location_id=rs.getString("location_id");
		
			String callnumber=rs.getString("callnumber");
		
			book.setISBN(ISBN);
			book.setCategory_id(String.valueOf(category_id));
			book.setCategory_name(rs.getString("category_name"));
			book.setPrice(price);
			book.setTitle(title);
			book.setAuthor(author1);
			book.setPress(press);
			book.setIntroduce(introduce);
			book.setLocation_name(rs.getString("location_name"));
			book.setLocation_id(String.valueOf(location_id));
		
			book.setCallnumber(callnumber);
			
		books.add(book);
		}
		
		DBHelper.closeConnection(c, s, null);
		
	} catch (Exception e) {
		System.out.println("鏂规硶鍑洪敊锟�?");
		e.printStackTrace();
	}
	return books;
}	
/*鍦╞ook椤甸潰閫氳繃杈撳叆ISBN,sbook_id娣诲姞sbook*/
public static int addSbook(int number,String ISBN,String bookstatus) {
	
	int flag=1;
	for(int i=0;i<number;i++)
	{
		       
	String sql = "insert into sbook set ISBN='" + ISBN + "',bookstatus='"+bookstatus+ "'";
	try {		
		Connection c = DBHelper.getInstance().getConnection();
		Statement s = c.createStatement();
		s.executeUpdate(sql);
		
		DBHelper.closeConnection(c, s, null);
	flag=0;	

	} catch (Exception e) {
		System.out.println("add()鏂规硶鍑洪敊锟�?");
        e.printStackTrace();
    }
	}
	return flag;
}

/*鍒犻櫎鐗瑰畾鐨剆book_id鐨剆book*/
public static int deleteSBook(String user_id,String sbook_id) throws SQLException{
	
	java.util.Date currDate = Calendar.getInstance().getTime();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String delete_time = sdf.format(currDate);
	Connection c = DBHelper.getInstance().getConnection();
int flag=1;

String sql1="select sbook_id from borrow where sbook_id='"+sbook_id+"'";

System.out.println(sql1);
PreparedStatement psa =c.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
ResultSet sa = psa.executeQuery();
if (sa.next()) {

flag=0;}

else {


	String sql = "delete from sbook where sbook_id= '" + sbook_id + "' ";
	String sql2 = "insert into delete_record set user_id='"+ user_id + "',sbook_id='"+ sbook_id + "',delete_time='"+ delete_time + "'";
	
	
	System.out.println(sql);
	System.out.println(sql2);
	try {
		
		Statement s = c.createStatement();
		s.executeUpdate(sql);
		s.executeUpdate(sql2);
		DBHelper.closeConnection(c, s, null);
		  flag=1;
	}  catch (Exception e) {
		System.out.println("deleteSBook()鏂规硶鍑洪敊锟 ?");
        e.printStackTrace();
      
    }
}
return flag;
}	

public static List<Delete> ShowDeletes(){
	List<Delete> deletes = new ArrayList<Delete>();
	String sql="select delete_id,user_id,sbook_id,delete_time from delete_record order by delete_time desc";
	System.out.print(sql);
	try {
		Connection c = DBHelper.getInstance().getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while(rs.next()){
			Delete delete = new Delete();
			int delete_id = rs.getInt("delete_id");
			String user_id = rs.getString("user_id");
			String sbook_id = rs.getString("sbook_id");
			String delete_time = rs.getString("delete_time");					
			delete.setDelete_id(delete_id);
			delete.setUser_id(user_id);
			delete.setSbook_id(sbook_id);
			delete.setDelete_time(delete_time);
			deletes.add(delete);
					
		}
		
		DBHelper.closeConnection(c, s, null);
		
	} catch (Exception e) {
		System.out.println("updateOne()方法出错！");
		e.printStackTrace();
	}
	return deletes;
	}


	public static List<Book> showBook(){
		// TODO Auto-generated method stub
		List<Book> books = new ArrayList<Book>();
		String sql = "select * from book a INNER JOIN category b INNER JOIN location c on a.category_id=b.category_id and a.location_id=c.location_id";
		System.out.print(sql);
		
	
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Book book=new Book();
				book.setISBN(rs.getString("ISBN"));
				book.setCategory_name(rs.getString("category_name"));
				book.setCategory_id(String.valueOf(rs.getInt("category_id")));
				book.setPrice(rs.getString("price"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setIntroduce(rs.getString("introduce"));
				book.setLocation_id(rs.getString("location_id"));
				book.setLocation_name(rs.getString("location_name"));
				book.setCallnumber(rs.getString("callnumber"));
				books.add(book);
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("showBook()锟斤拷锟斤拷锟斤拷锟斤拷");
			e.printStackTrace();
		}
		return books;
	}
	

	public static int judge(String ISBN){
		
		int flag=0;
		
		try {
		
		Connection c = DBHelper.getInstance().getConnection();
		String sqla="select ISBN from book where ISBN='"+ ISBN+ "'"; 
		
		System.out.println(sqla);
		PreparedStatement psa =c.prepareStatement(sqla, Statement.RETURN_GENERATED_KEYS);
		ResultSet sa = psa.executeQuery();
		if (sa.next()) {
		
		flag=0;}
		else {
		
			flag=1;
			
		}  
		}catch (Exception e) {
			System.out.println("judge()方法出错�?");
	        e.printStackTrace();
	    }
		return flag;
	}		
	
	
	public static Book getBook2(String ISBN) {
		// TODO Auto-generated method stub
		Book book = new Book();
		String sql = "select * from book a INNER JOIN category b INNER JOIN location c on a.category_id=b.category_id and a.location_id=c.location_id where ISBN='" + ISBN + "'";
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				book.setISBN(ISBN);
				book.setCategory_id(String.valueOf(rs.getInt("category_id")));
				book.setPrice(rs.getString("price"));
				book.setCategory_name((rs.getString("category_name")));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setIntroduce(rs.getString("introduce"));
				book.setLocation_id(rs.getString("location_name"));
				book.setCallnumber(rs.getString("callnumber"));
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("getBook()锟斤拷锟斤拷锟斤拷锟斤拷");
			e.printStackTrace();
		}
		return book;
	}

	public static List<Integer> getMaxSbook(int number) {
		// TODO Auto-generated method stub
		
		List<Integer> sbooks = new ArrayList<Integer>();
		String sql = "select sbook_id from sbook order by sbook_id desc limit " + number;
		System.out.print(sql);
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Integer sbook = new Integer(rs.getInt("sbook_id"));
				sbooks.add(sbook);
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("getMaxSbook()锟斤拷锟斤拷锟斤拷锟斤拷");
			e.printStackTrace();
		}
		return sbooks;
	}	

}
