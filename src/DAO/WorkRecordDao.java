package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import BEAN.WorkRecord;


public class WorkRecordDao {

	public static List<WorkRecord> getrecords(String staff_no) {

		List<WorkRecord> wrs = new ArrayList<WorkRecord>();
		String sql = "select * from workrecord where staff_no=" + staff_no;
		System.out.println(sql);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				WorkRecord wr = new WorkRecord();
				String record_no = rs.getString("record_no");
				String start_time = rs.getString("start_time");
				String end_time = rs.getString("end_time");
				wr.setRecord_no(record_no);
				wr.setStaff_no(staff_no);
				wr.setStart_time(start_time);
				wr.setEnd_time(end_time);
				wrs.add(wr);
			}
			DBHelper.closeConnection(c, s, rs);
		} catch (Exception e) {
			System.out.println("getrecords()失败");
			e.printStackTrace();
		}

		return wrs;
	}

	public static List<WorkRecord> getrecords2(String year, String month, String day) {

		List<WorkRecord> wrs = new ArrayList<WorkRecord>();
		String sql = "select * from workrecord";
		System.out.println(sql);
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				WorkRecord wr = new WorkRecord();
				String record_no = rs.getString("record_no");
				String staff_no = rs.getString("staff_no");
				String start_time = rs.getString("start_time");
				String end_time = rs.getString("end_time");
				String[] stime = start_time.split("-");
				String[] stime1 = stime[2].split(" ");
				String[] etime = end_time.split("-");
				String[] etime1 = etime[2].split(" ");
				if (day.equals("0")) {
					if (stime[0].equals(year) && Integer.valueOf(stime[1]) == Integer.valueOf(month)
							&& Integer.valueOf(etime[1]) == Integer.valueOf(month)) {

						wr.setRecord_no(record_no);
						wr.setStaff_no(staff_no);
						wr.setStart_time(start_time);
						wr.setEnd_time(end_time);
						System.out.println(end_time);
						wrs.add(wr);

					}
				} else {
					if (stime[0].equals(year) && Integer.valueOf(stime[1]) == Integer.valueOf(month)
							&& Integer.valueOf(etime[1]) == Integer.valueOf(month)
							&& Integer.valueOf(stime1[0]) == Integer.valueOf(day)
							&& Integer.valueOf(etime1[0]) == Integer.valueOf(day)) {

						wr.setRecord_no(record_no);
						wr.setStaff_no(staff_no);
						wr.setStart_time(start_time);
						wr.setEnd_time(end_time);

						wrs.add(wr);
					}
				}
			}

			DBHelper.closeConnection(c, s, rs);
		} catch (Exception e) {
			System.out.println("getrecords()失败");
			e.printStackTrace();
		}
		return wrs;
	}

	public static String getstaffno(String username) {

		String sql = "select employee_no from employee where username='" + username + "'";
		System.out.print(sql);
		String sno = null;
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			sno = rs.getString("employee_no");

			DBHelper.closeConnection(c, s, rs);
		} catch (Exception e) {
			System.out.println("getstaffno()失败");
			e.printStackTrace();
		}
		return sno;
	}

	public static String getemployeename(String staff_no) {
		String sql = "select username from employee where employee_no='" + staff_no + "'";
		System.out.print(sql);
		String sname = null;
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			sname = rs.getString("username");
			DBHelper.closeConnection(c, s, rs);
		} catch (Exception e) {
			System.out.println("getemployeename()失败");
			e.printStackTrace();
		}
		return sname;
	}

	public static int addStartrecord(String staff_no) {

		int flag = 0;
		String sql = "select * from workrecord where staff_no=" + staff_no;
		System.out.println(sql);
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {

				String start_time = rs.getString("start_time");
				String[] stime = start_time.split("-");
				String[] stime1 = stime[2].split(" ");
				String time = stime[0] + "-" + stime[1] + "-" + stime1[0];

				if (time.equals(sdf2.format(date))) {

					flag = -1;
					DBHelper.closeConnection(c, s, rs);
					return flag;
				}
			}

			String sdate = sdf1.format(date);
			String sql1 = "insert into workrecord(staff_no,start_time,end_time) values(?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, staff_no);
			ps.setString(2, sdate);
			ps.setString(3, "null");

			ps.execute();

			ResultSet rs1 = ps.getGeneratedKeys();
			DBHelper.closeConnection(c, ps, rs1);

			flag = 1;

			DBHelper.closeConnection(c, s, rs);
		} catch (Exception e) {
			System.out.println("addStartrecord()失败");
			e.printStackTrace();
		}
		return flag;
	}

	public static int changeEndrecord(String staff_no) {

		int flag = 0;
		String sql = "select * from workrecord where staff_no=" + staff_no;
		System.out.println(sql);

		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				String start_time = rs.getString("start_time");
				String[] stime = start_time.split("-");
				String[] stime1 = stime[2].split(" ");
				String time = stime[0] + "-" + stime[1] + "-" + stime1[0];
				if (time.equals(sdf2.format(date))) {
					if (rs.getString("end_time").equals("null")) {
						String record_no = rs.getString("record_no");

						Connection c1 = DBHelper.getInstance().getConnection();
						String sql1 = "update workrecord set end_time=? where record_no=?";
						PreparedStatement ps = c1.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

						ps.setString(1, sdf1.format(date));
						ps.setString(2, record_no);

						ps.execute();
						ResultSet rs1 = ps.getGeneratedKeys();
						DBHelper.closeConnection(c1, ps, rs1);

						flag = 1;
					} else {
						flag = -1;
					}
				}
			}
			DBHelper.closeConnection(c, s, rs);
		} catch (Exception e) {
			System.out.println("changeEndrecord()失败");
			e.printStackTrace();
		}

		return flag;
	}
}
