package system.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import system.controller.ConfirmBookingController;

@WebServlet("/source/user_pages/front_page/AlterationController")
public class AlterationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pickupLoc = request.getParameter("pickup_location");
		String dropLoc = request.getParameter("drop_location");
		String pickupDate = request.getParameter("pickup_date");
		String dropDate = request.getParameter("drop_date");
		int passengers = Integer.parseInt(request.getParameter("passengers_num"));
		double rentalChrge = Double.parseDouble(request.getParameter("rental_charge").substring(3));
		String specialReq = request.getParameter("special_request");
		
		System.out.println(pickupDate);
		System.out.println(dropDate);
		
		ConfirmBookingController externalControl = new ConfirmBookingController();
		pickupDate = externalControl.dateFormatting(pickupDate);
		dropDate = externalControl.dateFormatting(dropDate);
		
		System.out.println(pickupDate);
		System.out.println(dropDate);
	}

}
