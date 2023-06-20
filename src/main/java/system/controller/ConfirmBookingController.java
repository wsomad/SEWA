package system.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import system.model.Reservation;

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
		
		//Date-format
		pickupDate = dateFormatting(pickupDate);
		dropDate = dateFormatting(dropDate);
		
		//Encapsulating reservation data
		Reservation reservation = new Reservation();
		reservation = new Reservation(0,0,pickupDate,dropDate,passengers,specialReq,rentalChrge);
		
		request.setAttribute("reservation", reservation);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/source/user_pages/booking_page/confirm-booking.jsp");
		dispatcher.forward(request, response);
		
		/*HttpSession session = request.getSession();
		session.setAttribute("reservationobj", reservation);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/source/user_pages/booking_page/confirm-booking.jsp");
		dispatcher.forward(request, response);*/
		
		System.out.println(pickupLoc + "\n" + dropLoc + "\n" + pickupDate + "\n" + dropDate + "\n" + passengers + "\n" + rentalChrge + "\n" + specialReq);
	}
	
	private String dateFormatting(String date){
		//Date-format (yyyy-MM-dd") -> (dd/MM/yyyy)
		DateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date parse = null;
		
		try{
			parse = inputDateFormat.parse(date);
			date  = outputDateFormat.format(parse);
		}catch (ParseException e){
			e.printStackTrace();
			System.out.println("Error parsing the custom date: " + e.getMessage());
		}
		return date;
	}
}