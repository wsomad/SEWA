package system.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.dao.BookingDAO;
import system.model.Vehicle;

/**
 * Servlet implementation class BookingController
 */
//run from dashboard
//@WebServlet("/source/user_pages/dashboard_page/BookingController")
//run from login
@WebServlet("/source/user_pages/front_page/BookingController")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int vehicleid = Integer.parseInt(request.getParameter("vehicleId"));
		BookingDAO bookingdao = new BookingDAO();
		
		try {
			Vehicle vehicle = bookingdao.getRegistrationForm(vehicleid);
			
			/*request.setAttribute("vehicleInForm", vehicle);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/source/user_pages/booking_page/booking.jsp");
			dispatcher.forward(request, response);*/
			
			HttpSession session = request.getSession();
			session.setAttribute("vehicleInForm", vehicle);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/source/user_pages/booking_page/booking.jsp");
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
