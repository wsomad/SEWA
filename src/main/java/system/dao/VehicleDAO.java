package system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import system.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * @return
	 */
	public List<Vehicle> getVehiclesList(){
		List<Vehicle> vehicleList = new ArrayList <>();
		Connection con = null;
		String sql = 
				"select * from Vehicle";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://bxx0oim5clt3tz9xxlzj-mysql.services.clever-cloud.com:3306/bxx0oim5clt3tz9xxlzj?serverTimezone=Asia/Kuala_Lumpur", "uwaq62nkjirwnjub", "mRrDGZdA1u7UPAXYI5Rm");
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Vehicle vehicle = new Vehicle();
				vehicle.setVehicleid(rs.getInt("vehicleid"));
				vehicle.setRegistration_num(rs.getString("registration_num"));
				vehicle.setV_brand(rs.getString("v_brand"));
				vehicle.setV_model(rs.getString("v_model"));
				vehicle.setV_type(rs.getString("v_type"));
				vehicle.setYr_manufacture(rs.getInt("yr_manufacture"));
				
				vehicleList.add(vehicle);
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
		
		for(Vehicle vehicle : vehicleList) {
			System.out.println(vehicle.getVehicleid());
		}
		return vehicleList;
	}
	
	public Vehicle getVehicleAttribute(int id) {
		Connection con = null;
		Vehicle vehicle = null;
		String sql = "select * from Vehicle where vehicleid="+id;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://bxx0oim5clt3tz9xxlzj-mysql.services.clever-cloud.com:3306/bxx0oim5clt3tz9xxlzj?serverTimezone=Asia/Kuala_Lumpur", "uwaq62nkjirwnjub", "mRrDGZdA1u7UPAXYI5Rm");
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				vehicle = new Vehicle();
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
				vehicle.setInsurance_exp_date(rs.getString("roadtax_exp_date"));
				vehicle.setInsurance_type(rs.getString("insurance_type"));
				vehicle.setDescription(rs.getString("description"));
				vehicle.setRental_pr_hr(rs.getDouble("rental_pr_hr"));
				vehicle.setImg_path(rs.getInt("img_path"));
				vehicle.setGasType(rs.getString("gasType"));
				vehicle.setSeatNum(rs.getInt("seat"));
				vehicle.setTransmission(rs.getString("transmission"));
				vehicle.setLocation(rs.getString("location"));
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
		return vehicle;
	}
}
