package system.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmBookingController
 */
@WebServlet("/source/user_pages/dashboard_page/ConfirmBookingController")
public class ConfirmBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pickupLoc = request.getParameter("pickup_location");
		String dropLoc = request.getParameter("drop_location");
		String pickupDate = request.getParameter("pickup_date");
		String dropDate = request.getParameter("drop_date");
		int passengers = Integer.parseInt(request.getParameter("passengers_num"));
		double rentalChrge = Double.parseDouble(request.getParameter("rental_charge").substring(3));
		String specialReq = request.getParameter("special_request");
		
		System.out.println(pickupLoc + "\n" + dropLoc + "\n" + pickupDate + "\n" + dropDate + "\n" + passengers + "\n" + rentalChrge + "\n" + specialReq);
	}
}
1