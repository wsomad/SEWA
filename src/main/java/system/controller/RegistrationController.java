package system.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import system.model.*;
import system.dao.*;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/source/user_pages/front_page/registration")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userdao = new UserDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		
		RequestDispatcher dispatcher = null;
		
		user.setUser_first_name(request.getParameter("firstname"));
		user.setUser_last_name(request.getParameter("firstname"));
		user.setUser_email(request.getParameter("email"));
		user.setUser_phone(request.getParameter("phonenum"));
		user.setUser_uname(request.getParameter("username"));
		user.setUser_pass(request.getParameter("password"));
		
		try {
			int rowCount = userdao.registerUser(user);
			
			//dispatcher = request.getRequestDispatcher("/user_front.jsp");
			if(rowCount > 0) {
				request.setAttribute("RegistrationStatus", "success");
			}else {
				request.setAttribute("RegistrationStatus", "failed");
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		dispatcher = request.getRequestDispatcher("/source/user_pages/front_page/user_front.jsp");
		dispatcher.forward(request, response);
	}
}
