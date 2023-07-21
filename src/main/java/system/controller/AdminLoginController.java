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
import system.dao.ActivityDAO;
import system.model.Activity;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/source/admin_pages/front_page/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActivityDAO activitydao = new ActivityDAO();
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			if(email.equals("sewa@admin.com") && password.equals("admin_password")) {
				
				try {
					List<Activity> orderHistory = activitydao.getOrderHistory();
					session.setAttribute("listOfOrderHistory", orderHistory);
				}catch(Exception e) {
					e.printStackTrace();
				}
				request.setAttribute("status", "success");
				dispatcher = request.getRequestDispatcher("/source/admin_pages/dashboard_page/admin-dashboard.jsp");
				
			}else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("/source/admin_pages/front_page/admin-front.jsp");
				//Test
				System.out.println("Validation UnSuccesful!");
			}
			dispatcher.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
