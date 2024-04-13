package model;

import dao.MemoDAO;

public class MemoEditLogic {
	public boolean execute(Memo memo) {
		MemoDAO dao = new MemoDAO();
		boolean editResult = dao.edit(memo);
		return editResult;
	}
}