package system.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/source/user_pages/front_page/LogoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		// Get the current session
        HttpSession session = request.getSession(false);
        if (session != null) {
            // Invalidate the session and remove all attributes
            session.invalidate();
        }
     // Redirect the user to a login page or any other appropriate page
        //response.sendRedirect("/source/user_pages/front_page/user_front.jsp");
        dispatcher = request.getRequestDispatcher("/source/user_pages/front_page/user_front.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
