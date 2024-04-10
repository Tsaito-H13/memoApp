package model;

import dao.MemoDAO;

//メモ削除処理クラス
public class MemoDeleteLogic {
	
	/**
	 * メモ削除処理
	 * @param memoId
	 * @return メモ削除実行の結果　削除できればtrue、出来なければfalse
	 */
	public boolean execute(int memoId) {
		MemoDAO dao = new MemoDAO();
		boolean deleteResult = dao.delete(memoId);
		return deleteResult;
	}
}
