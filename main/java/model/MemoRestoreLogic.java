package model;

import dao.MemoDAO;

public class MemoRestoreLogic {
	public boolean execute(int MemoId) {
		MemoDAO dao = new MemoDAO();
		boolean restoreResult = dao.restore(MemoId);
		return restoreResult;
	}

}
