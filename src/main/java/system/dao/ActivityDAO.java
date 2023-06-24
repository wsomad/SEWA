package system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import system.model.*;
import java.sql.Timestamp;
import java.util.Stack;

public class ActivityDAO {
	public Stack<Activity> getActivities (int userid){
		Stack <Activity> activities = new Stack <>();
		Stack <Activity> tempStack = new Stack <>();
		Connection con = null;
		
		String sql = 
				"select R.*\r\n"
				+ "from Tenant_Vehicle as R\r\n"
				+ "join User as U on U.userid = R.userid\r\n"
				+ "join Vehicle as V on V.vehicleid = R.vehicleid\r\n"
				+ "where U.userid = ?\r\n"
				+ "union\r\n"
				+ "select R2.*\r\n"
				+ "from Tenant_Vehicle as R2\r\n"
				+ "join Vehicle as V2 on V2.vehicleid = R2.vehicleid\r\n"
				+ "where V2.userid = ?;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://bxx0oim5clt3tz9xxlzj-mysql.services.clever-cloud.com:3306/bxx0oim5clt3tz9xxlzj?serverTimezone=Asia/Kuala_Lumpur", "uwaq62nkjirwnjub", "mRrDGZdA1u7UPAXYI5Rm");
			PreparedStatement pst = con.prepareStatement(sql);
			Activity activity = new Activity ();
			Reservation reservation = new Reservation();
			User user = new User();
			Vehicle vehicle = new Vehicle();
			Timestamp tempTimestamp = null;
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int user_id = rs.getInt("userid");
				int vehicle_id = rs.getInt("vehicleid");
				
				String pickup_date = rs.getString("pickup_date");
				String drop_date = rs.getString("drop_date");
				String pickup_location = rs.getString("pickup_location");
				String drop_location = rs.getString("drop_location");
				int passenger_num = rs.getInt("passengers_num");
				String special_req = rs.getString("special_req");
				double rent_to_pay = rs.getDouble("rent_to_pay");
				Timestamp insertion_timestamp = rs.getTimestamp("insertion_timestamp");
				reservation = new Reservation (user_id, vehicle_id, pickup_location, drop_location, pickup_date, drop_date, passenger_num, special_req, rent_to_pay, insertion_timestamp);
				
				user.setUser_first_name(rs.getString("user_first_name"));
				user.setUser_last_name(rs.getString("user_last_name"));
				user.setUser_uname(rs.getString("user_uname"));
				user.setUser_phone(rs.getString("user_phone"));
				
				vehicle.setAvailability(rs.getBoolean("availability"));
				vehicle.setRegistration_num(rs.getNString("registration_num"));
				vehicle.setV_brand(rs.getString("v_brand"));
				vehicle.setV_model(rs.getString("v_model"));
				vehicle.setRental_pr_hr(rs.getDouble("rental_pr_hr"));
				
				String status = (userid==user_id) ? "Tenant" : "Lessor";
				
				activity = new Activity(user, vehicle, reservation, status);
				
				activities.push(activity);
			}
			
		}catch(Exception e) {
			
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return activities;
	}
}
