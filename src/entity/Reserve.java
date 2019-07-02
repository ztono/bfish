package entity;

public class Reserve {
	
	private String sbook_id;
	private String title;
	private String author;
	private String ISBN;
	private String reserve_time;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getSbook_id() {
		return sbook_id;
	}
	public void setSbook_id(String sbook_id) {
		this.sbook_id = sbook_id;
	}
	public String getReserve_time() {
		return reserve_time;
	}
	public void setReserve_time(String reserve_time) {
		this.reserve_time = reserve_time;
	}
	
	
}
