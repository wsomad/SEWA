package system.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import system.controller.ConfirmBookingController;
import system.model.Reservation;
import system.dao.ReservationDAO;

@WebServlet("/source/user_pages/front_page/AlterationController")
public class AlterationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		Reservation reservation = (Reservation) session.getAttribute("existing_reservation");
		int userid = reservation.getReservation_userid();
		int vehicleid = reservation.getReservation_vehicleid();
		Timestamp timestamp = reservation.getInsertionTimestamp();
		
		String pickupLoc = request.getParameter("pickup_location");
		String dropLoc = request.getParameter("drop_location");
		String pickupDate = request.getParameter("pickup_date");
		String dropDate = request.getParameter("drop_date");
		int passengers = Integer.parseInt(request.getParameter("passengers_num"));
		double rentalChrge = Double.parseDouble(request.getParameter("rental_charge").substring(3));
		String specialReq = request.getParameter("special_request");
		
		ConfirmBookingController externalControl = new ConfirmBookingController();
		pickupDate = externalControl.dateFormatting(pickupDate);
		dropDate = externalControl.dateFormatting(dropDate);
		
		reservation = new Reservation(userid, vehicleid, pickupLoc, dropLoc, pickupDate, dropDate, passengers, specialReq, rentalChrge, timestamp, false);
		
		ReservationDAO reservationdao = new ReservationDAO();
		try {
			int rowCount = reservationdao.alterReservation(reservation);
			dispatcher = request.getRequestDispatcher("/source/user_pages/dashboard_page/user-dashboard.jsp");
			if(rowCount > 0) {
				request.setAttribute("RescheduleStatus", "success");
				session.removeAttribute("existing_reservation");
			}else {
				request.setAttribute("RescheduleStatus", "failed");
			}
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
