package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		User user = new User(userId, pass);
		LoginLogic loginLogic = new LoginLogic();
		boolean result = loginLogic.execute(user);
		
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/LoginResult.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/LoginNG.jsp");
			dispatcher.forward(request, response);
		}
	}
}
