package system.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class p2pRegistrationController
 */
@WebServlet("/source/user_pages/dashboard_page/p2p-registerController")
public class p2pRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/source/user_pages/p2p_page/p2p-register.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String type = request.getParameter("type");
        String yearManufactured = request.getParameter("yearManufactured");
        String gasType = request.getParameter("gasType");
        String numberOfSeater = request.getParameter("numberOfSeater");
        String transmission = request.getParameter("transmission");
        String registrationNumber = request.getParameter("registrationNumber");
        String roadtaxExpiryDate = request.getParameter("roadtaxExpiryDate");
        String engineNumber = request.getParameter("engineNumber");
        String chasisNumber = request.getParameter("chasisNumber");
        String insuranceType = request.getParameter("insuranceType");
        String insuranceName = request.getParameter("insuranceName");
        String insuranceExpiryDate = request.getParameter("insuranceExpiryDate");
        String location = request.getParameter("location");
        String rentalCharge = request.getParameter("rentalCharge");
        
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Type: " + type);
        System.out.println("Year Manufactured: " + yearManufactured);
        System.out.println("Gas Type: " + gasType);
        System.out.println("Number of Seater: " + numberOfSeater);
        System.out.println("Transmission: " + transmission);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Roadtax Expiry Date: " + roadtaxExpiryDate);
        System.out.println("Engine Number: " + engineNumber);
        System.out.println("Chasis Number: " + chasisNumber);
        System.out.println("Insurance Type: " + insuranceType);
        System.out.println("Insurance Name: " + insuranceName);
        System.out.println("Insurance Expiry Date: " + insuranceExpiryDate);
        System.out.println("Location: " + location);
        System.out.println("Rental Charge: " + rentalCharge);
	}

}
