package model;

import dao.AccountsDAO;

public class SecessionLogic {
	public boolean execute(User user) {
		AccountsDAO dao = new AccountsDAO();
		boolean result = dao.delete(user);
		return result;
	}
}
