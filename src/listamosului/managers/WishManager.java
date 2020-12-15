package listamosului.managers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import listamosului.baseclasses.User;

public class UserManager {

	private static UserManager instance = null;
	
	private UserManager() {}
	
	public static UserManager getInstance() {
		if(instance == null) {
			instance = new UserManager();
		}
		
		return instance;
	}
	
	ConnectionManager connMan = ConnectionManager.getInstance();
	
	public int insertUser(User user) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet keySet = null;
		int key = 0;
		
		try {
			connection = connMan.openConnection();
			String sql = "INSERT INTO cm_tr_user(lastname, firstname, address, birthday, isnice) VALUES(?,?,?,?,?)";
			statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, user.getLastName());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getAddress());
			statement.setDate(4, Date.valueOf(user.getBirthday()));
			if(user.isNice()) {
				statement.setInt(5, 1);
			} else {
				statement.setInt(5, 0);
			}
			int rowsInserted = statement.executeUpdate();
			
			if(rowsInserted > 0) {
				keySet = statement.getGeneratedKeys();
				while(keySet.next()) {
					key = keySet.getInt(1);
					user.setId(key);
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
	
	public int updateUser(User user) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		int rowsUpdated = 0;
		
		try {
			connection = connMan.openConnection();
			String sql = "UPDATE cm_tr_user SET lastname=?, firstname=?, address=?, birthday=?, isnice=? WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getLastName());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getAddress());
			statement.setDate(4, Date.valueOf(user.getBirthday()));
			if(user.isNice()) {
				statement.setInt(5, 1);
			} else {
				statement.setInt(5, 0);
			}
			statement.setInt(6, user.getId());
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
	
	public LinkedList<User> getAllUsers() {
		Connection connection = null;
		Statement statement = null;
		ResultSet userSet = null;
		LinkedList<User> list = new LinkedList<User>();
		
		try {
			connection = connMan.openConnection();
			String sql = "SELECT id, lastname, firstname, address, birthday, isnice "
					+ "FROM cm_tr_user";
			statement = connection.createStatement();
			userSet = statement.executeQuery(sql);
			
			while(userSet.next()) {
				int id = userSet.getInt("id");
				String lastname = userSet.getString("lastname");
				String firstname = userSet.getString("firstname");
				String address = userSet.getString("address");
				LocalDate birthdate = userSet.getDate("birthday").toLocalDate();
				int isNice = userSet.getInt("isnice");
				
				User user = new User();
				user.setId(id);
				user.setLastName(lastname);
				user.setFirstName(firstname);
				user.setAddress(address);
				user.setBirthday(birthdate);
				if(isNice == 1) {
					user.setNice(true);
				} else {
					user.setNice(false);
				}
				
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connMan.closeConnection(connection, statement, userSet);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public User getUserById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet userSet = null;
		User user = null;
		
		try {
			connection = connMan.openConnection();
			String sql = "SELECT lastname, firstname, address, birthday, isnice "
					+ "FROM cm_tr_user WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			userSet = statement.executeQuery();
			
			while(userSet.next()) {
				String lastname = userSet.getString("lastname");
				String firstname = userSet.getString("firstname");
				String address = userSet.getString("address");
				LocalDate birthdate = userSet.getDate("birthday").toLocalDate();
				int isNice = userSet.getInt("isnice");
				
				user = new User();
				user.setId(id);
				user.setLastName(lastname);
				user.setFirstName(firstname);
				user.setAddress(address);
				user.setBirthday(birthdate);
				if(isNice == 1) {
					user.setNice(true);
				} else {
					user.setNice(false);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connMan.closeConnection(connection, statement, userSet);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}
}