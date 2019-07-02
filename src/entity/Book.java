package entity;

public class Book {
	private String ISBN;
	private String title;
	private String author;
	private String press;
	private String price;
	private String category_id;
	private String category_name;
	private String introduce;
	private String location_id;
	private String location_name;
	/**
	 * @return the location_name
	 */
	public String getLocation_name() {
		return location_name;
	}
	/**
	 * @param location_name the location_name to set
	 */
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	private String callnumber;
	private String total;
	private String canborrow;
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
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
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id= location_id;
	}
	public String getCallnumber() {
		return callnumber;
	}
	public void setCallnumber(String callnumber) {
		this.callnumber = callnumber;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getCanborrow() {
		return canborrow;
	}
	public void setCanborrow(String canborrow) {
		this.canborrow = canborrow;
	}
	

}
