package model;

//メモ格納クラス
public class Memo {
	
	//メモID
	private int memoId;
	
	//タイトル
	private String title;
	
	//メモ
	private String memo;
	
	//作成時刻
	private String modifiedDate;
	
	public Memo(String title, String memo) {
		this.title = title;
		this.memo = memo;
	}
	public Memo(int memoId, String title, String memo, String modifiedDate) {
		this.memoId = memoId;
		this.title = title;
		this.memo = memo;
		this.modifiedDate = modifiedDate;
	}

	public int getMemoId() {
		return memoId;
	}
	public String getTitle() {
		return title;
	}
	public String getMemo() {
		return memo;
	}
	public String modifiedDate() {
		return modifiedDate;
	}
}
