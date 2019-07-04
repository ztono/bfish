/**
 * 
 */
package BEAN;

/**
 * @author Administrator
 *
 */
public class Client {
	private String username;
	private String password;
	private String idcard;
	private String email;
	private String telephone;
	private int client_no;

	public Client() {
	}

	public Client(String username, String password, String idcard, String email, String telephone, int client_no) {
		this.username = username;
		this.password = password;
		this.idcard = idcard;
		this.email = email;
		this.telephone = telephone;
		this.client_no = client_no;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getClient_no() {
		return client_no;
	}

	public void setClient_no(int client_no) {
		this.client_no = client_no;
	}

}
