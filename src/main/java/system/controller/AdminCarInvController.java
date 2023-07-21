package system.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import system.dao.VehicleDAO;

/**
 * Servlet implementation class AdminCarInvController
 */
@WebServlet("/source/admin_pages/front_page/AdminCarInvController")
public class AdminCarInvController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		VehicleDAO vehicledao = new VehicleDAO();
		
		try {
			List<Vehicle> vehicles = vehicledao.getVehiclesList();
			session.setAttribute("ListOfVehicle", vehicles);
			dispatcher = request.getRequestDispatcher("/source/user_pages/record_page/record.jsp");
			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
