package system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import system.model.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;

public class ActivityDAO {
	
	public List<Activity> getActivities (int userid)throws ClassNotFoundException{
		List <Activity> activities = new ArrayList <>();
		Connection con = null;
		
		String sql = 
				"SELECT R.*,U.user_first_name, U.user_last_name, U.user_uname, U.user_phone, V.availability, V.registration_num, V.v_brand, V.v_model, V.rental_pr_hr\r\n"
				+ "FROM Tenant_Vehicle AS R\r\n"
				+ "JOIN User AS U ON U.userid = R.userid\r\n"
				+ "JOIN Vehicle AS V ON V.vehicleid = R.vehicleid\r\n"
				+ "WHERE U.userid = ?\r\n"
				+ "UNION\r\n"
				+ "SELECT R2.*, U2.user_first_name, U2.user_last_name, U2.user_uname, U2.user_phone, V2.availability, V2.registration_num, V2.v_brand, V2.v_model, V2.rental_pr_hr\r\n"
				+ "FROM Tenant_Vehicle AS R2\r\n"
				+ "JOIN Vehicle AS V2 ON V2.vehicleid = R2.vehicleid\r\n"
				+ "JOIN User AS U2 ON U2.userid = V2.userid\r\n"
				+ "WHERE V2.userid = ?;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://bxx0oim5clt3tz9xxlzj-mysql.services.clever-cloud.com:3306/bxx0oim5clt3tz9xxlzj?serverTimezone=Asia/Kuala_Lumpur", "uwaq62nkjirwnjub", "mRrDGZdA1u7UPAXYI5Rm");
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, userid);
			pst.setInt(2, userid);
			
			Activity activity = new Activity ();
			Reservation reservation = new Reservation();
			Vehicle vehicle = new Vehicle();
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int user_id = rs.getInt("userid");
				int vehicle_id = rs.getInt("vehicleid");
				String oppositeUserName = oppositeUser( userid);
				
				String pickup_date = rs.getString("pickup_date");
				String drop_date = rs.getString("drop_date");
				String pickup_location = rs.getString("pickup_location");
				String drop_location = rs.getString("drop_location");
				int passenger_num = rs.getInt("passengers_num");
				String special_req = rs.getString("special_req");
				double rent_to_pay = rs.getDouble("rent_to_pay");
				Timestamp insertion_timestamp = rs.getTimestamp("insertion_timestamp");
				Boolean eye = rs.getBoolean("eye");
				reservation = new Reservation (user_id, vehicle_id, pickup_location, drop_location, pickup_date, drop_date, passenger_num, special_req, rent_to_pay, insertion_timestamp, eye);
				
				User user = new User();
				user.setUser_first_name(rs.getString("user_first_name"));
				user.setUser_last_name(rs.getString("user_last_name"));
				user.setUser_uname(rs.getString("user_uname"));
				user.setUser_phone(rs.getString("user_phone"));
				
				boolean avail =  rs.getBoolean("availability");
				String reg_num = rs.getNString("registration_num");
				String brand = rs.getString("v_brand");
				String model = rs.getString("v_model");
				Double rental = rs.getDouble("rental_pr_hr");
				vehicle = new Vehicle(0, avail, reg_num, "none", "none", brand, model, "none", "none", 0,
						"none", "none", "none", "none", "none", rental, 0, "none", 0, "none", "none");
				
				String status = (userid==user_id) ? "Tenant" : "Lessor";
				
				activity = new Activity(user, vehicle, reservation, status, oppositeUserName);
				
				activities.add(activity);
				//System.out.println(user.getUserid());
				System.out.println("check : " + activity.getVehicle().getV_brand());
				System.out.println("check : " + activity.getReservation().getRent_to_pay());
			}
			
		}catch(Exception e) {
			System.out.println("Unsuccesful");
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return activities;
	}
	
	public String oppositeUser(int id) {
		Connection con = null;
		System.out.println("user id : " + id);
		String sql = "select user_first_name, user_last_name from User where userid=?;";
		String firstname = "";
		String lastname = "";
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://bxx0oim5clt3tz9xxlzj-mysql.services.clever-cloud.com:3306/bxx0oim5clt3tz9xxlzj?serverTimezone=Asia/Kuala_Lumpur", "uwaq62nkjirwnjub", "mRrDGZdA1u7UPAXYI5Rm");
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				firstname = rs.getString("user_first_name");
				lastname = rs.getString("user_last_name");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return firstname + " " + lastname;
	}
}
