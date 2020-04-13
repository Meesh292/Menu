package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Food;


public class FoodDAO {

	private Connection connection;
	private final String GET_FOOD_QUERY = "SELECT * FROM food";
	private final String ADD_FOOD = "INSERT INTO food VALUES(id, food_name, category, price) WHERE id = ?";
	private final String REMOVE_FOOD = "DELETE FROM food WHERE id = ?";
	
	
	public FoodDAO() {
		connection = DBConnection.getConnection();	
	}
	
	public List<Food> getFood() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_FOOD_QUERY).executeQuery();
		List<Food> foods = new ArrayList<Food>();
		
		while (rs.next()) {
			foods.add(populateFood(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
		}
		return foods;

	}
	
	public void addFood(int id, String foodName, String category, double price) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(ADD_FOOD);
		ps.setInt(1, id);
		ps.setString(2, foodName);
		ps.setString(3, category);
		ps.setDouble(4, price);
		ps.executeUpdate();
	}
	public void removeFood(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(REMOVE_FOOD);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	private Food populateFood(int id, String foodName, String category, double price) {
		return new Food(id, foodName, category, price);
	}
	
}