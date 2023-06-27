package system.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import system.dao.BookingDAO;

/**
 * Servlet implementation class Booking_DropDateController
 */
@WebServlet("/source/user_pages/front_page/CheckDropDateServlet")
public class Booking_DropDateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        BookingDAO bookingdao = new BookingDAO();
        
        String dropDate = request.getParameter("dropDate");
        String vehicleid = request.getParameter("vehicleID");
        String userid = request.getParameter("userID"); 
        System.out.println(dropDate);
        System.out.println(userid);
        System.out.println(vehicleid);
        
        String date = "";
        try {
        	date = bookingdao.validateDropDate (dropDate, userid, vehicleid);
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        if(date.equals("initial")) {
        	out.print("");
        }else {
        	out.print("Choose before " + date);
        }
	}

}
