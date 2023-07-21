package system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import system.model.Vehicle;

public class VehicleDAO {
	public int registerCar (Vehicle vehicle, int userid) throws ClassNotFoundException {
		String sql = 
				"insert into Vehicle (availability, registration_num, chasis_num, engine_num, v_brand, v_model, v_type, v_color, yr_manufacture, roadtax_exp_date, insurance_name, insurance_exp_date, insurance_type, description, rental_pr_hr, img_path, userid, gasType, seat, transmission, location)\r\n"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		int rowCount = 0;
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://bxx0oim5clt3tz9xxlzj-mysql.services.clever-cloud.com:3306/bxx0oim5clt3tz9xxlzj?serverTimezone=Asia/Kuala_Lumpur", "uwaq62nkjirwnjub", "mRrDGZdA1u7UPAXYI5Rm");
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setBoolean(1, vehicle.getAvailability());
			pst.setString(2, vehicle.getRegistration_num());
			pst.setString(3, vehicle.getChasis_num());
			pst.setString(4, vehicle.getEngine_num());
			pst.setString(5, vehicle.getV_brand());
			pst.setString(6, vehicle.getV_model());
			pst.setString(7, vehicle.getV_type());
			pst.setString(8, vehicle.getV_color());
			pst.setInt(9, vehicle.getYr_manufacture());
			pst.setString(10, vehicle.getStringRoadtax_exp_date());
			pst.setString(11, vehicle.getInsurance_name());
			pst.setString(12, vehicle.getStringInsurance_exp_date());
			pst.setString(13, vehicle.getInsurance_type());
			pst.setString(14, vehicle.getDescription());
			pst.setDouble(15, vehicle.getRental_pr_hr());
			pst.setString(16, Integer.toString(vehicle.getImg_path()));
			pst.setInt(17, userid);
			pst.setString(18, vehicle.getGasType());
			pst.setInt(19, vehicle.getSeatNum());
			pst.setString(20, vehicle.getTransmission());
			pst.setString(21, vehicle.getLocation());
			
			rowCount = pst.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
		
	}
	
	public int getNewVehicleID() {
		Connection con = null;
		
		String sql = "select vehicleid from Vehicle order by vehicleid desc limit 1;";
		int newID = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://bxx0oim5clt3tz9xxlzj-mysql.services.clever-cloud.com:3306/bxx0oim5clt3tz9xxlzj?serverTimezone=Asia/Kuala_Lumpur", "uwaq62nkjirwnjub", "mRrDGZdA1u7UPAXYI5Rm");
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				newID = rs.getInt("vehicleid");
			}
			pst.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return newID + 1;
	}
}
