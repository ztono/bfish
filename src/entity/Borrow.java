package entity;

public class Borrow {
	private String sbook_id;
	private String title;
	private String author;
	private String ISBN;
	private String borrow_time;
	private String shouldback_time;
	private String realback_time;
	private String bookstatus;
	private String fine;
	
	public String getBookstatus() {
		return bookstatus;
	}
	public void setBookstatus(String bookstatus) {
		this.bookstatus = bookstatus;
	}
	public String getFine() {
		return fine;
	}
	public void setFine(String fine) {
		this.fine = fine;
	}
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
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getSbook_id() {
		return sbook_id;
	}
	public void setSbook_id(String sbook_id) {
		this.sbook_id = sbook_id;
	}
	public String getBorrow_time() {
		return borrow_time;
	}
	public void setBorrow_time(String borrow_time) {
		this.borrow_time = borrow_time;
	}
	public String getShouldback_time() {
		return shouldback_time;
	}
	public void setShouldback_time(String shouldback_time) {
		this.shouldback_time = shouldback_time;
	}
	public String getRealback_time() {
		return realback_time;
	}
	public void setRealback_time(String realback_time) {
		this.realback_time = realback_time;
	}
	
}
