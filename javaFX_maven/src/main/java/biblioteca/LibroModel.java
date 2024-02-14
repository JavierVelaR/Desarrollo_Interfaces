package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroModel {
	private Connection conn;


	public LibroModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
		conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
	}
	
	public List<Libro> getAllLibros() throws SQLException {
		List<Libro> libros = new ArrayList<>();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM libro");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String nombre = rs.getString("nombre");
			String editorial = rs.getString("editorial");
			String autor = rs.getString("autor");
			int paginas = rs.getInt("paginas");
			
			libros.add(new Libro(nombre, editorial, autor, paginas));
		}
		stmt.close();
		rs.close();
		return libros;
	}
	
	public void addLibro(Libro nuevoLibro) throws SQLException {
	    String query = "INSERT INTO libro (nombre, editorial, autor, paginas) VALUES (?, ?, ?, ?)";

	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setString(1, nuevoLibro.getNombre());
	        stmt.setString(2, nuevoLibro.getEditorial());
	        stmt.setString(3, nuevoLibro.getAutor());
			stmt.setInt(4, nuevoLibro.getPaginas());

	        stmt.executeUpdate();
	    }
	}
	
	public void removeLibro(String nombre) throws SQLException {
		
		String query = "DELETE FROM libro where nombre = '" + nombre + "'";
		
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.executeUpdate();
	    }

	}
	
	public void close() throws SQLException {
		conn.close();
	}
}
