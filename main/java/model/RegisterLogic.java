package model;

import dao.AccountsDAO;

public class RegisterLogic {
	public boolean execute(Account account) {
		AccountsDAO dao = new AccountsDAO();
		String hashedPassword = PasswordHasher.hashPassword(account.getPass());
		account.setPass(hashedPassword);
		boolean registerResult = dao.create(account);
		return registerResult;
	}
}
