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

import system.model.*;
import system.dao.*;

/**
 * Servlet implementation class CarPageController
 */
//Run from dashboard
//@WebServlet("/source/user_pages/dashboard_page/CarPageController")
//Run from login
@WebServlet("/source/user_pages/front_page/CarPageController")
public class CarPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("userobj");
		DashboardDAO dashboardDAO = new DashboardDAO();
		
		try {
			List<Vehicle> vehicleList = dashboardDAO.getDashboardContent(user);
			HttpSession session = request.getSession();
			session.setAttribute("dashboardContent", vehicleList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/source/user_pages/cars_page/cars.jsp");
			
			//test
			for (Vehicle keretaPakMat : vehicleList) {
	            System.out.println("ID Kereta Pakmat : " + keretaPakMat.getVehicleid());
	        }
			
			dispatcher.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
