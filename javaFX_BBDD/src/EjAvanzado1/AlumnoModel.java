package EjAvanzado1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AlumnoModel {
	private Connection conn;

	public AlumnoModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
		conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
	}

	public List<Alumno> getAllAlumnos() throws SQLException {
		List<Alumno> alumnos = new ArrayList<>();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM alumnoscenec");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String nombre = rs.getString("nombre");
			String apellido1 = rs.getString("apellido1");
			String apellido2 = rs.getString("apellido2");
			int es_repetidor = rs.getInt("es_repetidor");
			
			boolean repetidor;
			if(es_repetidor==0) {
				repetidor=false;
			}
			else {
				repetidor=true;
			}
			
			String fecha = rs.getString("fecha_nacimiento");
			int telefono = rs.getInt("telefono");
			
			alumnos.add(new Alumno(nombre, apellido1, apellido2, repetidor, fecha, telefono));
		}
		stmt.close();
		rs.close();
		return alumnos;
	}

	public void close() throws SQLException {
		conn.close();
	}
}
