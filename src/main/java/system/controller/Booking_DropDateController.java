package system.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Booking_DropDateController
 */
@WebServlet("/source/user_pages/front_page/CheckDropDateServlet")
public class Booking_DropDateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Drop Date Checking");
		response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.print("Drop Date Checking");
	}

}
