package Models;

public class User {
	
	private int id;
	private String name;
	private String gender;
	private String dob;
	private String phoneNumber;
	private String email;
	private double salary;
	private String address;
	private String password;
	private String role;
	
	public User(int id, String name, String gender, String dob, String phoneNumber, String email, double salary, String address, String password, String role) {
		setID(id);
		setName(name);
		setGender(gender);
		setDob(dob);
		setPhoneNumber(phoneNumber);
		setEmail(email);
		setSalary(salary);
		setAddress(address);
		setPassword(password);
		setRole(role);
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String toString() {
		return "User: " + "[ " + id + " - " + name + " - " + gender + " - " + position + " - " + dob + " - " + phoneNumber + " - " + email + " - " + salary + " - " + address + " - " + password + " - " + role + " ]";
	}

}
