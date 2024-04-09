package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		//リクエストパラメータを取得
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		boolean result = false;
		
		//エラーメッセージリストの作成
		List<String> errorMessages = new ArrayList<>();
		
		//入力値のチェック
		if(userId == null || userId.isEmpty()) {
			errorMessages.add("※ユーザーIDを入力してください");
		}
		if(pass == null || pass.isEmpty()) {
			errorMessages.add("※パスワードを入力してください");
		}
		
		if(errorMessages.isEmpty()) { //問題がない場合
			//削除するユーザー情報を設定
			User user = new User(userId, pass);
			//削除処理の実行
			SecessionLogic secessionLogic = new  SecessionLogic();
			//結果をresultに格納
			result = secessionLogic.execute(user);
		} else {  // エラーメッセージが格納された場合
			//エラーメッセージをリクエストスコープへ保存
			request.setAttribute("errorMessage", errorMessages);
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/secession.jsp");
			dispatcher.forward(request, response);
			
		}
		
		if(result) { //削除できた場合
			//セッションスコープの破棄
			HttpSession session = request.getSession();
			session.invalidate();
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/secessionOK.jsp");
			dispatcher.forward(request, response);
		} else { //削除できない場合
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/secessionNG.jsp");
			dispatcher.forward(request, response);
		}
	}
}