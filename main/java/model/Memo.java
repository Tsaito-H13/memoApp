package model;

public class Memo {
	private String title;
	private String memo;
	private String modified_date;
	
	public Memo(String title, String memo) {
		this.title = title;
		this.memo = memo;
	}
	public Memo(String title, String memo, String modified_date) {
		this.title = title;
		this.memo = memo;
		this.modified_date = modified_date;
	}

	public String getTitle() {
		return title;
	}
	public String getMemo() {
		return memo;
	}
	public String getModifiedDate() {
		return modified_date;
	}
}
