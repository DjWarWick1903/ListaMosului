package listamosului.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import listamosului.baseclasses.Wish;

public class WishManager {
	
	 private WishManager instance = null;
		
		private WishManager() {}
		
		public WishManager getInstance() {
			if(instance == null) {
				instance = new WishManager();
			}
			
			return instance;
		}
		
		ConnectionManager connMan = ConnectionManager.getInstance();
		//create function insert
		public int insertWish(String wish, User user ) {
			
			Connection connection = null;
			PreparedStatement statement = null;
			
			int rowsInserted = 0;
			
			try {
				connection = connMan.openConnection();
				String sql = "INSERT INTO 'wish'('wish', 'id_user' ) VALUES(?,?)";
				statement = connection.prepareStatement(sql);
				statement.setString(1, wish);
				statement.setInt(2,user);
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
				String sql = "UPDATE 'account' SET 'wish'=?, 'id_user'=? WHERE 'id'=?";
				statement = connection.preparedStatement(sql);
				statement.setString(1, wish);
				statement.setInt(2,user);
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

}
