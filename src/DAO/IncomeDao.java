package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import BEAN.*;

public class IncomeDao {

public static List<Income> ShowIncome(){
		
		List<Income> incomes = new ArrayList<>();
		String sql = "select room_type,leavedate,cost from room,checkin where room.room_id=checkin.room_no";
		System.out.print(sql);
		
		try {
			Connection c =  DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
		
			
			while (rs.next()) {

				Income income= new Income();
				
				income.setCost(String.valueOf(rs.getDouble("cost")));
				
				String str=rs.getString("leavedate");
				String[] temp;
				temp = str.split("-",3);
				income.setYear(temp[0]);
				income.setMounth(temp[1]);
				income.setRoom_type(rs.getString("room_type"));
				incomes.add(income);
				
			}
			DBHelper.closeConnection(c, s, rs);
			
		} catch (Exception e) {
			System.out.println("showIncome()锟斤拷锟斤拷锟斤拷锟斤拷");
			e.printStackTrace();
		}
		return incomes;
	}
	

public static double doubleRoomIncome(String year,String month){
	
	List<Income> incomes =IncomeDao.ShowIncome();
	double c=0;
	for(Income income:incomes) {
       if(income.getYear().equals(year)) {
		if(income.getMounth().equals(month)) {
		if(income.getRoom_type().equals("doubleroom")) {
			
			c=c+Double.parseDouble(income.getCost());
			
			
		}	
		}
		
	}
}
	
	return c;
}

public static double singleRoomIncome(String year,String month){
	
	List<Income> incomes =IncomeDao.ShowIncome();
	double s=0;
	for(Income income:incomes) {

		if(income.getYear().equals(year)) {
			if(income.getMounth().equals(month)) {
		if(income.getRoom_type().equals("singleroom")) {
			
			s=s+Double.parseDouble(income.getCost());
			
			
		}	}}
		
	}
	
	return s;
}
public static double bigBedRoomIncome(String year,String month){
	
	List<Income> incomes =IncomeDao.ShowIncome();
	double b=0;
	for(Income income:incomes) {
		if(income.getYear().equals(year)) {
			if(income.getMounth().equals(month)) {
		
		if(income.getRoom_type().equals("bigbedroom")) {
			
			b=b+Double.parseDouble(income.getCost());
			
			
		}	
		
	}
		}
	}
	
	return b;
}






	
}
