package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Application {
	public static void main(String[] args) {
		String connectionUrl = "jdbc:mysql://localhost:3306/dbexample?serverTimezone=UTC";
		
		try (
			//Create the connection object
			Connection conn = DriverManager.getConnection(connectionUrl, "root", "root");
			
			//Execute a SELECT instruction
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM person");
			ResultSet results = statement.executeQuery(); ) {
			
			//Show the results
			while (results.next()) {
				long id = results.getLong("id");
				String name = results.getString("name");
				System.out.println("id: " + id  + " name: " + "'" + name + "'");
			}
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}