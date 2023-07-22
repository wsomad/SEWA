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
import system.model.*;
import system.dao.ReservationDAO;

/**
 * Servlet implementation class ConfirmBookingController
 */
//Run from dashboard
//@WebServlet("/source/user_pages/dashboard_page/ConfirmBookingController")
//Run from login
@WebServlet("/source/user_pages/front_page/ConfirmBookingController")
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
		reservation = new Reservation(0,0,pickupLoc,dropLoc,pickupDate,dropDate,passengers,specialReq,rentalChrge, null, true);
		
		/*request.setAttribute("reservation", reservation);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/source/user_pages/booking_page/confirm-booking.jsp");
		dispatcher.forward(request, response);*/
		
		HttpSession session = request.getSession();
		session.setAttribute("reservation", reservation);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/source/user_pages/booking_page/confirm-booking.jsp");
		dispatcher.forward(request, response);
	}
	
	public String dateFormatting(String date){
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("userobj");
		Vehicle vehicle = (Vehicle) request.getSession().getAttribute("vehicleInForm");
		Reservation reservation = (Reservation) request.getSession().getAttribute("reservation");
		RequestDispatcher dispatcher = null;
		
		reservation.setReservation_userid(user.getUserid());
		reservation.setReservation_vehicleid(vehicle.getVehicleid());
		System.out.println("from servlet--------------\n" + reservation.toString());
		
		try {
			//Booking Confirmed
			ReservationDAO reservationdao = new ReservationDAO();
			int rowCount_booking = reservationdao.makeReservation(reservation);
			
			//Make Payment
			user.setUser_wallet(user.getUser_wallet()-reservation.getRent_to_pay());
			int rowCount_payment = reservationdao.makeReservationPayment(user);
			
			//Off Vehicle's Availability
			vehicle.setAvailability(false);
			int rowCount_vehicle = reservationdao.makeVehicleUnavailable(vehicle);
			
			//Check sufficient wallet amount
			boolean sufficientFlag = false;
			if(user.getUser_wallet() >= reservation.getRent_to_pay()) {
				sufficientFlag = true;
			}
			
			dispatcher = request.getRequestDispatcher("/source/user_pages/dashboard_page/user-dashboard.jsp");
			if((rowCount_booking > 0) && (rowCount_payment > 0) && (rowCount_vehicle > 0) && (sufficientFlag)) {
				request.setAttribute("confirmBookingStatus", "success");
				HttpSession session = request.getSession();
				session.setAttribute("userobj", user);
				session.setAttribute("vehicleobj", vehicle);
			}else {
				request.setAttribute("confirmBookingStatus", "failed");
			}
			dispatcher.forward(request, response);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}