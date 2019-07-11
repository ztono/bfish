package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import BEAN.*;

public class JudgeDao {

	public static int judge_day(String employee_no,String perfermence) {
		
		int flag = 0;
		String sql = "select * from judge_day where employee_id='" + employee_no+"'";
		System.out.println(sql);
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {

				String time = rs.getString("time");
				String judge_no = rs.getString("judge_no");
				String[] stime = time.split("-");
				String[] stime1 = stime[2].split(" ");
				String stime2 = stime[0] + "-" + stime[1] + "-" + stime1[0];

				if (stime2.equals(sdf2.format(date))) {

                    String sql2 = "update judge_day set perfermance=? where judge_no=?";
                    Connection c2 = DBHelper.getInstance().getConnection();
                    PreparedStatement ps2 = c2.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);

                    ps2.setString(1, perfermence);
                    ps2.setString(2, judge_no);

                    ps2.execute();
                    ResultSet rs2 = ps2.getGeneratedKeys();
                    DBHelper.closeConnection(c2, ps2, rs2);
                    flag = -1;
					DBHelper.closeConnection(c, s, rs);
					return flag;
				}
			}


				flag = 1;

				DBHelper.closeConnection(c, s, rs);
			
		}
		 catch (Exception e) {
				System.out.println("judge_day()失败");
				e.printStackTrace();
			}
			
		return flag;
		
	}
	
	public static List<JudgeDay> getemployees(){
		List<JudgeDay> wrs = new ArrayList<JudgeDay>();
		String sql = "select * from workrecord";
		System.out.println(sql);
		
		Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
					
				String staff_no = rs.getString("staff_no");
				String start_time = rs.getString("start_time");
				String[] stime = start_time.split("-");
				String[] stime1 = stime[2].split(" ");
				String time = stime[0] + "-" + stime[1] + "-" + stime1[0];
				
				if (time.equals(sdf2.format(date))) {

				    int flag = 0;
                    String sql3 = "select * from judge_day where employee_id='" + staff_no+"'";
                    Connection c3 = DBHelper.getInstance().getConnection();
                    Statement s3 = c3.createStatement();
                    ResultSet rs3 = s3.executeQuery(sql3);
                    while (rs3.next()){
                        String time5 = rs3.getString("time");
                        String[] stime5 = time5.split("-");
                        String[] stime6 = stime5[2].split(" ");
                        String stime7 = stime5[0] + "-" + stime5[1] + "-" + stime6[0];
                        if (stime7.equals(sdf2.format(date))){
                            flag = 1;
                        }
                    }
                    if (flag==0) {
                        Connection c2 = DBHelper.getInstance().getConnection();

                        String sql2 = "insert into judge_day(employee_id,perfermance,time) values(?,?,?)";
                        PreparedStatement ps = c2.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);

                        ps.setString(1, staff_no);
                        ps.setDouble(2,0);
                        ps.setString(3, sdf1.format(date));

                        ps.execute();

                        ResultSet rs2 = ps.getGeneratedKeys();
                        DBHelper.closeConnection(c2, ps, rs2);
                    }

					String sql1 = "select * from judge_day,employee where employee_id=" + staff_no +" and judge_day.employee_id=employee.employee_no";
					Connection c1 = DBHelper.getInstance().getConnection();
					Statement s1 = c1.createStatement();
					ResultSet rs1 = s1.executeQuery(sql1);

					String per ="NULL";
					String sname ="NULL";
					while (rs1.next()){
						String time1 = rs1.getString("time");
						String[] stime3 = time1.split("-");
						String[] stime4 = stime3[2].split(" ");
						String stime5 = stime3[0] + "-" + stime3[1] + "-" + stime4[0];
						if (stime5.equals(sdf2.format(date))){
						    sname = rs1.getString("username");
							per = rs1.getString("perfermance");
						}
					}
					DBHelper.closeConnection(c1, s1, rs1);
					JudgeDay jd = new JudgeDay();

					jd.setEmployee_no(staff_no);
					jd.setPerformance(per);
					jd.setEmployee_name(sname);
					wrs.add(jd);
				}
			}
			
			DBHelper.closeConnection(c, s, rs);
			
			}
		catch (Exception e) {
			System.out.println("getemployees()失败");
			e.printStackTrace();
		}
		
		
		return wrs;
	}

	public static List<JudgeDay> getall(String year,String month,String day){
	    List<JudgeDay> jds = new ArrayList<JudgeDay>();
        String sql = "select * from judge_day,employee where judge_day.employee_id=employee.employee_no";
        System.out.println(sql);
        try {
            Connection c = DBHelper.getInstance().getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {

                JudgeDay jd = new JudgeDay();
                String employee_no = rs.getString("employee_no");
                String employee_name = rs.getString("username");
                String perfermance = rs.getString("perfermance");
                String time = rs.getString("time");
                String[] stime = time.split("-");
                String[] stime1 = stime[2].split(" ");

                if (day.equals("0")) {
                    if (stime[0].equals(year) && Integer.valueOf(stime[1]) == Integer.valueOf(month)) {
                        jd.setEmployee_no(employee_no);
                        jd.setPerformance(perfermance);
                        jd.setEmployee_name(employee_name);
                        jd.setTime(time);

                        jds.add(jd);
                    }
                } else {
                    if (stime[0].equals(year) && Integer.valueOf(stime[1]) == Integer.valueOf(month)
                            && Integer.valueOf(stime1[0]) == Integer.valueOf(day)) {
                        jd.setEmployee_no(employee_no);
                        jd.setPerformance(perfermance);
                        jd.setEmployee_name(employee_name);
                        jd.setTime(time);

                        jds.add(jd);

                    }
                }
            }

            DBHelper.closeConnection(c, s, rs);
        } catch (Exception e) {
            System.out.println("getall()失败");
            e.printStackTrace();
        }
	    return jds;
    }

}
