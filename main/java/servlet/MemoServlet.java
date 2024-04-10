package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Memo;
import model.MemoDeleteLogic;
import model.MemoViewLogic;
import model.User;

//メモコントローラー
@WebServlet("/MemoServlet")
public class MemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//メモの取得
		MemoViewLogic memoViewLogic = new MemoViewLogic();
		List<Memo> memoList = memoViewLogic.execute();
		//取得したメモをリクエストスコープに格納
		request.setAttribute("memoList", memoList);		
		
		//ログインしているか確認するためセッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		if(loginUser == null) { //ログインしていない
			//リダイレクト
			response.sendRedirect("index.jsp");
		} else { //ログイン済み
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/memo.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//リクエストパラメータの取得
		int memoId = Integer.parseInt(request.getParameter("memoId"));
		
		//メモ削除処理
		MemoDeleteLogic memoDeleteLogic = new MemoDeleteLogic();
		boolean deleteResult = memoDeleteLogic.execute(memoId);
		
		if(deleteResult) { //削除出来た場合
			//リダイレクト
			response.sendRedirect("MemoServlet");
		}
	}
}
