package model;

import dao.MemoDAO;

public class MemoLogic {
	public void execute(Memo memo) {
		MemoDAO dao = new MemoDAO();
		dao.create(memo);
	}
}
