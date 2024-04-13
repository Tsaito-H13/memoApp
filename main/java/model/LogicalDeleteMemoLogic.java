package model;

import dao.MemoDAO;

public class LogicalDeleteMemoLogic {
	/**
	 * メモ論理削除処理
	 * @param memoId
	 * @return メモ論理削除実行の結果　削除できればtrue、出来なければfalse
	 */
	public boolean execute(int memoId) {
		MemoDAO dao = new MemoDAO();
		boolean deleteResult = dao.logicalDelete(memoId);
		return deleteResult;
	}
}
