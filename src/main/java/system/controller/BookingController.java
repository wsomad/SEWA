package system.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import system.dao.BookingDAO;
import system.model.Vehicle;

/**
 * Servlet implementation class BookingController
 */
@WebServlet("/source/user_pages/cars_page/BookingController")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int vehicleid = Integer.parseInt(request.getParameter("vehicleId"));
		System.out.println("Booking Controller : "+vehicleid);
		BookingDAO bookingdao = new BookingDAO();
	}

}
