package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import model.Memo;

public class MemoDAO {
	private final String URL = "jdbc:mysql://localhost/memoApp";
	private final String USER = "root";
	private final String PASS = "password";
	
	/**
	 * メモ取得
	 * @return タイトル、内容、作成時刻を格納したmemoList
	 */
	public  ArrayList<HashMap<String, String>> findAll() {
		
		ArrayList<HashMap<String, String>> memoList = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			
			String sql = "SELECT title, memo, modified_date FROM MEMO_DATA";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				HashMap<String, String> record = new HashMap<>();
				String title = rs.getString("title");
				record.put("title", title);
				String memo = rs.getString("memo");
				record.put("memo", memo);
				String modified_date = rs.getString("modified_date");
				record.put("modified_date", modified_date);
				memoList.add(record);
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return memoList;
	}
	
	/**
	 * メモ作成
	 * @param memo
	 * @return メモが作成出来ればtrue、作成できなければfalse
	 */
	public boolean create(Memo memo) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO MEMO_DATA(category, title, memo, create_date, modified_date) VALUES(0,?,?,cast(now() as datetime), cast(now() as datetime))";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, memo.getTitle());
			pStmt.setString(2, memo.getMemo());
			
			int result = pStmt.executeUpdate();
			
			if(result != 1) {
				conn.rollback();
				return false;
			}
			
			conn.commit();
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
