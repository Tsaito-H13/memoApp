package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Memo;

public class MemoDAO {
	private final String URL = "jdbc:mysql://localhost/memoApp";
	private final String USER = "root";
	private final String PASS = "password";
	
	/**
	 * メモ取得
	 * @return タイトル、内容、作成時刻を格納したmemoList
	 */
	public  List<Memo> findAll() {
		
		List<Memo> memoList = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			
			String sql = "SELECT memo_id, title, memo, modified_date FROM MEMO_DATA ORDER BY memo_id DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int memoId = rs.getInt("memo_id");
				String title = rs.getString("title");
				String memo = rs.getString("memo");
			    String modifiedDate = rs.getString("modified_date");
				Memo text = new Memo(memoId, title, memo, modifiedDate);
				memoList.add(text);
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
	
	/**
	 * メモ削除
	 * @param memoId
	 * @return 削除できればtrue、出来なければfalse
	 */
	public boolean delete(int memoId) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM MEMO_DATA WHERE memo_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, memoId);
			
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
