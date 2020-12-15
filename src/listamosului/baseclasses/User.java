package listamosului.baseclasses;

import java.time.LocalDate;
import java.util.Random;

public class User {

	private int id;
	private String lastName;
	private String firstName;
	private String address;
	private LocalDate birthday;
	private boolean isNice;
	
	public User() {}

	public User(int id, String lastName, String firstName, String address, LocalDate birthday, boolean isNice) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.birthday = birthday;
		this.isNice = isNice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public boolean isNice() {
		return isNice;
	}

	public void setNice(boolean isNice) {
		this.isNice = isNice;
	}
	
	
}