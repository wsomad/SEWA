package system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.dao.BookingDAO;
import system.model.Vehicle;
import system.model.Activity;
import system.model.Reservation;

/**
 * Servlet implementation class BookingController
 */
//run from dashboard
//@WebServlet("/source/user_pages/dashboard_page/BookingController")
//run from login
@WebServlet("/source/user_pages/front_page/BookingController")
//@WebServlet(name = "MyServlet", urlPatterns = {"/source/user_pages/front_page/BookingController", "/source/admin_pages/front_page/BookingController"})
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BookingControllerPost");
		int vehicleid = Integer.parseInt(request.getParameter("vehicleId"));
		BookingDAO bookingdao = new BookingDAO();
		
		HttpSession session = request.getSession();
		List<Activity> activities = (List<Activity>) session.getAttribute("listOfActivity");
		Reservation reservation = null;
		
		if(activities!=null) {
			for(Activity activity : activities) {
				if(activity.getReservation().getReservation_vehicleid() == vehicleid){
					reservation = activity.getReservation();
					session.setAttribute("existing_reservation", reservation);
					break;
				}
			}
		}
		
		try {
			Vehicle vehicle = bookingdao.getRegistrationForm(vehicleid);
			
			/*request.setAttribute("vehicleInForm", vehicle);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/source/user_pages/booking_page/booking.jsp");
			dispatcher.forward(request, response);*/
			
			session.setAttribute("vehicleInForm", vehicle);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/source/user_pages/booking_page/booking.jsp");
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
}
