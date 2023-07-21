package system.controller;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import system.model.*;
import system.dao.ActivityDAO;

/**
 * Servlet implementation class ActivityController
 */
@WebServlet("/source/user_pages/front_page/ActivityController")
public class ActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActivityDAO activitydao = new ActivityDAO();
	RequestDispatcher dispatcher = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ACTIVITY CONTROLLER");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userobj");
		
		try {	
			List<Activity> activities = activitydao.getActivities(user.getUserid());
			session.setAttribute("listOfActivity", activities);
			
			
			dispatcher = request.getRequestDispatcher("/source/user_pages/record_page/record.jsp");
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
