package system.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.model.User;
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
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//Test
		System.out.println("Data Passed");
		
		try {
			//First Validation
			user = userdao.loginValidation(email, password);
			//Test
			System.out.println(user.toString());
			//Second Validation
			if(user.getUser_email().equals(email) && user.getUser_pass().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("userobj", user);
				response.sendRedirect("/PROJECT/src/main/webapp/source/user_pages/dashboard_page/user-dashboard.jsp");
				//RequestDispatcher dispatcher = request.getRequestDispatcher("user-dashboard.jsp");
				//Test
				System.out.println("Second Validation Succesful!");
			}else {
				request.setAttribute("status", "failed");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/PROJECT/src/main/webapp/source/user_pages/front_page/user-front.jsp");
				//Test
				System.out.println("Second Validation UnSuccesful!");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
