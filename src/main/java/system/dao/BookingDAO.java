package system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

import system.model.Vehicle;

public class BookingDAO {
	public Vehicle getRegistrationForm(int id) {
		Vehicle vehicle = new Vehicle();
		String vehicleInfoQuery = "select * from Vehicle where vehicleid="+id;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://bxx0oim5clt3tz9xxlzj-mysql.services.clever-cloud.com:3306/bxx0oim5clt3tz9xxlzj?serverTimezone=Asia/Kuala_Lumpur", "uwaq62nkjirwnjub", "mRrDGZdA1u7UPAXYI5Rm");
			PreparedStatement pst = con.prepareStatement(vehicleInfoQuery);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				vehicle.setVehicleid(rs.getInt("vehicleid"));
				vehicle.setAvailability(rs.getBoolean("availability"));
				vehicle.setRegistration_num(rs.getString("registration_num"));
				vehicle.setChasis_num(rs.getString("chasis_num"));
				vehicle.setEngine_num(rs.getString("engine_num"));
				vehicle.setV_brand(rs.getString("v_brand"));
				vehicle.setV_model(rs.getString("v_model"));
				vehicle.setV_type(rs.getString("v_type"));
				vehicle.setV_color(rs.getString("v_color"));
				vehicle.setYr_manufacture(rs.getInt("yr_manufacture"));
				vehicle.setRoadtax_exp_date(rs.getString("roadtax_exp_date"));
				vehicle.setInsurance_name(rs.getString("insurance_name"));
				vehicle.setInsurance_exp_date(rs.getString("insurance_exp_date"));
				vehicle.setInsurance_type(rs.getString("insurance_type"));
				vehicle.setDescription(rs.getString("description"));
				vehicle.setRental_pr_hr(rs.getDouble("rental_pr_hr"));
				vehicle.setImg_path(rs.getString("img_path"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vehicle;
	}
}
