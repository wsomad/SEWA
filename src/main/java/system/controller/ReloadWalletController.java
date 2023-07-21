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
import system.dao.UserDAO;

/**
 * Servlet implementation class ReloadWalletController
 */
@WebServlet("/source/user_pages/front_page/ReloadWalletController")
public class ReloadWalletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		UserDAO userdao = new UserDAO();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userobj");
		double reloadAmount = Double.parseDouble(request.getParameter("reloadAmount"));
		
		user = userdao.reloadWallet(reloadAmount, user);
		
		session.setAttribute("userobj", user);
		dispatcher = request.getRequestDispatcher("/source/user_pages/dashboard_page/user-dashboard.jsp");
		dispatcher.forward(request, response);
	}

}
