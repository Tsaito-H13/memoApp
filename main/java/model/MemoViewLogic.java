package model;

import java.util.ArrayList;
import java.util.HashMap;

import dao.MemoDAO;

//メモ取得処理クラス
public class MemoViewLogic {
	
	/**
	 * データベースのメモを取得して表示
	 * @return メモのタイトル、内容、作成時刻を格納したmemoList
	 */
	public ArrayList<HashMap<String, String>> execute() {
		MemoDAO dao = new MemoDAO();
		
		//MemoDAOのfindAllメソッドで取得した情報をmemoListに格納
		ArrayList<HashMap<String, String>> memoList = dao.findAll();
		
		return memoList;
	}
}
