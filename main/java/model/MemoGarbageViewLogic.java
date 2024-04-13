package model;

import java.util.List;

import dao.MemoDAO;

public class MemoGarbageViewLogic {
	public List<Memo> execute() {
		MemoDAO dao = new MemoDAO();
		List<Memo> memoList = dao.deleteFindAll();
		return memoList;
	}

}
