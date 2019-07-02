package entity;

public class SBook {
	private String sbook_id;
	private String shouldback_time;
	private String reserve_time;
	private String ISBN;
	private String bookstatus; 
	
	/**
	 * @return the bookstatus
	 */
	public String getBookstatus() {
		return bookstatus;
	}
	/**
	 * @param bookstatus the bookstatus to set
	 */
	public void setBookstatus(String bookstatus) {
		this.bookstatus = bookstatus;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getShouldback_time() {
		return shouldback_time;
	}
	public void setShouldback_time(String shouldback_time) {
		this.shouldback_time = shouldback_time;
	}
	public String getReserve_time() {
		return reserve_time;
	}
	public void setReserve_time(String reserve_time) {
		this.reserve_time = reserve_time;
	}
	public String getSbook_id() {
		return sbook_id;
	}
	public void setSbook_id(String sbook_id) {
		this.sbook_id = sbook_id;
	}

	

}
