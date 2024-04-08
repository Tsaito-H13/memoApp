package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SecessionLogic;
import model.User;


@WebServlet("/SecessionServlet")
public class SecessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/secession.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		if(userId == null || pass == null) {
			response.sendRedirect("SecessionServlet");
		}
		User user = new User(userId, pass);
		SecessionLogic secessionLogic = new  SecessionLogic();
		boolean result = secessionLogic.execute(user);
			
		if(result) {
			HttpSession session = request.getSession();
			session.invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/secessionOK.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("errorMessage", "ユーザーIDまたはパスワードが正しくありません。再試行してください。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/secession.jsp");
			dispatcher.forward(request, response);
		}
	}
}