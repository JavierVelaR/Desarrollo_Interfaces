package examen2Trimestre;

import javafx.beans.property.*;

public class Estudiante {
	private IntegerProperty id = new SimpleIntegerProperty();
	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty correo = new SimpleStringProperty();
	private StringProperty telefono = new SimpleStringProperty();
	private StringProperty curso = new SimpleStringProperty();
	private StringProperty fecha = new SimpleStringProperty();

	public Estudiante(int id, String nombre, String correo, String telefono, String curso, String fecha) {
		this.id.set(id);
		this.nombre.set(nombre);
		this.correo.set(correo);
		this.telefono.set(telefono);
		this.curso.set(curso);
		this.fecha.set(fecha);
	}

	public int getId() {
		return id.get();
	}

	public IntegerProperty idProperty() {
		return id;
	}

	public void setId(int id) {
		this.id.set(id);
	}
	
	public String getNombre() {
		return nombre.get();
	}

	public StringProperty nombreProperty() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}

	public String getCorreo() {
		return correo.get();
	}

	public StringProperty correoProperty() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo.set(correo);
	}

	public String getTelefono() {
		return telefono.get();
	}

	public StringProperty telefonoProperty() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono.set(telefono);
	}

	public String getCurso() {
		return curso.get();
	}

	public StringProperty cursoProperty() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso.set(curso);
	}

	public String getFecha() {
		return fecha.get();
	}

	public StringProperty fechaProperty() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha.set(fecha);
	}

}
