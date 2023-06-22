package system.controller;

import java.io.IOException;

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
 * Servlet implementation class LoginController
 */
@WebServlet("/source/user_pages/front_page/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userdao = new UserDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		Vehicle vehicle = new Vehicle();
		Reservation reservation = new Reservation();
		RequestDispatcher dispatcher = null;
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//Test
		System.out.println("email : " + email + "\npass : " + password );
		
		try {
			//First Validation
			user = userdao.loginValidation(email, password);
			//Test
			System.out.println(user.toString());
			//Second Validation
			if(user.getUser_email().equals(email) && user.getUser_pass().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("userobj", user);
				//response.sendRedirect("/PROJECT/src/main/webapp/test.jsp");
				//response.sendRedirect("/PROJECT/src/main/webapp/source/user_pages/dashboard_page/user-dashboard.jsp");
				dispatcher = request.getRequestDispatcher("/source/user_pages/dashboard_page/user-dashboard.jsp");
				//Test
				System.out.println("Second Validation Succesful!");
			}else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("/source/user_pages/front_page/user_front.jsp");
				//Test
				System.out.println("Second Validation UnSuccesful!");
			}
			dispatcher.forward(request, response);
			//Test
			System.out.println("forwarded");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
