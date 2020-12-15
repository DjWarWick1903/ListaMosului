package listamosului.baseclasses;

public class Wish {
	private int id;
	private String wish;
	private int idUser;
	
	public Wish() {}

	public Wish(int id, String wish, int idUser) {
		this.id = id;
		this.wish = wish;
		this.idUser = idUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWish() {
		return wish;
	}

	public void setWish(String wish) {
		this.wish = wish;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
