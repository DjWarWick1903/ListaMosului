package listamosului.tools;

import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Connection;

import listamosului.baseclasses.User;
import listamosului.managers.AccountManager;
import listamosului.managers.ConnectionManager;
import listamosului.managers.UserManager;

public class Test {
	
	public static void main(String[] args) {
//		String firstname = "Popescu";
//		String lastname = "Robert-Ionut";
//		String address = "Str. Libertatii nr. 6";
//		boolean isNice = true;
//		LocalDate bday = LocalDate.of(1999, 2, 19);
//		
//		User user = new User(0, lastname, firstname, address, bday, isNice);
//		UserManager man = UserManager.getInstance();
//		
//		man.insertUser(user);
		
		AccountManager accMan = AccountManager.getInstance();
		String user = "";
		String pass = "";
		
		System.out.println(accMan.checkIfAccountExists(user, pass));
	}

}
