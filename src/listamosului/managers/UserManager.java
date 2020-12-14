package listamosului.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import listamosului.baseclasses.User;

public class UserManager {
	
    private UserManager instance = null;
	
	private UserManager() {}
	
	public UserManager getInstance() {
		if(instance == null) {
			instance = new UserManager();
		}
		
		return instance;
	}
	
	ConnectionManager connMan = ConnectionManager.getInstance();
	//create function insert
	public int insertUser(String lastname, String firstname, String address, String birthday, String isnice ) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		int rowsInserted = 0;
		
		try {
			connection = connMan.openConnection();
			String sql = "INSERT INTO 'user'('lastname', 'firstname', 'address', 'birthday', 'isnice' ) VALUES(?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, lastname);
			statement.setString(2, firstname);
			statement.setString(3, address);
			statement.setString(4, birthday);
			statement.setString(5, isnice);
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
	public int updateUser(String lastname, String firstname, String address, String birthday, String isnice ) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		int rowsUpdated = 0;
		
		try {
			connection = connMan.openConnection();
			String sql = "UPDATE 'account' SET 'lastname'=?, 'firstname'=?, 'address'=?, 'birthday'=?, 'isnice'=? WHERE 'id'=?";
			statement = connection.preparedStatement(sql);
			statement.setString(1, lastname);
			statement.setString(2, firstname);
			statement.setString(3, address);
			statement.setString(4, birthday);
			statement.setString(5, isnice);
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
