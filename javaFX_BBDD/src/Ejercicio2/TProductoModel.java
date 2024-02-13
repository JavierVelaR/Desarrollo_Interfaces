package Ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TProductoModel {
	private Connection conn;

	public TProductoModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
		conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
	}

	public List<TProducto> getAllProductos() throws SQLException {
		List<TProducto> videojuegos = new ArrayList<>();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM producto");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			int idjuego = rs.getInt("codigo");
			String nombre = rs.getString("nombre");
			double precio = rs.getDouble("precio");
			int codigo_fabricante = rs.getInt("codigo_fabricante");
			videojuegos.add(new TProducto(idjuego, nombre, precio, codigo_fabricante));
		}
		stmt.close();
		rs.close();
		return videojuegos;
	}

	public void close() throws SQLException {
		conn.close();
	}

}

