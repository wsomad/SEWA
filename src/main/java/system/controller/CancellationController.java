package system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.dao.ReservationDAO;
import system.model.*;

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
		HttpSession session = request.getSession();
		ReservationDAO reservationdao = new ReservationDAO();
		int rowCount = 0;
		
		User user = (User) session.getAttribute("userobj");
		int userid = user.getUserid();
		int vehicleid = Integer.parseInt(request.getParameter("vehicleid"));
		
		System.out.println("userid to cancel : " + userid);
		System.out.println("vehicleid to cancel : " + vehicleid);
		
		List<Activity> activities = (List<Activity>) session.getAttribute("listOfActivity");
		List<Activity> temp = new ArrayList <>();
		Reservation reservation = null;
		
		if(activities!=null) {
			for(Activity activity : activities) {
				if((activity.getReservation().getReservation_vehicleid()==vehicleid) && (activity.getReservation().getReservation_userid()==userid)){
					try {
						rowCount = reservationdao.deleteReservation(userid, vehicleid);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue;
				}else {
					temp.add(activity);
				}
			}
			activities = new ArrayList<>();
			for(Activity activity : temp) {
				activities.add(activity);
			}
		}
		
		dispatcher = request.getRequestDispatcher("/source/user_pages/dashboard_page/user-dashboard.jsp");
		if(rowCount > 0) {
			request.setAttribute("CancellationStatus", "success");
			session.removeAttribute("existing_reservation");
		}else {
			request.setAttribute("CancellationStatus", "failed");
		}
		dispatcher.forward(request, response);
		
	}

}
