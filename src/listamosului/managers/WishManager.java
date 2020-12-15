package listamosului.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import listamosului.baseclasses.Wish;

public class WishManager {

	private static WishManager instance = null;
	private ConnectionManager connMan = ConnectionManager.getInstance();
	
	private WishManager() {}
	
	public static WishManager getInstance() {
		if(instance == null) {
			instance = new WishManager();
		}
		
		return instance;
	}
	
	public int insertWish(Wish wish) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet keySet = null;
		int key = 0;
		
		try {
			connection = connMan.openConnection();
			String sql = "INSERT INTO cm_tr_wishes(wish, id_user) VALUES(?,?)";
			statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, wish.getWish());
			statement.setInt(2, wish.getIdUser());
			int rowsInserted = statement.executeUpdate();
			
			if(rowsInserted > 0) {
				keySet = statement.getGeneratedKeys();
				while(keySet.next()) {
					key = keySet.getInt(1);
					wish.setId(key);
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
	
	public int updateWish(Wish wish) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		int rowsUpdated = 0;
		
		try {
			connection = connMan.openConnection();
			String sql = "UPDATE cm_tr_wishes SET wish=?, id_user=? WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, wish.getWish());
			statement.setInt(2, wish.getIdUser());
			statement.setInt(3, wish.getId());
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
	
	public Wish getWishByUserId(int idUser) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet wishSet = null;
		Wish wish = null;
		
		try {
			connection = connMan.openConnection();
			String sql = "SELECT id, wish FROM cm_tr_wishes WHERE id_user=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idUser);
			wishSet = statement.executeQuery();
			
			while(wishSet.next()) {
				int id = wishSet.getInt(1);
				String wishStr = wishSet.getString(2);
				
				wish = new Wish(id, wishStr, idUser);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connMan.closeConnection(connection, statement, wishSet);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return wish;
	}
}
