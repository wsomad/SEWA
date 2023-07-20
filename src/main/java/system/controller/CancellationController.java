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

import system.dao.ReservationDAO;
import system.model.Activity;
import system.model.Reservation;

/**
 * Servlet implementation class CancellationController
 */
@WebServlet("/source/user_pages/front_page/CancellationController")
public class CancellationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("cancel controller");
		RequestDispatcher dispatcher = null;
		int vehicleid = Integer.parseInt(request.getParameter("vehicleId"));
		
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
		
		ReservationDAO reservationdao = new ReservationDAO();
		try {
			int rowCount = reservationdao.deleteReservation(reservation);
			dispatcher = request.getRequestDispatcher("/source/user_pages/dashboard_page/user-dashboard.jsp");
			if(rowCount > 0) {
				request.setAttribute("status", "success");
				session.removeAttribute("existing_reservation");
			}else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
