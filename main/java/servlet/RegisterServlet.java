package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountsDAO;
import model.Account;
import model.RegisterLogic;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forwardPath = null;
		
		String action = request.getParameter("action");
		
		if(action == null) {
			forwardPath = "WEB-INF/jsp/register.jsp";
		} else if(action.equals("done")) {
			HttpSession session = request.getSession();
			Account registerAccount = (Account)session.getAttribute("registerAccount");
			
			RegisterLogic resisterLogic = new RegisterLogic();
			boolean registerResult = resisterLogic.execute(registerAccount);
			
			if(registerResult) {
				forwardPath = "WEB-INF/jsp/registerDone.jsp";
				session.removeAttribute("registerAccount");
			} else {
				forwardPath = "WEB-INF/jsp/registerNG.jsp";
				session.removeAttribute("registerAccount");
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		
		AccountsDAO dao = new AccountsDAO();
		
		if(userId == null || userId.isEmpty() || pass == null || pass.isEmpty() || name == null || name.isEmpty()) {
			response.sendRedirect("RegisterServlet");
	    } else if(dao.exists(userId)) {
	        request.setAttribute("errorMessage", "※そのユーザーIDは既に存在します");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
	        dispatcher.forward(request, response);
		} else {
			Account registerAccount = new Account(userId, pass, name);
			
			HttpSession session = request.getSession();
			session.setAttribute("registerAccount", registerAccount);
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerConfirm.jsp");
			dispatcher.forward(request, response);
		}
	}
}
