package model;

import java.util.ArrayList;
import java.util.HashMap;

import dao.MemoDAO;

public class MemoViewLogic {
	public ArrayList<HashMap<String, String>> execute() {
		MemoDAO dao = new MemoDAO();
		ArrayList<HashMap<String, String>> memoList = dao.findAll();
		return memoList;
	}
}
