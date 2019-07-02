package entity;

public class Reader {
	private String reader_id;
	private String name;
	private String password;
	private String email;

	
	/**
	 * 
	 */
	public Reader() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the reader_id
	 */
	public String getReader_id() {
		return reader_id;
	}
	/**
	 * @param reader_id the reader_id to set
	 */
	public void setReader_id(String reader_id) {
		this.reader_id = reader_id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
