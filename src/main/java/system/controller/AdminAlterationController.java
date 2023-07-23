package system.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.dao.VehicleDAO;
import system.model.Vehicle;
import java.util.List;

/**
 * Servlet implementation class AdminAlterationController
 */
@WebServlet("/source/admin_pages/front_page/AdminAlterationController")
public class AdminAlterationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int vehicleid = Integer.parseInt(request.getParameter("vehicleId"));
		VehicleDAO vehicledao = new VehicleDAO();
		Vehicle vehicle = vehicledao.getVehicleAttribute(vehicleid);
		HttpSession session = request.getSession();
		session.setAttribute("vehicleAtt", vehicle);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/source/user_pages/p2p_page/p2p-register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminAlterationController--doPost");
		HttpSession session = request.getSession();
		
		Vehicle vehicle = (Vehicle) request.getSession().getAttribute("vehicleAtt");
		/*
		vehicle.setV_brand(request.getParameter("brand"));
		vehicle.setV_model(request.getParameter("model"));
		vehicle.setV_type(request.getParameter("type"));
		vehicle.setYr_manufacture(Integer.parseInt(request.getParameter("yearManufactured")));
		vehicle.setGasType(request.getParameter("gasType"));
		vehicle.setSeatNum(Integer.parseInt(request.getParameter("numberOfSeater")));
		vehicle.setTransmission(request.getParameter("transmission"));
		vehicle.setRegistration_num(request.getParameter("registrationNumber"));
		vehicle.setRoadtax_exp_date(request.getParameter("roadtaxExpiryDate"));
		vehicle.setEngine_num(request.getParameter("engineNumber"));
		vehicle.setChasis_num(request.getParameter("chasisNumber"));
		vehicle.setInsurance_type(request.getParameter("insuranceType"));
		vehicle.setInsurance_name(request.getParameter("insuranceName"));
		vehicle.setInsurance_exp_date(request.getParameter("insuranceExpiryDate"));
		vehicle.setLocation(request.getParameter("location"));
		vehicle.setRental_pr_hr(Double.parseDouble(request.getParameter("rentalCharge")));
		*/
		Connection con = null;
		String sql = 
				"update Vehicle \r\n"
				+ "set registration_num = \"ABC123\",\r\n"
				/*+ "chasis_num = ?,\r\n"
				+ "engine_num = ?,\r\n"
				*/+ "v_brand = \"Toyota\",\r\n"
				+ "v_model = \"Camry\",\r\n"
				+ "v_type = \"Sedan\"\r\n"
				/*+ "yr_manufacture = 2020,\r\n"
				+ "roadtax_exp_date = ?,\r\n"
				+ "insurance_name = ?,\r\n"
				+ "insurance_exp_date = ?,\r\n"
				+ "insurance_type = ?,\r\n"
				+ "rental_pr_hr = 1.0,\r\n"
				+ "gasType = ?,\r\n"
				+ "seat = 4,\r\n"
				+ "transmission = ?,\r\n"
				+ "location = ?\r\n"
				*/+ "where vehicleid = 12;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			int rowCount = 0;
			try {
				con = DriverManager.getConnection("jdbc:mysql://bxx0oim5clt3tz9xxlzj-mysql.services.clever-cloud.com:3306/bxx0oim5clt3tz9xxlzj?serverTimezone=Asia/Kuala_Lumpur", "uwaq62nkjirwnjub", "mRrDGZdA1u7UPAXYI5Rm");
				PreparedStatement pst = con.prepareStatement(sql);
				/*
				pst.setString(1, vehicle.getRegistration_num());
				pst.setString(2, vehicle.getChasis_num());
				pst.setString(3, vehicle.getEngine_num());
				pst.setString(4, vehicle.getV_brand());
				pst.setString(5, vehicle.getV_model());
				pst.setString(6, vehicle.getV_type());
				pst.setInt(7, vehicle.getYr_manufacture());
				pst.setString(8, vehicle.getStringRoadtax_exp_date());
				pst.setString(9, vehicle.getInsurance_name());
				pst.setString(10, vehicle.getStringInsurance_exp_date());
				pst.setString(11, vehicle.getInsurance_type());
				pst.setDouble(12, vehicle.getRental_pr_hr());
				pst.setString(13, vehicle.getGasType());
				pst.setInt(14, vehicle.getSeatNum());
				pst.setString(15, vehicle.getTransmission());
				pst.setString(16, vehicle.getLocation());
				pst.setInt(17, vehicle.getVehicleid());
				rowCount = pst.executeUpdate();
				*/
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Vehicle> vehicleList = (List<Vehicle>) session.getAttribute("ListOfVehicle");
		for(Vehicle vehicleobj: vehicleList) {
			if (vehicleobj.getVehicleid() == 12) {
				//vehicleobj=vehicle;
				vehicleobj.setRegistration_num("ABC123");
				vehicleobj.setV_brand("Toyoyta");
				vehicleobj.setV_model("Camry");
				vehicleobj.setV_type("Sedan");
			}
		}
		session.setAttribute("AdminAlterationStatus", "success");
		session.setAttribute("ListOfVehicle", vehicleList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/source/admin_pages/car_inventory/Car-inv.jsp");
		dispatcher.forward(request, response);
	}

}
;