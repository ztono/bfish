/**
 * 
 */
package BEAN;

/**
 * @author Administrator
 *
 */
public class Employee {
	private String username ;
	private String password;
	private String position;
	private String email;
	private String telephone;
	private String employee_no;

	public Employee(String username, String password, String position, String email, String telephone, String employee_no) {
		this.username = username;
		this.password = password;
		this.position = position;
		this.email = email;
		this.telephone = telephone;
		this.employee_no = employee_no;
	}
public  Employee(){
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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
	public String getEmployee_no() {
		return employee_no;
	}
	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}

}
