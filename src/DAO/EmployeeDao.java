/**
 * 
 */
package DAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import  java.sql.*;

import BEAN.*;


/**
 * @author dell
 *
 */
public class EmployeeDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public static List<Employee> ShowEmployee(){
		
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "select * from employee";
		System.out.print(sql);
		
		try {
			Connection c = (Connection) DBHelper.getInstance().getConnection();
			Statement s = (Statement) c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {

				Employee employee= new Employee();
				
				employee.setEmployee_no(String.valueOf(rs.getInt("employee_no")));
				employee.setPassword(rs.getString("password"));
				employee.setEmail(rs.getString("email"));
				employee.setPosition(rs.getString("position"));
				employee.setTelephone(rs.getString("telephone"));
				employee.setUsername(rs.getString("username"));
				employees.add(employee);
				
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("showEmployee()锟斤拷锟斤拷锟斤拷锟斤拷");
			e.printStackTrace();
		}
		return employees;
	}


public static int addEmployee(String username,String password,String email,String telephone,String position) {
	

	int flag=2;
	
	try {
	
	Connection c = (Connection) DBHelper.getInstance().getConnection();

		
	String sql = "insert into employee set username='" + username + "',password='"+password+"',email='"+email+"',telephone='"+telephone+"',position='"+position+"'";
	System.out.println(sql);
	Statement s = (Statement) c.createStatement();
	s.executeUpdate(sql);
	
	DBHelper.closeConnection(c, s, null);
     flag=3;}
	 catch (Exception e) {
		System.out.println("addEmployee()方法出错�?");
        e.printStackTrace();
    }
	return flag;
}


public static boolean deleteEmployee(int employee_no){
	String sql = "delete from employee where employee_no= "+ employee_no;
	System.out.println(sql);
	int d=0;
	try {
		Connection c = (Connection) DBHelper.getInstance().getConnection();
		Statement s = (Statement) c.createStatement();
		d = s.executeUpdate(sql);
		DBHelper.closeConnection(c, s, null);
		d=1;
	}  catch (Exception e) {
		System.out.println("deleteEmployee()方法出错?");
        e.printStackTrace();
    }
	if(d==0) {return false;}
	else { return true;}
}	

public static boolean updateEmployee(int employee_no,String username,String password,String email,String telephone,String position){

	String sql = "update employee set username='" + username +"',password='"+password+"',email='" + email + "',telephone='" + telephone + "',position='"
			+ position +"' where employee_no='" +employee_no+"'";
System.out.println(sql);
    int p=0;

try {

	Connection c = (Connection) DBHelper.getInstance().getConnection();
	
	
	Statement s = (Statement) c.createStatement();
	s.executeUpdate(sql);
	DBHelper.closeConnection(c, s, null);
    p=1;

} catch (Exception e) {
	e.printStackTrace();
}
    if(p==0) {return false;}
    else { return true;}
}	






public static boolean resetPassword(int employee_no) {

	String sql = "update employee set password='123456" +"' where employee_no='" +employee_no+"'";
System.out.println(sql);

    int d=0;
try {

	Connection c = (Connection) DBHelper.getInstance().getConnection();
	
	
	Statement s = (Statement) c.createStatement();
	s.executeUpdate(sql);
	DBHelper.closeConnection(c, s, null);
    d=1;

} catch (Exception e) {
	e.printStackTrace();
}
    if(d==0) {return false;}
    else { return true;}
}	


public static List<Employee> DisplayEmployee(){
	
	List<Employee> employees = new ArrayList<Employee>();
	String sql = "select username,position,email,telephone,employee_no from employee where position='cleaner' or position ='repersonnel';";
	System.out.print(sql);
	
	try {
		Connection c = (Connection) DBHelper.getInstance().getConnection();
		Statement s = (Statement) c.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while (rs.next()) {

			Employee employee= new Employee();
			
			employee.setEmployee_no(String.valueOf(rs.getInt("employee_no")));
			employee.setEmail(rs.getString("email"));
			employee.setPosition(rs.getString("position"));
			employee.setTelephone(rs.getString("telephone"));
			employee.setUsername(rs.getString("username"));
			employees.add(employee);
			
		}
		DBHelper.closeConnection(c, s, rs);
		
	} catch (Exception e) {
		System.out.println("showEmployee()锟斤拷锟斤拷锟斤拷锟斤拷");
		e.printStackTrace();
	}
	return employees;
}









}
