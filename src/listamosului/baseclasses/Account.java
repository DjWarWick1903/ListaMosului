package listamosului.baseclasses;

public class Account {
	private int id;
	private String email;
	private String username;
	private String password;
	private User user;
	
	public Account() {}

	public Account(int id, String email, String username, String password, User user) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}