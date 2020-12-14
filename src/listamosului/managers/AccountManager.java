package listamosului.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//ok
import listamosului.baseclasses.Account;

public class AccountManager {

	private AccountManager instance = null;
	
	private AccountManager() {}
	
	public AccountManager getInstance() {
		if(instance == null) {
			instance = new AccountManager();
		}
		
		return instance;
	}
	
	ConnectionManager connMan = ConnectionManager.getInstance();
	//create function insert
	public int insertAccount(String username, String password, User user) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		int rowsInserted = 0;
		
		try {
			connection = connMan.openConnection();
			String sql = "INSERT INTO 'account'('username', 'password', 'id_user') VALUES(?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			// statement.setInt(3, user); TODO: scrie metoda user.getId() 
			rowsInserted = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connMan.closeConnection(connection, statement);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rowsInserted;
	}
	//function update
	public int updateAccount(String username, String password, User user) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		int rowsUpdated = 0;
		
		try {
			connection = connMan.openConnection();
			String sql = "UPDATE 'account' SET 'username'=?, 'password'=?, 'id_user'=? WHERE 'id'=?";
			statement = connection.preparedStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			//statement.setString(3, user)
			rowsUpdated = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			try {
				connMan.closeConnection(connection, statement);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return rowsUpdated;
	}
}
