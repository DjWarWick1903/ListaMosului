package listamosului.tools;

import java.sql.SQLException;
import java.sql.Connection;

import listamosului.managers.ConnectionManager;

public class Test {
	
	public static void main(String[] args) {
		ConnectionManager connMan = ConnectionManager.getInstance();
		
		String url = "jdbc:mysql://localhost:3306/craciun";
		String user = "root";
		String pass = "robertmaster1";
		
		connMan.writeToFile(url, user, pass);
		
		try {
			Connection conn = connMan.openConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
