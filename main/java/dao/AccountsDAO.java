package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.User;

public class AccountsDAO {
	private final String URL = "jdbc:mysql://localhost/memoApp";
	private final String USER = "root";
	private final String PASS = "password";
	
	/** SELECT **/
	public Account findByLogin(User user) {
		Account account = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "SELECT user_id, pass, name FROM ACCOUNTS WHERE user_id=? AND pass=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserId());
			pStmt.setString(2, user.getPass());
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				String userId = rs.getString("user_id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				account = new Account(userId, pass, name);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}
	
	/** INSERT **/
	public boolean create(Account account) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO ACCOUNTS(user_id, pass, name) VALUES(?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getUserId());
			pStmt.setString(2, account.getPass());
			pStmt.setString(3, account.getName());
			
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
	
	/** DELETE **/
	public boolean delete(User user) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM ACCOUNTS WHERE user_id=? AND pass=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserId());
			pStmt.setString(2, user.getPass());
			
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
	
	public boolean exists(String userId) {
	    
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch(ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
		
	    try(Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
	        String sql = "SELECT COUNT(*) FROM ACCOUNTS WHERE user_id = ?";
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setString(1, userId);
	        
	        ResultSet rs = pStmt.executeQuery();
	        
	        if(rs.next()) {
	            int count = rs.getInt(1);
	            if(count > 0) {
	                return true;
	            }
	        }
	    } catch(SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
}