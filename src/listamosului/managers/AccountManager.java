package listamosului.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
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
	
	public int insertAccount(Account account) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet keySet = null;
		
		int key = 0;
		
		try {
			connection = connMan.openConnection();
			String sql = "INSERT INTO cm_tr_account(username, password, id_user) VALUES(?,?,?)";
			statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, account.getUsername());
			statement.setString(2, account.getPassword());
			statement.setInt(3, account.getUser().getId());
			int rowsInserted = statement.executeUpdate();
			
			if(rowsInserted > 0) {
				keySet = statement.getGeneratedKeys();
				while(keySet.next()) {
					key = keySet.getInt(1);
					account.setId(key);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connMan.closeConnection(connection, statement, keySet);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return key;
	}
	
	public int updateAccount(Account account) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		int rowsUpdated = 0;
		
		try {
			connection = connMan.openConnection();
			String sql = "UPDATE cm_tr_account SET username=?, password=?, id_user=? WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, account.getUsername());
			statement.setString(2, account.getPassword());
			statement.setInt(3, account.getUser().getId());
			statement.setInt(4, account.getId());
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
	
	public LinkedList<Account> getAllAccounts() {
		Connection connection = null;
		Statement statement = null;
		ResultSet accountSet = null;
		LinkedList<Account> list = new LinkedList<Account>();
		
		try {
			connection = connMan.openConnection();
			String sql = "SELECT id, username, password, id_user "
					+ "FROM cm_tr_account";
			statement = connection.createStatement();
			accountSet = statement.executeQuery(sql);
			
			while(accountSet.next()) {
				int id = accountSet.getInt("id");
				String username = accountSet.getString("username");
				String password = accountSet.getString("password");
				int idUser = accountSet.getInt("id_user");
				
				//TODO: add user getter
				
				Account account = new Account();
				account.setId(id);
				account.setUsername(username);
				account.setPassword(password);
				
				list.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connMan.closeConnection(connection, statement, accountSet);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}