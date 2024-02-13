package Ejercicio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TVideojuegoModel {
	private Connection conn;


	public TVideojuegoModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
		conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
	}
	
	public void removeVideojuego(String nombre) throws SQLException {
		
		String query = "DELETE FROM tvideojuegos where nombre = '" + nombre + "'";
		
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.executeUpdate();
	    }

	}
	
	public void close() throws SQLException {
		conn.close();
	}
}
