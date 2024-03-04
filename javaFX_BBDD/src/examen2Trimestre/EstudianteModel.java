package examen2Trimestre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteModel {
	private Connection conn;

	public EstudianteModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
		conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
	}

	public List<Estudiante> getAllEstudiantes() throws SQLException {
		List<Estudiante> estudiantes = new ArrayList<>();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM estudiantes");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String nombre = rs.getString("nombre");
			String correo_electronico = rs.getString("correo_electronico");
			String telefono = rs.getString("telefono");
			String curso = rs.getString("curso");
			String fecha_inscripcion = rs.getString("fecha_inscripcion");
			estudiantes.add(new Estudiante(id, nombre, correo_electronico, telefono, curso, fecha_inscripcion));
		}
		stmt.close();
		rs.close();
		return estudiantes;
	}

	public void addEstudiante(Estudiante nuevoEstudiante) throws SQLException {
	    String query = "INSERT INTO estudiantes (nombre, correo_electronico, telefono, curso, fecha_inscripcion) VALUES (?, ?, ?, ?, ?)";


	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setString(1, nuevoEstudiante.getNombre());
	        stmt.setString(2, nuevoEstudiante.getCorreo());
	        stmt.setString(3, nuevoEstudiante.getTelefono());
	        stmt.setString(4, nuevoEstudiante.getCurso());
	        stmt.setString(5, nuevoEstudiante.getFecha());

	        stmt.executeUpdate();
	    }
	}
	
	public void deleteEstudiante(String nombre) throws SQLException {
	    String query = "DELETE FROM estudiantes where nombre = '"+nombre+"'";

	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.executeUpdate();
	    }
	}
	
	
	
	public void close() throws SQLException {
		conn.close();
	}

}

