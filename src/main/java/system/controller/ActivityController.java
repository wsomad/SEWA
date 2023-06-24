package system.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Stack;

import system.model.*;
import system.dao.ActivityDAO;

/**
 * Servlet implementation class ActivityController
 */
@WebServlet("/source/user_pages/front_page/ActivityController")
public class ActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActivityDAO activitydao = new ActivityDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userobj");
		
		try {	
			Stack<Activity> activities = activitydao.getActivities(user.getUserid());
			System.out.println(activities.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
